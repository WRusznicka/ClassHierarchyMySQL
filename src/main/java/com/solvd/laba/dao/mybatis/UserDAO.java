package com.solvd.laba.dao.mybatis;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.MyBatisConf;
import com.solvd.laba.dao.IUserDAO;
import com.solvd.laba.model.Address;
import com.solvd.laba.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDAO implements IUserDAO {

    public static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    static SqlSessionFactory sqlSessionFactory = MyBatisConf.buildSqlSessionFactory();

    @Override
    public User getEntityById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            User user = session.selectOne("com.solvd.laba.dao.IUserDAO.getEntityById", id);
            return user;
        }
    }

    @Override
    public List<User> getEntities() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            List<User> users = session.selectList("com.solvd.laba.dao.IUserDAO.getEntities");
            return users;
        }
    }

    @Override
    public void insert(User user) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.solvd.laba.dao.IUserDAO.insert", user);
            session.commit();
        }
    }

    @Override
    public void update(int id, User user) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            session.update("com.solvd.laba.dao.IUserDAO.update", Map.of("id",id,"user",user));
            session.commit();
        }
    }

    @Override
    public void delete(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("com.solvd.laba.dao.IUserDAO.delete", id);
            session.commit();
        }
    }
}
