package com.solvd.laba.dao;

public interface IDAOFactory {
    IUserDAO getUserDAO();
    IAddressDAO getAddressDAO();
}
