package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IDisplayDAO;
import com.solvd.laba.model.Display;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayDAO implements IDisplayDAO {

    public static final Logger LOGGER = LogManager.getLogger(DisplayDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Display getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.displays WHERE id = ?";
        Display display = new Display();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                display.setResolution(resultSet.getString("resolution"));
                display.setType(resultSet.getString("type"));
                display.setSize(resultSet.getFloat("size"));
                display.setPrice(resultSet.getFloat("price"));
                display.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return display;
    }

    @Override
    public List<Display> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.displays";
        List<Display> displays = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Display display = new Display();
                display.setResolution(resultSet.getString("resolution"));
                display.setType(resultSet.getString("type"));
                display.setSize(resultSet.getFloat("size"));
                display.setPrice(resultSet.getFloat("price"));
                display.setQuantity(resultSet.getInt("quantity"));
                displays.add(display);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return displays;
    }

    @Override
    public void insert(Display display) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.displays(resolution, type, size, price, quantity) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, display.getResolution());
            preparedStatement.setString(2, display.getType());
            preparedStatement.setFloat(3, display.getSize());
            preparedStatement.setFloat(4, display.getPrice());
            preparedStatement.setInt(5, display.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Display display) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.displays SET resolution = ?, type = ?, size = ?, price = ?, quantity = ? WHERE id = ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, display.getResolution());
            preparedStatement.setString(2, display.getType());
            preparedStatement.setFloat(3, display.getSize());
            preparedStatement.setFloat(4, display.getPrice());
            preparedStatement.setInt(5, display.getQuantity());
            preparedStatement.setInt(6, id);
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
        String sql = "DELETE FROM mydb.displays WHERE id = ?";
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
