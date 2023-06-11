package com.ztp.ztp.controllers;

import com.ztp.ztp.model.Address;
import com.ztp.ztp.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Mono<?>> placeOrder(@RequestParam String client,
                                              @RequestBody Address address) {
        return orderService.placeOrder(client, address);
    }
}
