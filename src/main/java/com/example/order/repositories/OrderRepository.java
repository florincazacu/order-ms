package com.example.order.repositories;

import com.example.order.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {
//    List<CustomerOrder> findByCustomerId(String id);
}

