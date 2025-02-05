package com.solvd.laba.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOnInvoice {
    private int id;

    @JsonProperty("service_id")
    private int serviceId;
    @JsonProperty("invoice_id")
    private int invoiceId;
}
