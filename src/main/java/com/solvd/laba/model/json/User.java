package com.solvd.laba.model.json;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String type;
    private Position position;

}
