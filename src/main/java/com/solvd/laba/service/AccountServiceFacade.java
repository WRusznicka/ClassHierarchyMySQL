package com.solvd.laba.service;

import com.solvd.laba.dao.IAddressDAO;
import com.solvd.laba.dao.IUserDAO;
import com.solvd.laba.model.Address;
import com.solvd.laba.model.User;

import java.util.List;

public class AccountServiceFacade {
    private final UserService userService = new UserService();
    private final AddressService addressService = new AddressService();

    public String getAccount(int id){
        IUserDAO userDAO = UserService.getUserDAOSelect();
        IAddressDAO addressDAO = AddressService.getAddressDAOSelect();
        StringBuilder builder = new StringBuilder();

        User user = userDAO.getEntityById(id);
        if (user!=null){
            builder.append(user.toString()).append("\n");
        }else{
            builder.append("User not found");
            return builder.toString();
        }
        List<Address> addresses = addressDAO.getEntitiesByUser(id);
        builder.append("User's addresses: ");
        addresses.stream().forEach(e->builder.append(e.toString()));
        return builder.toString();
    }
}
