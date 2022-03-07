package com.example.order.service;

import com.example.order.resources.OrderRequest;

public interface ValidationService {
    void validateRequest(OrderRequest request);
}
