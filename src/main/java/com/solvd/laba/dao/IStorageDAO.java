package com.solvd.laba.dao;

import com.solvd.laba.model.Storage;

import java.util.List;

public interface IStorageDAO extends IBaseDao<Storage> {
    @Override
    Storage getEntityById(int id);

    @Override
    List<Storage> getEntities();

    @Override
    void insert(Storage storage);

    @Override
    void update(int id, Storage storage);

    @Override
    void delete(int id);
}
