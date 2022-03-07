package com.example.order.data.seed;

import com.example.order.entities.Address;
import com.example.order.entities.Card;
import com.example.order.entities.Customer;
import com.example.order.entities.Item;
import com.example.order.resources.OrderRequest;
import com.example.order.service.CustomerService;
import com.example.order.service.ItemService;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedDataLoader implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) {
        loadData();
    }

    public void loadData() {
        loadItems();
        loadCustomers();
        orderItem();
    }

    private void loadItems() {
        try {
            Item item = new Item();
            item.setName("Samsung Galaxy S22");
            item.setStock(3);
            item.setPrice(1999.99);

            itemService.save(item);

            item = new Item();
            item.setName("Google Pixel 6");
            item.setStock(2);
            item.setPrice(2999.0);

            itemService.save(item);

            item = new Item();
            item.setName("Lenovo IdeaPad 5");
            item.setStock(2);
            item.setPrice(2999.0);

            itemService.save(item);
        } catch (Exception e) {
            System.out.println("Cannot save items: " + e.getMessage());
        }
    }

    private void loadCustomers() {
        try {
            Customer customer = new Customer();

            customer.setEmail("john.doe@domain.com");
            customer.setFirstName("John");
            customer.setLastName("Doe");

            Address address = new Address();

            address.setCountry("Romania");
            address.setCity("Bucharest");
            address.setPostcode("1234");
            address.setStreet("Boulevard");
            address.setNumber("1");

            customer.getAddresses().add(address);

            Card card = new Card();
            card.setCardHolder("John Doe");
            card.setNumber("0000 1111 2222 3333 4444");
            card.setExpires("12/22");
            card.setCcv("123");
            card.setBalance(10000F);

            customer.setCard(card);

            System.out.println("Customer: " + customer);

            customerService.save(customer);
        } catch (Exception e) {
            System.out.println("Cannot save customers: " + e.getMessage());
        }
    }

    private void orderItem() {
        try {
            OrderRequest request = new OrderRequest();

            request.setCustomerId(1L);
            request.setAddressId(1L);
            request.setCardId(1L);

            Item item = new Item();
            item.setId(1L);
            item.setStock(1);
            request.getOrderedItems().add(item);

            item = new Item();
            item.setId(3L);
            item.setStock(2);
            request.getOrderedItems().add(item);

            orderService.postOrder(request);
        }  catch (Exception e) {
            System.out.println("Cannot save order: " + e.getMessage());
        }
    }
}
