package com.ztp.ztp.resources;

import com.ztp.ztp.model.Cart;
import com.ztp.ztp.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartResource {

    private final CartService cartService;

    public CartResource(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public Cart getCartContent() {
        return cartService.getCart();
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> addBookToCart(@PathVariable String id) {
        return cartService.addBookToCart(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookFromCart(@PathVariable String id) {
        return cartService.deleteBookFromCart(id);
    }
}
