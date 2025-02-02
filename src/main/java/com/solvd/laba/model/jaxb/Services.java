package com.solvd.laba.model.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

public class Services {
    private List<Service> services;

    public List<Service> getServices() {
        return services;
    }

    @XmlElement(name = "service")
    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Services{" +
                "services=" + services +
                '}';
    }
}
