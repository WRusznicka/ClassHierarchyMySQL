package com.solvd.laba.model.json;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private int id;
    private String name;
    private String description;
    private float price;
    private String duration;

}
