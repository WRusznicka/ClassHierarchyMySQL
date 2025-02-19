package com.solvd.laba.service;

import com.solvd.laba.dao.IAddressDAO;
import com.solvd.laba.dao.jdbc.AddressDAO;
import com.solvd.laba.dao.jdbc.DAOFactory;

import java.util.ResourceBundle;

public class AddressService {

    public static IAddressDAO getAddressDAOSelect(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if (resourceBundle.getString("type").equals("jdbs")){
            return new DAOFactory().getAddressDAO();
        }
        else return new com.solvd.laba.dao.mybatis.DAOFactory().getAddressDAO();
    }
}
