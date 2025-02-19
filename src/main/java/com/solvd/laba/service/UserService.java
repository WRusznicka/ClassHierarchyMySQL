package com.solvd.laba.service;

import com.solvd.laba.dao.IUserDAO;
import com.solvd.laba.dao.jdbc.DAOFactory;
import com.solvd.laba.dao.jdbc.UserDAO;
import java.util.ResourceBundle;

public class UserService {
    public static IUserDAO getUserDAOSelect(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if (resourceBundle.getString("type").equals("jdbs")){
            return new DAOFactory().getUserDAO();
        }
        else return new com.solvd.laba.dao.mybatis.DAOFactory().getUserDAO();
    }
}
