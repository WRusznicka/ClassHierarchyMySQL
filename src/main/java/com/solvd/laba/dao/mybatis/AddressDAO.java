package com.solvd.laba.dao.mybatis;

import com.solvd.laba.MyBatisConf;
import com.solvd.laba.dao.IAddressDAO;
import com.solvd.laba.model.Address;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddressDAO implements IAddressDAO {

    public static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);
    static SqlSessionFactory sqlSessionFactory
            = MyBatisConf.buildSqlSessionFactory();

    @Override
    public Address getEntityById(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            Address address = session.selectOne("com.solvd.laba.dao.IAddressDAO.getEntityById", id);
            return address;
        }
    }

    @Override
    public List<Address> getEntities() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            List<Address> addresses = session.selectList("com.solvd.laba.dao.IAddressDAO.getEntities");
            return addresses;
        }
    }

    @Override
    public void insert(Address address) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.solvd.laba.dao.IAddressDAO.insert", address);
            session.commit();
        }
    }

    @Override
    public void update(int id, Address address) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            session.update("com.solvd.laba.dao.IAddressDAO.update", Map.of("id",id,"address",address));
            session.commit();
        }
    }

    @Override
    public void delete(int id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("com.solvd.laba.dao.IAddressDAO.delete", id);
            session.commit();
        }
    }
}
