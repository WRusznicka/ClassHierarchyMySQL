package com.solvd.laba.model.jaxb;

import com.sun.xml.txw2.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "description", "price", "duration"})
public class Service {
    private int id;
    private String name;
    private String description;
    private float price;
    private String duration;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(float price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    @XmlElement
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", duration='" + duration + '\'' +
                '}';
    }

    public Service(int id, String name, String description, float price, String duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }

    public Service() {
    }
}
