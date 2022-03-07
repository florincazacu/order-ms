package com.example.order.controller;

import com.example.order.entities.Order;
import com.example.order.resources.OrderRequest;
import com.example.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/orders")
    @ResponseBody
    public ResponseEntity<Order> postOrder(@RequestBody OrderRequest request) {

        return new ResponseEntity<>(orderService.postOrder(request), HttpStatus.OK);


//        return new ResponseEntity<>(savedOrder, HttpStatus.OK);
    }
}
