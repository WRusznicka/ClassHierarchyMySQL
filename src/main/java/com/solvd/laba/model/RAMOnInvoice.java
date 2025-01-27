package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RAMOnInvoice {
    private int ramId;
    private int invoiceId;
    private int quantity;
}
