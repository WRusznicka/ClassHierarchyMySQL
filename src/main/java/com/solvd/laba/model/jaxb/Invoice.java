package com.solvd.laba.model.jaxb;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;

@XmlType(propOrder = {"totalPrice", "date", "usersId"})
public class Invoice {
    private int id;
    private float totalPrice;
    private Date date;
    private long usersId;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    @XmlElement
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDate(Date date) {
        this.date = date;
    }

    public long getUsersId() {
        return usersId;
    }

    @XmlElement
    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", date=" + date +
                ", usersId=" + usersId +
                '}';
    }

    public Invoice(int id, float totalPrice, Date date, long usersId) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.date = date;
        this.usersId = usersId;
    }

    public Invoice() {
    }
}
