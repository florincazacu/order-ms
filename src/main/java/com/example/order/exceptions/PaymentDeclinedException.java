package com.example.order.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class PaymentDeclinedException extends IllegalStateException {
    public PaymentDeclinedException(String s) {
        super(s);
    }
}
