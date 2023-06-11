package com.ztp.ztp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private String city;
    private String postalCode;
    private String street;
    private String houseNumber;
    private String flatNumber;
}
