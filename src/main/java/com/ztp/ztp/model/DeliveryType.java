package com.ztp.ztp.model;

import lombok.Getter;

import java.math.BigDecimal;

public enum DeliveryType {
    SELF_PICKUP(BigDecimal.valueOf(0L)),
    POST(BigDecimal.valueOf(5L)),
    COURIER(BigDecimal.valueOf(10L));

    @Getter
    private BigDecimal price;

    DeliveryType(BigDecimal price) {
    }
}
