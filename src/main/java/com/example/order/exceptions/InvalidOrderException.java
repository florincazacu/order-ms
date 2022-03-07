package com.example.order.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class InvalidOrderException extends IllegalStateException {
    public InvalidOrderException(String message) {
        super(message);
    }
}
