package com.solvd.laba.model.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="database")
public class Database {
    private Users users;
    private Addresses addresses;
    private Services services;
    private Invoices invoices;
    private ServicesOnInvoice servicesOnInvoice;

    public Users getUsers() {
        return users;
    }

    @XmlElement(name="users")
    public void setUsers(Users users) {
        this.users = users;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    @XmlElement(name = "addresses")
    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    public Services getServices() {
        return services;
    }

    @XmlElement(name = "services")
    public void setServices(Services services) {
        this.services = services;
    }

    public Invoices getInvoices() {
        return invoices;
    }

    @XmlElement(name = "invoices")
    public void setInvoices(Invoices invoices) {
        this.invoices = invoices;
    }

    public ServicesOnInvoice getServicesOnInvoice() {
        return servicesOnInvoice;
    }

    @XmlElement(name = "services_on_invoice")
    public void setServicesOnInvoice(ServicesOnInvoice servicesOnInvoice) {
        this.servicesOnInvoice = servicesOnInvoice;
    }

    @Override
    public String toString() {
        return "Database{" +
                "users=" + users +
                ", addresses=" + addresses +
                ", services=" + services +
                ", invoices=" + invoices +
                ", servicesOnInvoice=" + servicesOnInvoice +
                '}';
    }

    public Database(Users users, Addresses addresses, Services services, Invoices invoices, ServicesOnInvoice servicesOnInvoice) {
        this.users = users;
        this.addresses = addresses;
        this.services = services;
        this.invoices = invoices;
        this.servicesOnInvoice = servicesOnInvoice;
    }

    public Database() {
    }
}
