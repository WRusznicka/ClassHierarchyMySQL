package com.solvd.laba.model.json;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    private int id;
    private float totalPrice;
    private Date date;
    private int usersId;
}
