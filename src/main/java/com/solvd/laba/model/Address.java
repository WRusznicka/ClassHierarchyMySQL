package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String country;
    private String state;
    private String city;
    private String addressLine;
    private String zipCode;
    private long usersId;
}
