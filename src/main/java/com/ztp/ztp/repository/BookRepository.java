package com.ztp.ztp.repository;

import com.ztp.ztp.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
    Flux<Book> findAll();
}
