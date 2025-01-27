package com.solvd.laba.dao;

import com.solvd.laba.model.Service;

import java.util.List;

public interface IServiceDAO extends IBaseDao<Service> {
    @Override
    Service getEntityById(int id);

    @Override
    List<Service> getEntities();

    @Override
    void insert(Service service);

    @Override
    void update(int id, Service service);

    @Override
    void delete(int id);
}
