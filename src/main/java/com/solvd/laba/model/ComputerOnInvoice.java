package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComputerOnInvoice {
    private int computerId;
    private int invoiceId;
    private int quantity;
}
