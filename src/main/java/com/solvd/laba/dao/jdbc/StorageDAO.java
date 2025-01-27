package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IStorageDAO;
import com.solvd.laba.model.Storage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageDAO implements IStorageDAO {

    public static final Logger LOGGER = LogManager.getLogger(StorageDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Storage getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.storage WHERE id = ?";
        Storage storage = new Storage();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                storage.setType(resultSet.getString("type"));
                storage.setCapacity(resultSet.getString("capacity"));
                storage.setPrice(resultSet.getFloat("price"));
                storage.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return storage;
    }

    @Override
    public List<Storage> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.storage";
        List<Storage> storageList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Storage storage = new Storage();
                storage.setType(resultSet.getString("type"));
                storage.setCapacity(resultSet.getString("capacity"));
                storage.setPrice(resultSet.getFloat("price"));
                storage.setQuantity(resultSet.getInt("quantity"));
                storageList.add(storage);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return storageList;
    }

    @Override
    public void insert(Storage storage) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.storage(type, capacity, price, quantity) VALUES (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, storage.getType());
            preparedStatement.setString(2, storage.getCapacity());
            preparedStatement.setFloat(3, storage.getPrice());
            preparedStatement.setInt(4, storage.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Storage storage) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.storage SET type = ?, capacity = ?, price = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, storage.getType());
            preparedStatement.setString(2, storage.getCapacity());
            preparedStatement.setFloat(3, storage.getPrice());
            preparedStatement.setInt(4, storage.getQuantity());
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
        String sql = "DELETE FROM mydb.storage WHERE id = ?";
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
