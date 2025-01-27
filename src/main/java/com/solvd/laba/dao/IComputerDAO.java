package com.solvd.laba.dao;

import com.solvd.laba.model.Computer;

import java.util.List;

public interface IComputerDAO extends IBaseDao<Computer> {
    @Override
    Computer getEntityById(int id);

    @Override
    List<Computer> getEntities();

    @Override
    void insert(Computer computer);

    @Override
    void update(int id, Computer computer);

    @Override
    void delete(int id);
}
