package com.ztp.ztp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Document("books")
public class Book {
    @Id
    private String id;
    private String isbnNumber;
    private String title;
    private String author;
    private Date releaseDate;
}
