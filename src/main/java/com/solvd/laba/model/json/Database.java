package com.solvd.laba.model.json;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Database {
    private List<User> users;
    private List<Address> addresses;
    private List<Service> services;
    private List<Invoice> invoices;
    private List<ServiceOnInvoice> servicesOnInvoice;

}
