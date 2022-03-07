package com.example.order.service;

import com.example.order.entities.Card;

public interface PaymentService {
    void pay(Card card, float amount);
}
