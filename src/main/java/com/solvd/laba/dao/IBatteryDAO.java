package com.solvd.laba.dao;

import com.solvd.laba.model.Battery;

import java.util.List;

public interface IBatteryDAO extends IBaseDao<Battery>{
    @Override
    Battery getEntityById(int id);

    @Override
    List<Battery> getEntities();

    @Override
    void insert(Battery battery);

    @Override
    void update(int id, Battery battery);

    @Override
    void delete(int id);
}
