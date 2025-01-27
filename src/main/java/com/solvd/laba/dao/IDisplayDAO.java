package com.solvd.laba.dao;

import com.solvd.laba.model.Display;

import java.util.List;

public interface IDisplayDAO extends IBaseDao<Display> {
    @Override
    Display getEntityById(int id);

    @Override
    List<Display> getEntities();

    @Override
    void insert(Display display);

    @Override
    void update(int id, Display display);

    @Override
    void delete(int id);
}
