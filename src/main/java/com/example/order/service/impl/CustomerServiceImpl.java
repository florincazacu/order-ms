package com.example.order.service.impl;

import com.example.order.entities.Customer;
import com.example.order.repositories.CustomerRepository;
import com.example.order.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Set<Customer> findAll() {
        Set<Customer> customers = new HashSet<>();
        customerRepository.findAll().forEach(customers::add);

        return customers;
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> authorOptional = customerRepository.findById(id);
        return authorOptional.orElse(null);
    }

    @Override
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public void delete(Customer entity) {
        customerRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Customer entity) {
        Customer customer = findById(id);

        if (customer == null) {
            save(entity);
        } else {
            if (entity.getEmail() != null) {
                customer.setEmail(entity.getEmail());
            }
            if (entity.getFirstName() != null) {
                customer.setFirstName(entity.getFirstName());
            }
            if (entity.getLastName() != null) {
                customer.setLastName(entity.getLastName());
            }
            if (!CollectionUtils.isEmpty(entity.getAddresses())) {
                customer.getAddresses().addAll(entity.getAddresses());
            }
            if (entity.getCard() != null) {
                customer.setCard(entity.getCard());
            }
            save(customer);
        }
    }
}
