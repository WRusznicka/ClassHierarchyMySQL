package com.solvd.laba.model.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

public class Addresses {
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    @XmlElement(name = "address")
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "addresses=" + addresses +
                '}';
    }
}
