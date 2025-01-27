package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisplayOnInvoice {
    private int displayId;
    private int invoiceId;
    private int quantity;
}
