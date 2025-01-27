package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Battery {
    private String material;
    private int numberOfCells;
    private int capacity;
    private String batteryPowerLevel;
    private int batteryPower;
    private float price;
    private int quantity;
}
