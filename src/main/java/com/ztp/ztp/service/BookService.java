package com.ztp.ztp.service;

import com.ztp.ztp.model.Book;
import com.ztp.ztp.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import java.util.Date;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Flux<Book> getBooks(String author, String title, Date releaseDate) {
        String authorNotNull = (author != null) ? author : "";
        String titleNotNull = (title != null) ? title : "";
        if(releaseDate != null )
        {
            return bookRepository.findAllByAuthorContainingAndTitleContainingAndReleaseDate(authorNotNull, titleNotNull, releaseDate);
        }
        return bookRepository.findAllByAuthorContainingAndTitleContaining(authorNotNull, titleNotNull);
    }
}
