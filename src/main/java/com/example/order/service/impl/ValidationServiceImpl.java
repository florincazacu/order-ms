package com.example.order.service.impl;

import com.example.order.exceptions.InvalidOrderException;
import com.example.order.resources.OrderRequest;
import com.example.order.service.ValidationService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public void validateRequest(OrderRequest request) {
        if (request.getAddressId() == null || request.getCustomerId() == null ||
                request.getCardId() == null || CollectionUtils.isEmpty(request.getOrderedItems())) {
            throw new InvalidOrderException("Invalid order request. Order requires customer, address, card and items.");
        }
    }
}
