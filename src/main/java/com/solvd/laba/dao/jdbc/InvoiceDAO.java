package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IInvoiceDAO;
import com.solvd.laba.model.Invoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO implements IInvoiceDAO {

    public static final Logger LOGGER = LogManager.getLogger(InvoiceDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Invoice getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.invoices WHERE id = ?";
        Invoice invoice = new Invoice();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                invoice.setTotalPrice(resultSet.getFloat("total_price"));
                invoice.setDate(resultSet.getDate("date"));
                invoice.setUsersId(resultSet.getLong("users_id"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return invoice;
    }

    @Override
    public List<Invoice> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.invoices";
        List<Invoice> invoices = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Invoice invoice = new Invoice();
                invoice.setTotalPrice(resultSet.getFloat("total_price"));
                invoice.setDate(resultSet.getDate("date"));
                invoice.setUsersId(resultSet.getLong("users_id"));
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return invoices;
    }

    @Override
    public void insert(Invoice invoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.invoices(total_price, date, users_id) VALUES(?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, invoice.getTotalPrice());
            preparedStatement.setDate(2, (Date) invoice.getDate());
            preparedStatement.setLong(3, invoice.getUsersId());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Invoice invoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.invoices SET total_price = ?, date = ?, users_id = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, invoice.getTotalPrice());
            preparedStatement.setDate(2, (Date) invoice.getDate());
            preparedStatement.setLong(3, invoice.getUsersId());
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
        String sql = "DELETE FROM mydb.invoices WHERE id = ?";
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
