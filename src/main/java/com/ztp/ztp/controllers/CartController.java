package com.ztp.ztp.controllers;

import com.ztp.ztp.model.Cart;
import com.ztp.ztp.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public Cart getCartContent() {
        return cartService.getCart();
    }

    @PostMapping("/{isbnNumber}")
    public ResponseEntity<Cart> addBookToCart(@PathVariable String isbnNumber) {
        return cartService.addBookToCart(isbnNumber);
    }

    @DeleteMapping("/{isbnNumber}")
    public ResponseEntity<?> deleteBookFromCart(@PathVariable String isbnNumber) {
        return cartService.deleteBookFromCart(isbnNumber);
    }
}
