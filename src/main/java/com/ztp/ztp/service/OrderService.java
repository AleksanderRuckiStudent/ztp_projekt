package com.ztp.ztp.service;

import com.ztp.ztp.model.Address;
import com.ztp.ztp.model.Cart;
import com.ztp.ztp.model.DeliveryType;
import com.ztp.ztp.model.Order;
import com.ztp.ztp.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

@Service
@Transactional
public class OrderService {

    private static final String EMPTY_CART = "An order cannot be placed for a empty cart";

    private final CartService cartService;
    private final OrderRepository orderRepository;

    public OrderService(CartService cartService,
                        OrderRepository orderRepository) {
        this.cartService = cartService;
        this.orderRepository = orderRepository;
    }

    public ResponseEntity<Mono<?>> placeOrder(String client, Address address) {
        Cart cart = cartService.getCart();

        if (cart.getBookList().isEmpty()) {
            return ResponseEntity.badRequest().body(Mono.just(EMPTY_CART));
        }

        Order order = new Order(cart.getCreatedAt(), cart.getUpdatedAt(), cart.getBookList(),
                client, address, Date.from(Instant.now()), null, getRandomDeliveryType());

        Mono<Order> dbOrder = orderRepository.insert(order);
        cartService.clearCart();
        return ResponseEntity.ok(dbOrder);
    }

    private DeliveryType getRandomDeliveryType() {
        DeliveryType[] deliveryTypes = DeliveryType.values();
        int randomIndex = new Random().nextInt(deliveryTypes.length);
        return deliveryTypes[randomIndex];
    }
}
