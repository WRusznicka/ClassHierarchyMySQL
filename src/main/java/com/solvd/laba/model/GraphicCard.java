package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GraphicCard {
    private String model;
    private float price;
    private int quantity;
}
