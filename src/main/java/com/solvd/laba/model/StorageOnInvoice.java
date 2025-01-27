package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StorageOnInvoice {
    private int storageId;
    private int invoiceId;
    private int quantity;
}
