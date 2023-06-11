package com.ztp.ztp.controllers;

import com.ztp.ztp.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/books")
public class BookController {

    final private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Flux<?>> getBooks(@RequestParam(required = false) String author,
                                            @RequestParam(required = false) String title,
                                            @RequestParam(required = false) String releaseDate) {
        return bookService.getBooks(author, title, releaseDate);

    }
}