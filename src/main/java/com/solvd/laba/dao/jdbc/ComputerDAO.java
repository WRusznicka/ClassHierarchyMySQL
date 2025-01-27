package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IComputerDAO;
import com.solvd.laba.model.Computer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerDAO implements IComputerDAO {

    public static final Logger LOGGER = LogManager.getLogger(ComputerDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Computer getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.computers WHERE id = ?";
        Computer computer = new Computer();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                computer.setType(resultSet.getString("type"));
                computer.setBrand(resultSet.getString("brand"));
                computer.setModel(resultSet.getString("model"));
                computer.setSpecifications(resultSet.getString("specifications"));
                computer.setPrice(resultSet.getFloat("price"));
                computer.setQuantity(resultSet.getInt("quantity"));
                computer.setDisplayId(resultSet.getInt("displays_id"));
                computer.setBatteryId(resultSet.getInt("batteries_id"));
                computer.setGraphicCardId(resultSet.getInt("graphic_cards_id"));
                computer.setProcessorId(resultSet.getInt("processors_id"));
                computer.setRamId(resultSet.getInt("RAMs_id"));
                computer.setStorageId(resultSet.getInt("storage_id"));
                computer.setWarrantyId(resultSet.getInt("warranties_id"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return computer;
    }

    @Override
    public List<Computer> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.computers";
        List<Computer> computers = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Computer computer = new Computer();
                computer.setType(resultSet.getString("type"));
                computer.setBrand(resultSet.getString("brand"));
                computer.setModel(resultSet.getString("model"));
                computer.setSpecifications(resultSet.getString("specifications"));
                computer.setPrice(resultSet.getFloat("price"));
                computer.setQuantity(resultSet.getInt("quantity"));
                computer.setDisplayId(resultSet.getInt("displays_id"));
                computer.setBatteryId(resultSet.getInt("batteries_id"));
                computer.setGraphicCardId(resultSet.getInt("graphic_cards_id"));
                computer.setProcessorId(resultSet.getInt("processors_id"));
                computer.setRamId(resultSet.getInt("RAMs_id"));
                computer.setStorageId(resultSet.getInt("storage_id"));
                computer.setWarrantyId(resultSet.getInt("warranties_id"));
                computers.add(computer);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return computers;
    }

    @Override
    public void insert(Computer computer) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.computers(type, brand, model, specifications, price, quantity, displays_id, batteries_id, graphic_cards_id, processors_id, RAMs_id, storage_id, warranties_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, computer.getType());
            preparedStatement.setString(2, computer.getBrand());
            preparedStatement.setString(3, computer.getModel());
            preparedStatement.setString(4, computer.getSpecifications());
            preparedStatement.setFloat(5, computer.getPrice());
            preparedStatement.setInt(6, computer.getQuantity());
            preparedStatement.setInt(7, computer.getDisplayId());
            preparedStatement.setInt(8, computer.getBatteryId());
            preparedStatement.setInt(9, computer.getGraphicCardId());
            preparedStatement.setInt(10, computer.getProcessorId());
            preparedStatement.setInt(11, computer.getRamId());
            preparedStatement.setInt(12, computer.getStorageId());
            preparedStatement.setInt(13, computer.getWarrantyId());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Computer computer) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.computers SET type = ?, brand = ?, model = ?, specifications = ?, price = ?, quantity = ?, displays_id = ?, batteries_id = ?, graphic_cards_id = ?, processors_id = ?, RAMs_id = ?, storage_id = ?, warranties_id = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, computer.getType());
            preparedStatement.setString(2, computer.getBrand());
            preparedStatement.setString(3, computer.getModel());
            preparedStatement.setString(4, computer.getSpecifications());
            preparedStatement.setFloat(5, computer.getPrice());
            preparedStatement.setInt(6, computer.getQuantity());
            preparedStatement.setInt(7, computer.getDisplayId());
            preparedStatement.setInt(8, computer.getBatteryId());
            preparedStatement.setInt(9, computer.getGraphicCardId());
            preparedStatement.setInt(10, computer.getProcessorId());
            preparedStatement.setInt(11, computer.getRamId());
            preparedStatement.setInt(12, computer.getStorageId());
            preparedStatement.setInt(13, computer.getWarrantyId());
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
        String sql = "DELETE FROM mydb.computers WHERE id = ?";
        try {
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
