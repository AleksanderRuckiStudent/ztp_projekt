package com.ztp.ztp.repository;

import com.ztp.ztp.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import java.util.Date;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
    Flux<Book> findAll();
    Flux<Book> findAllByAuthorContainingAndTitleContaining(String author, String title);
    Flux<Book> findAllByAuthorContainingAndTitleContainingAndReleaseDateBetween(String author, String title, Date startYear, Date endYear);

}
