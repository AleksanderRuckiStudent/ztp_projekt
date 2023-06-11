package com.ztp.ztp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Cart {
    protected Date createdAt;
    protected Date updatedAt;
    protected List<Book> bookList;

    public Cart(Date createdAt, Date updatedAt, List<Book> bookList) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.bookList = bookList;
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }
}
