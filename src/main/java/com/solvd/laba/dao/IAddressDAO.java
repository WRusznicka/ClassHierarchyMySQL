package com.solvd.laba.dao;

import com.solvd.laba.model.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IAddressDAO extends IBaseDao<Address>{

    @Select(
            "SELECT * FROM mydb.addresses WHERE id = #{idx}")
    @Results(value = {
            @Result(property="country", column = "country"),
            @Result(property="state", column = "state"),
            @Result(property="city", column = "city"),
            @Result(property="addressLine", column = "address_line"),
            @Result(property="zipCode", column = "zip_code"),
            @Result(property="usersId", column = "users_id"),
    })
    @Override
    Address getEntityById(int idx);

    @Select(
            "select * from mydb.addresses")
    @Results(value = {
            @Result(property="country", column = "country"),
            @Result(property="state", column = "state"),
            @Result(property="city", column = "city"),
            @Result(property="addressLine", column = "address_line"),
            @Result(property="zipCode", column = "zip_code"),
            @Result(property="usersId", column = "users_id"),
    })
    @Override
    List<Address> getEntities();

    @Select(
            "select * from mydb.addresses WHERE users_id = #{idx}")
    @Results(value = {
            @Result(property="country", column = "country"),
            @Result(property="state", column = "state"),
            @Result(property="city", column = "city"),
            @Result(property="addressLine", column = "address_line"),
            @Result(property="zipCode", column = "zip_code"),
            @Result(property="usersId", column = "users_id"),
    })
    List<Address> getEntitiesByUser(int idx);

    @Insert("insert into mydb.addresses(country, state, city, address_line, zip_code, users_id) VALUES(#{country},#{state},#{city},#{addressLine},#{zipCode},#{usersId})")
    @Override
    void insert(Address address);

    @Update("UPDATE mydb.addresses SET country = #{address.country}, state = #{address.state}, city = #{address.city}, address_line = #{address.addressLine}, zip_code = #{address.zipCode}, users_id = #{address.usersId} WHERE id = #{id}")
    @Override
    void update(@Param("id") int id, @Param("address") Address address);

    @Delete("DELETE from mydb.addresses where id=#{id}")
    @Override
    void delete(int id);
}
