package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RAM {
    private String type;
    private int capacity;
    private float price;
    private int quantity;
}
