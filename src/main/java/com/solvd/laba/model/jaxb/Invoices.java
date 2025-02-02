package com.solvd.laba.model.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

public class Invoices {
    private List<Invoice> invoices;

    public List<Invoice> getInvoices() {
        return invoices;
    }

    @XmlElement(name="invoice")
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Invoices{" +
                "invoices=" + invoices +
                '}';
    }
}
