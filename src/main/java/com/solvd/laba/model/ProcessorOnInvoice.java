package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessorOnInvoice {
    private int processorId;
    private int invoiceId;
    private int quantity;
}
