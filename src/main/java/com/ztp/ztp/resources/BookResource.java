package com.ztp.ztp.resources;

import com.ztp.ztp.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/books")
public class BookResource {

    final private BookService bookService;


    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Flux<?>> getBooks(@RequestParam(required = false) String author,
                                            @RequestParam(required = false) String title,
                                            @RequestParam(required = false) String releaseDate) {
        return bookService.getBooks(author, title, releaseDate);

    }

}