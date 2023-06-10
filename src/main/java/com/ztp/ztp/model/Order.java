package com.ztp.ztp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document("orders")
public class Order extends Cart {
    private String id;
    private String user;
    private Date placedAt;
    private Date sentAt;
    private DeliveryType deliveryType;

    public Order(Date createdAt, Date updatedAt, List<Book> bookList, String user,
                 Date placedAt, Date sentAt, DeliveryType deliveryType) {
        super(createdAt, updatedAt, bookList);
        this.user = user;
        this.placedAt = placedAt;
        this.sentAt = sentAt;
        this.deliveryType = deliveryType;
    }
}
