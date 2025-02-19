package com.solvd.laba.dao.jdbc;

import com.solvd.laba.dao.IAddressDAO;
import com.solvd.laba.dao.IDAOFactory;
import com.solvd.laba.dao.IUserDAO;

public class DAOFactory implements IDAOFactory {
    @Override
    public IUserDAO getUserDAO() {
        return new UserDAO();
    }

    @Override
    public IAddressDAO getAddressDAO() {
        return new AddressDAO();
    }
}
