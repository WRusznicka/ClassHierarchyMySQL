package com.solvd.laba.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String type;
    private int positionId;

    public User(String name, String surname, String phone, String type) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.type = type;
    }

    public User(String name, String surname, String email, String password, String phone, String type) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.type = type;
    }
}
