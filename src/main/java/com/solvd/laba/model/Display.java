package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Display {
    private String resolution;
    private String type;
    private float size;
    private float price;
    private int quantity;
}
