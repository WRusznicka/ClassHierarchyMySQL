package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private String name;
    private String description;
    private float price;
    private String duration;
}
