package com.solvd.laba.model.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

public class ServicesOnInvoice {
    private List<ServiceOnInvoice> services;

    public List<ServiceOnInvoice> getServices() {
        return services;
    }

    @XmlElement(name="service_on_invoice")
    public void setServices(List<ServiceOnInvoice> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "ServicesOnInvoice{" +
                "services=" + services +
                '}';
    }
}
