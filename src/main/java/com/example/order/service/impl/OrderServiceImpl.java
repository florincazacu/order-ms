package com.example.order.service.impl;

import com.example.order.entities.*;
import com.example.order.exceptions.InvalidCustomerException;
import com.example.order.repositories.OrderRepository;
import com.example.order.resources.OrderRequest;
import com.example.order.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private ValidationService validationService;

    @Autowired
    private OrderRepository customerOrderRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public Order postOrder(OrderRequest request) {
        LOG.info("Received request: " + request);

        validationService.validateRequest(request);

        Customer customer = customerService.findById(request.getCustomerId());

        if (customer == null) {
            throw new InvalidCustomerException("Customer not found");
        }

        Address address = addressService.getAddressForCustomer(customer.getId(), request.getAddressId());

        if (address == null) {
            throw new InvalidCustomerException("Cannot find address for customer");
        }

        Card card = customer.getCard();

        List<Item> items = new ArrayList<>();

        for (Item item : request.getOrderedItems()) {
            Item foundItem = itemService.findById(item.getId());
            if (foundItem != null) {
                int stock = foundItem.getStock();
                if (item.getStock() <= foundItem.getStock()) {
                    item.setPrice(foundItem.getPrice());
                    stock -= item.getStock();
                    foundItem.setStock(stock);
                    itemService.save(foundItem);
                    items.add(item);
                }
            }
        }

        float amount = calculateTotal(items);

        paymentService.pay(card, amount);

        customer.setCard(card);

        customerService.save(customer);

        Order order = new Order(
                customer,
                address,
                card,
                items,
                Calendar.getInstance().getTime(),
                amount);
        LOG.info("Received data: " + order);

        Order savedOrder = customerOrderRepository.save(order);
        LOG.info("Saved order: " + savedOrder);

        return order;
    }

    private float calculateTotal(List<Item> items) {
        float amount = 0F;
        amount += items.stream().mapToDouble(i -> i.getStock() * i.getPrice()).sum();
        return amount;
    }
}
