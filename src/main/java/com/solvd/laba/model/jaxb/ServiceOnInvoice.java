package com.solvd.laba.model.jaxb;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"serviceId", "invoiceId"})
public class ServiceOnInvoice {
    private int id;
    private int serviceId;
    private int invoiceId;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    @XmlElement
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    @XmlElement
    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public String toString() {
        return "ServiceOnInvoice{" +
                "id=" + id +
                ", serviceId=" + serviceId +
                ", invoiceId=" + invoiceId +
                '}';
    }

    public ServiceOnInvoice(int id, int serviceId, int invoiceId) {
        this.id = id;
        this.serviceId = serviceId;
        this.invoiceId = invoiceId;
    }

    public ServiceOnInvoice() {
    }
}
