package com.solvd.laba.dao;

import com.solvd.laba.model.User;

import java.util.List;

public interface IUserDAO extends IBaseDao<User>{
    @Override
    User getEntityById(int id);

    @Override
    List<User> getEntities();

    @Override
    void insert(User user);

    @Override
    void update(int id, User user);

    @Override
    void delete(int id);
}
