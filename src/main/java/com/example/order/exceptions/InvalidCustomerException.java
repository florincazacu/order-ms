package com.example.order.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCustomerException extends IllegalStateException {
    public InvalidCustomerException(String message) {
        super(message);
    }
}
