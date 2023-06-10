package com.ztp.ztp.service;

import com.ztp.ztp.model.Book;
import com.ztp.ztp.model.Cart;
import com.ztp.ztp.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import reactor.core.publisher.Mono;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

@Service
@SessionScope
public class CartService {

    private final BookRepository bookRepository;
    private final Cart cart;

    public CartService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.cart = new Cart(Date.from(Instant.now()), Date.from(Instant.now()), new ArrayList<>());
    }

    public Cart getCart() {
        return cart;
    }

    public ResponseEntity<?> deleteBookFromCart(String id) {
        Optional<Book> bookToRemove = cart.getBookList().stream()
                .filter(it -> it.getId().equals(id))
                .findAny();

        if(bookToRemove.isPresent()) {
            cart.getBookList().remove(bookToRemove.get());
            cart.setUpdatedAt(Date.from(Instant.now()));
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> addBookToCart(String id) {
        Mono<Book> bookMono = bookRepository.findById(id);
        Optional<Book> book = bookMono.blockOptional();

        if(book.isPresent()) {
            cart.getBookList().add(book.get());
            cart.setUpdatedAt(Date.from(Instant.now()));
            return ResponseEntity.ok(cart);
        }

        return ResponseEntity.notFound().build();
    }
}
