package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IBatteryDAO;
import com.solvd.laba.model.Battery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatteryDAO implements IBatteryDAO {

    public static final Logger LOGGER = LogManager.getLogger(BatteryDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Battery getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.batteries WHERE id = ?";
        Battery battery = new Battery();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                battery.setMaterial(resultSet.getString("material"));
                battery.setNumberOfCells(resultSet.getInt("number_of_cells"));
                battery.setCapacity(resultSet.getInt("capacity"));
                battery.setBatteryPowerLevel(resultSet.getString("battery_power_level"));
                battery.setBatteryPower(resultSet.getInt("battery_power"));
                battery.setPrice(resultSet.getFloat("price"));
                battery.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return battery;
    }

    @Override
    public List<Battery> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.batteries";
        List<Battery> batteries = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Battery battery = new Battery();
                battery.setMaterial(resultSet.getString("material"));
                battery.setNumberOfCells(resultSet.getInt("number_of_cells"));
                battery.setCapacity(resultSet.getInt("capacity"));
                battery.setBatteryPowerLevel(resultSet.getString("battery_power_level"));
                battery.setBatteryPower(resultSet.getInt("battery_power"));
                battery.setPrice(resultSet.getFloat("price"));
                battery.setQuantity(resultSet.getInt("quantity"));
                batteries.add(battery);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return batteries;
    }

    @Override
    public void insert(Battery battery) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.batteries(material, number_of_cells, capacity, battery_power_level, battery_power, price, quantity) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, battery.getMaterial());
            preparedStatement.setInt(2, battery.getNumberOfCells());
            preparedStatement.setInt(3, battery.getCapacity());
            preparedStatement.setString(4, battery.getBatteryPowerLevel());
            preparedStatement.setInt(5, battery.getBatteryPower());
            preparedStatement.setFloat(6, battery.getPrice());
            preparedStatement.setInt(7, battery.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Battery battery) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.batteries SET material = ?, number_of_cells = ?, capacity = ?, battery_power_level = ?, battery_power = ?, price = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, battery.getMaterial());
            preparedStatement.setInt(2, battery.getNumberOfCells());
            preparedStatement.setInt(3, battery.getCapacity());
            preparedStatement.setString(4, battery.getBatteryPowerLevel());
            preparedStatement.setInt(5, battery.getBatteryPower());
            preparedStatement.setFloat(6, battery.getPrice());
            preparedStatement.setInt(7, battery.getQuantity());
            preparedStatement.setInt(8, id);
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
        String sql = "DELETE FROM mydb.batteries WHERE id = ?";
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
