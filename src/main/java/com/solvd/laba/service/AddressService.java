package com.solvd.laba.service;

import com.solvd.laba.dao.IAddressDAO;
import com.solvd.laba.dao.jdbc.AddressDAO;

import java.util.ResourceBundle;

public class AddressService {

    public static IAddressDAO getAddressDAOSelect(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if (resourceBundle.getString("type").equals("jdbs")){
            return new AddressDAO();
        }
        else return new com.solvd.laba.dao.mybatis.AddressDAO();
    }
}
