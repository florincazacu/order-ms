package com.example.order.service;

import com.example.order.entities.Order;
import com.example.order.resources.OrderRequest;

public interface OrderService {
    Order postOrder(OrderRequest request);
}
