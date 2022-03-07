package com.example.order.service.impl;

import com.example.order.entities.Address;
import com.example.order.entities.Customer;
import com.example.order.repositories.AddressRepository;
import com.example.order.repositories.CustomerRepository;
import com.example.order.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final CustomerRepository customerRepository;

    public AddressServiceImpl(AddressRepository addressRepository, CustomerRepository customerRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Set<Address> findAll() {
        Set<Address> addresses = new HashSet<>();
        addressRepository.findAll().forEach(addresses::add);

        return addresses;
    }

    @Override
    public Address findById(Long aLong) {
        return null;
    }

    @Override
    public Address save(Address entity) {
        return null;
    }

    @Override
    public void delete(Address entity) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void update(Long aLong, Address entity) {

    }

    @Override
    public Address getAddressForCustomer(Long customerId, Long addressId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);

        Address address = null;

        if (customer != null) {
            address = customer.getAddresses().stream().filter(a ->
                    a.getId().equals(addressId)).findFirst().orElse(null);
        }

        return address;
    }
}
