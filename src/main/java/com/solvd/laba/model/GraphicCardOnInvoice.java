package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GraphicCardOnInvoice {
    private int graphicCardId;
    private int invoiceId;
    private int quantity;
}
