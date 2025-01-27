package com.solvd.laba.model;

import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    private float totalPrice;
    private Date date;
    private long usersId;
}
