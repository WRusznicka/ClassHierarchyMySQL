package com.solvd.laba.dao;

import com.solvd.laba.model.Address;

import java.util.List;

public interface IAddressDAO extends IBaseDao<Address>{

    @Override
    Address getEntityById(int id);

    @Override
    List<Address> getEntities();

    @Override
    void insert(Address address);

    @Override
    void update(int id, Address address);

    @Override
    void delete(int id);
}
