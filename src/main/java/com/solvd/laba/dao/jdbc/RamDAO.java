package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IRamDAO;
import com.solvd.laba.model.RAM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RamDAO implements IRamDAO {

    public static final Logger LOGGER = LogManager.getLogger(RamDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public RAM getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.rams WHERE id = ?";
        RAM ram = new RAM();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                ram.setType(resultSet.getString("type"));
                ram.setCapacity(resultSet.getInt("capacity"));
                ram.setPrice(resultSet.getFloat("price"));
                ram.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return ram;
    }

    @Override
    public List<RAM> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.rams";
        List<RAM> rams = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                RAM ram = new RAM();
                ram.setType(resultSet.getString("type"));
                ram.setCapacity(resultSet.getInt("capacity"));
                ram.setPrice(resultSet.getFloat("price"));
                ram.setQuantity(resultSet.getInt("quantity"));
                rams.add(ram);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return rams;
    }

    @Override
    public void insert(RAM ram) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.rams(type, capacity, price, quantity) VALUES (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ram.getType());
            preparedStatement.setInt(2, ram.getCapacity());
            preparedStatement.setFloat(3, ram.getPrice());
            preparedStatement.setInt(4, ram.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, RAM ram) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.rams SET type = ?, capacity = ?, price = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ram.getType());
            preparedStatement.setInt(2, ram.getCapacity());
            preparedStatement.setFloat(3, ram.getPrice());
            preparedStatement.setInt(4, ram.getQuantity());
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "DELETE FROM mydb.rams WHERE id = ?";
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
