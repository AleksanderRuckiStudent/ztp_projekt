package com.ztp.ztp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document("books")
public class Book {
    private String id;
    private String title;
    private String author;
    private Date releaseDate;
    private String isbnNumber;

    public Book(String title, String author, Date releaseDate, String isbnNumber) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.isbnNumber = isbnNumber;
    }
}
