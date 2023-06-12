package com.ztp.ztp.controllers;

import com.ztp.ztp.model.Address;
import com.ztp.ztp.model.Order;
import com.ztp.ztp.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @GetMapping
    public Flux<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }
}
