package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IUserDAO;
import com.solvd.laba.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    public static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public User getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.users WHERE id = ?";
        User user = new User();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setPhone(resultSet.getString("phone"));
                user.setType(resultSet.getString("type"));
                user.setPositionId(resultSet.getInt("positions_id"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return user;
    }

    @Override
    public List<User> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.users";
        List<User> users = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setPhone(resultSet.getString("phone"));
                user.setType(resultSet.getString("type"));
                user.setPositionId(resultSet.getInt("positions_id"));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return users;
    }

    @Override
    public void insert(User user) {
        Connection connection = connectionPool.getConnection();
        if(user.getPositionId() != 0) {
            String sql = "INSERT INTO mydb.users(name, surname, email, password, phone, type, positions_id) VALUES (?,?,?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getSurname());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhone());
                preparedStatement.setString(6, user.getType());
                preparedStatement.setInt(7, user.getPositionId());
                preparedStatement.execute();
            } catch (SQLException e) {
                LOGGER.error("Error");
            } finally {
                connectionPool.releaseConnection(connection);
            }
        }
        else{
            String sql = "INSERT INTO mydb.users(name, surname, email, password, phone, type) VALUES (?,?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getSurname());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhone());
                preparedStatement.setString(6, user.getType());
                preparedStatement.execute();
            } catch (SQLException e) {
                LOGGER.error("Error");
            } finally {
                connectionPool.releaseConnection(connection);
            }
        }
    }

    @Override
    public void update(int id, User user) {
        Connection connection = connectionPool.getConnection();
        if(user.getPositionId() != 0){
            String sql = "UPDATE mydb.users SET name = ?, surname = ?, email = ?, password = ?, phone = ?, type = ?, positions_id = ? WHERE id = ?";
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getSurname());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhone());
                preparedStatement.setString(6, user.getType());
                preparedStatement.setInt(7, user.getPositionId());
                preparedStatement.setInt(8, id);
                preparedStatement.execute();
            } catch (SQLException e) {
                LOGGER.error("Error");
            } finally {
                connectionPool.releaseConnection(connection);
            }
        }
        else {
            String sql = "UPDATE mydb.users SET name = ?, surname = ?, email = ?, password = ?, phone = ?, type = ? WHERE id = ?";
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getSurname());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhone());
                preparedStatement.setString(6, user.getType());
                preparedStatement.setInt(7, id);
                preparedStatement.execute();
            } catch (SQLException e) {
                LOGGER.error("Error");
            } finally {
                connectionPool.releaseConnection(connection);
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "DELETE from mydb.users where id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
