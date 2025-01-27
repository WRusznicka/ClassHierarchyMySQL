package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private String type;
    private String capacity;
    private float price;
    private int quantity;
}
