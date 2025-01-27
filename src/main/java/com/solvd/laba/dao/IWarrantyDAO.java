package com.solvd.laba.dao;

import com.solvd.laba.model.Warranty;

import java.util.List;

public interface IWarrantyDAO extends IBaseDao<Warranty>{
    @Override
    Warranty getEntityById(int id);

    @Override
    List<Warranty> getEntities();

    @Override
    void insert(Warranty warranty);

    @Override
    void update(int id, Warranty warranty);

    @Override
    void delete(int id);
}
