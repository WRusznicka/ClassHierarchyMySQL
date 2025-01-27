package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IStorageOnInvoiceDAO;
import com.solvd.laba.model.StorageOnInvoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageOnInvoiceDAO implements IStorageOnInvoiceDAO {

    public static final Logger LOGGER = LogManager.getLogger(StorageOnInvoiceDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public StorageOnInvoice getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.storage_on_invoice WHERE id = ?";
        StorageOnInvoice storage = new StorageOnInvoice();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                storage.setStorageId(resultSet.getInt("storage_id"));
                storage.setInvoiceId(resultSet.getInt("invoices_id"));
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
    public List<StorageOnInvoice> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.storage_on_invoice";
        List<StorageOnInvoice> storageList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                StorageOnInvoice storage = new StorageOnInvoice();
                storage.setStorageId(resultSet.getInt("storage_id"));
                storage.setInvoiceId(resultSet.getInt("invoices_id"));
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
    public void insert(StorageOnInvoice storageOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.storage_on_invoice(storage_id, invoices_id, quantity) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, storageOnInvoice.getStorageId());
            preparedStatement.setInt(2, storageOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, storageOnInvoice.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, StorageOnInvoice storageOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.storage_on_invoice SET storage_id = ?, invoices_id = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, storageOnInvoice.getStorageId());
            preparedStatement.setInt(2, storageOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, storageOnInvoice.getQuantity());
            preparedStatement.setInt(4, id);
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
        String sql = "DELETE FROM mydb.storage_on_invoice WHERE id = ?";
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
