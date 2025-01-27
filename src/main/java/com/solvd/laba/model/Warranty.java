package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Warranty {
    private int typeOfWarrantyId;
    private String duration;
    private float extraPrice;
}
