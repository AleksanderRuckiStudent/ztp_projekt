package com.ztp.ztp.service;

import com.ztp.ztp.model.Book;
import com.ztp.ztp.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import java.util.Calendar;
import java.util.Date;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<Flux<?>> getBooks(String author, String title, String releaseDate) {
        String authorNotNull = (author != null) ? author : "";
        String titleNotNull = (title != null) ? title : "";
        if(releaseDate != null )
        {
            try {
                int releaseYear = Integer.parseInt(releaseDate);
                Flux<Book> books = bookRepository.findAllByAuthorContainingAndTitleContainingAndReleaseDateBetween(authorNotNull, titleNotNull, yearToDate(releaseYear), yearToDate(releaseYear + 1));
                return ResponseEntity.ok(books);
            }
            catch (NumberFormatException e) {
                String errorMessage = "Invalid releaseDate format. Please provide the releaseDate parameter in the format 'yyyy'.";
                return ResponseEntity.badRequest().body(Flux.just(errorMessage));
            }
        }
        Flux<Book> books = bookRepository.findAllByAuthorContainingAndTitleContaining(authorNotNull, titleNotNull);
        return ResponseEntity.ok(books);
    }

    Date yearToDate(int releaseYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, releaseYear);
        return calendar.getTime();
    }
}
