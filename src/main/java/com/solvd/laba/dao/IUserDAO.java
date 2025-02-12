package com.solvd.laba.dao;

import com.solvd.laba.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDAO extends IBaseDao<User>{
    @Select(
            "SELECT * FROM mydb.users WHERE id = #{idx}")
    @Results(value = {
            @Result(property="name", column = "name"),
            @Result(property="surname", column = "surname"),
            @Result(property="email", column = "email"),
            @Result(property="password", column = "password"),
            @Result(property="phone", column = "phone"),
            @Result(property="type", column = "type"),
            @Result(property="positionId", column = "positions_id"),
    })
    @Override
    User getEntityById(int idx);

    @Select(
            "select * from mydb.users")
    @Results(value = {
            @Result(property="name", column = "name"),
            @Result(property="surname", column = "surname"),
            @Result(property="email", column = "email"),
            @Result(property="password", column = "password"),
            @Result(property="phone", column = "phone"),
            @Result(property="type", column = "type"),
            @Result(property="positionId", column = "positions_id"),
    })
    @Override
    List<User> getEntities();

    @Insert("insert into mydb.users(name, surname, email, password, phone, type, positions_id) VALUES(#{name},#{surname},#{email},#{password},#{phone},#{type},#{positionId})")
    @Override
    void insert(User user);

    @Update("UPDATE mydb.users SET name = #{user.name}, surname = #{user.surname}, email = #{user.email}, password = #{user.password}, phone = #{user.phone}, type = #{user.type}, positions_id=#{user.positionId} WHERE id = #{id}")
    @Override
    void update(@Param("id") int id, @Param("user") User user);

    @Delete("DELETE from mydb.users where id=#{id}")
    @Override
    void delete(int id);
}
