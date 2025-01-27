package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IDisplayOnInvoiceDAO;
import com.solvd.laba.model.DisplayOnInvoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayOnInvoiceDAO implements IDisplayOnInvoiceDAO {

    public static final Logger LOGGER = LogManager.getLogger(DisplayOnInvoiceDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public DisplayOnInvoice getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.displays_on_invoice WHERE id = ?";
        DisplayOnInvoice display = new DisplayOnInvoice();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                display.setDisplayId(resultSet.getInt("displays_id"));
                display.setInvoiceId(resultSet.getInt("invoices_id"));
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
    public List<DisplayOnInvoice> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.displays_on_invoice";
        List<DisplayOnInvoice> displays = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                DisplayOnInvoice display = new DisplayOnInvoice();
                display.setDisplayId(resultSet.getInt("displays_id"));
                display.setInvoiceId(resultSet.getInt("invoices_id"));
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
    public void insert(DisplayOnInvoice displayOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.displays_on_invoice(displays_id, invoices_id, quantity) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, displayOnInvoice.getDisplayId());
            preparedStatement.setInt(2, displayOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, displayOnInvoice.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, DisplayOnInvoice displayOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.displays_on_invoice SET displays_id = ?, invoices_id = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, displayOnInvoice.getDisplayId());
            preparedStatement.setInt(2, displayOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, displayOnInvoice.getQuantity());
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
        String sql = "DELETE FROM mydb.displays_on_invoice WHERE id = ?";
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
