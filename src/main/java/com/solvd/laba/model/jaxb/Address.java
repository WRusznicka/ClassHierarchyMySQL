package com.solvd.laba.model.jaxb;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"country", "state", "city", "addressLine", "zipCode", "usersId"})
public class Address {
    private int id;
    private String country;
    private String state;
    private String city;
    private String addressLine;
    private String zipCode;
    private int usersId;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    @XmlElement
    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    @XmlElement
    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine() {
        return addressLine;
    }

    @XmlElement
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getZipCode() {
        return zipCode;
    }

    @XmlElement
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getUsersId() {
        return usersId;
    }

    @XmlElement
    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", addressLine='" + addressLine + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", usersId=" + usersId +
                '}';
    }

    public Address(int id, String country, String state, String city, String addressLine, String zipCode, int usersId) {
        this.id = id;
        this.country = country;
        this.state = state;
        this.city = city;
        this.addressLine = addressLine;
        this.zipCode = zipCode;
        this.usersId = usersId;
    }

    public Address() {
    }
}
