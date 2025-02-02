package com.solvd.laba.model.jaxb;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"title", "salary", "employmentType"})
public class Position {
    private String title;
    private String salary;
    private String employmentType;

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    @XmlElement
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    @XmlElement
    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", salary='" + salary + '\'' +
                ", employmentType='" + employmentType + '\'' +
                '}';
    }

    public Position(String title, String salary, String employmentType) {
        this.title = title;
        this.salary = salary;
        this.employmentType = employmentType;
    }

    public Position() {
    }
}
