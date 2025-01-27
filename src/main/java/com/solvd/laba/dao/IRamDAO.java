package com.solvd.laba.dao;

import com.solvd.laba.model.RAM;

import java.util.List;

public interface IRamDAO extends IBaseDao<RAM> {
    @Override
    RAM getEntityById(int id);

    @Override
    List<RAM> getEntities();

    @Override
    void insert(RAM ram);

    @Override
    void update(int id, RAM ram);

    @Override
    void delete(int id);
}
