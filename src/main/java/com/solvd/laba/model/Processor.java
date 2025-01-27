package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Processor {
    private String model;
    private float maxFrequency;
    private int numberOfCores;
    private float cache;
    private float price;
    private int quantity;
}
