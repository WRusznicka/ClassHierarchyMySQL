package com.solvd.laba.dao;

import com.solvd.laba.model.Processor;

import java.util.List;

public interface IProcessorDAO extends IBaseDao<Processor> {
    @Override
    Processor getEntityById(int id);

    @Override
    List<Processor> getEntities();

    @Override
    void insert(Processor processor);

    @Override
    void update(int id, Processor processor);

    @Override
    void delete(int id);
}
