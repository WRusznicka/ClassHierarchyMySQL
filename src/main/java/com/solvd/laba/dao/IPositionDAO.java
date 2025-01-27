package com.solvd.laba.dao;

import com.solvd.laba.model.Position;

import java.util.List;

public interface IPositionDAO extends IBaseDao<Position> {

    @Override
    Position getEntityById(int id);

    @Override
    List<Position> getEntities();

    @Override
    void insert(Position position);

    @Override
    void update(int id, Position position);

    @Override
    void delete(int id);
}
