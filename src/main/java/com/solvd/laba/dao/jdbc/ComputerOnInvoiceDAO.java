package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IComputerOnInvoiceDAO;
import com.solvd.laba.model.ComputerOnInvoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerOnInvoiceDAO implements IComputerOnInvoiceDAO {

    public static final Logger LOGGER = LogManager.getLogger(ComputerOnInvoiceDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public ComputerOnInvoice getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.computers_on_invoice WHERE id = ?";
        ComputerOnInvoice computer = new ComputerOnInvoice();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                computer.setQuantity(resultSet.getInt("quantity"));
                computer.setComputerId(resultSet.getInt("computers_id"));
                computer.setInvoiceId(resultSet.getInt("invoices_id"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return computer;
    }

    @Override
    public List<ComputerOnInvoice> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.computers_on_invoice";
        List<ComputerOnInvoice> computers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                ComputerOnInvoice computer = new ComputerOnInvoice();
                computer.setQuantity(resultSet.getInt("quantity"));
                computer.setComputerId(resultSet.getInt("computers_id"));
                computer.setInvoiceId(resultSet.getInt("invoices_id"));
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
    public void insert(ComputerOnInvoice computerOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.computers_on_invoice(computers_id, invoices_id, quantity) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, computerOnInvoice.getComputerId());
            preparedStatement.setInt(2, computerOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, computerOnInvoice.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, ComputerOnInvoice computerOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.computers_on_invoice SET computers_id = ?, invoices_id = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, computerOnInvoice.getComputerId());
            preparedStatement.setInt(2, computerOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, computerOnInvoice.getQuantity());
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
        String sql = "DELETE FROM mydb.computers_on_invoice WHERE id = ?";
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
