package com.ztp.ztp.model;

import java.math.BigDecimal;

public enum DeliveryType {
    POST(BigDecimal.valueOf(5L)),
    COURIER(BigDecimal.valueOf(10L)),
    FAST_24H_DELIVERY(BigDecimal.valueOf(20L));

    private BigDecimal price;

    DeliveryType(BigDecimal price) {
    }
}
