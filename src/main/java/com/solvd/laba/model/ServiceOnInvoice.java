package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOnInvoice {
    private int serviceId;
    private int invoiceId;
}
