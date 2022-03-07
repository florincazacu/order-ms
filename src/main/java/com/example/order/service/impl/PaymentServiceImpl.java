package com.example.order.service.impl;

import com.example.order.entities.Card;
import com.example.order.exceptions.PaymentDeclinedException;
import com.example.order.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void pay(Card card, float amount) {
        if (amount > card.getBalance()) {
            throw new PaymentDeclinedException(String.format("Insufficient funds, amount: %S, funds: %s", amount, card.getBalance()));
        }
        float balance = card.getBalance();
        balance -= amount;
        card.setBalance(balance);

    }
}
