package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IRamOnInvoiceDAO;
import com.solvd.laba.model.RAMOnInvoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RamOnInvoiceDAO implements IRamOnInvoiceDAO {

    public static final Logger LOGGER = LogManager.getLogger(RamOnInvoiceDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public RAMOnInvoice getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.rams_on_invoice WHERE id = ?";
        RAMOnInvoice ram = new RAMOnInvoice();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                ram.setRamId(resultSet.getInt("RAMs_id"));
                ram.setInvoiceId(resultSet.getInt("invoices_id"));
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
    public List<RAMOnInvoice> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.rams_on_invoice";
        List<RAMOnInvoice> rams = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                RAMOnInvoice ram = new RAMOnInvoice();
                ram.setRamId(resultSet.getInt("RAMs_id"));
                ram.setInvoiceId(resultSet.getInt("invoices_id"));
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
    public void insert(RAMOnInvoice ramOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.rams_on_invoice(RAMs_id, invoices_id, quantity) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ramOnInvoice.getRamId());
            preparedStatement.setInt(2, ramOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, ramOnInvoice.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, RAMOnInvoice ramOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.rams_on_invoice SET RAMs_id = ?, invoices_id = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ramOnInvoice.getRamId());
            preparedStatement.setInt(2, ramOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, ramOnInvoice.getQuantity());
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
        String sql = "DELETE FROM mydb.rams_on_invoice WHERE id = ?";
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
