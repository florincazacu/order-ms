package com.example.order.service;

import com.example.order.entities.Address;


public interface AddressService extends CrudService<Address, Long> {

    Address getAddressForCustomer(Long customerId, Long addressId);
}
