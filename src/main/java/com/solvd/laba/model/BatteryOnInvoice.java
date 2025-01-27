package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatteryOnInvoice {
    private int batteryId;
    private int invoiceId;
    private int quantity;
}
