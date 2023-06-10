package com.ztp.ztp.resources;

import com.ztp.ztp.model.Book;
import com.ztp.ztp.service.BookService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@RestController
@RequestMapping("/books")
public class BookResource {

    final private BookService bookService;


    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Flux<Book> getBooks(@RequestParam(required = false) String author,
                               @RequestParam(required = false) String title,
                               @RequestParam(required = false)
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate) {
        return bookService.getAllBooks();
    }
}