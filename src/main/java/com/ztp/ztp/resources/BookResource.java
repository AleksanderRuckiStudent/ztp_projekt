package com.ztp.ztp.resources;

import com.ztp.ztp.model.Book;
import com.ztp.ztp.service.BookService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.text.ParseException;
import java.util.Date;

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
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date releaseDate) {
            return bookService.getBooks(author, title, releaseDate);

    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity<String> handleParseException(ParseException ex) {
        String errorMessage = "Invalid date format. Please provide the releaseDate parameter in the format 'yyyy-MM-dd'.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}