package com.solvd.laba.model.json;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private int id;
    private String country;
    private String state;
    private String city;
    private String addressLine;
    private String zipCode;
    private int usersId;
}
