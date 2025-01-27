package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IServiceOnInvoiceDAO;
import com.solvd.laba.model.ServiceOnInvoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceOnInvoiceDAO implements IServiceOnInvoiceDAO {

    public static final Logger LOGGER = LogManager.getLogger(ServiceOnInvoiceDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public ServiceOnInvoice getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.service_on_invoice WHERE id = ?";
        ServiceOnInvoice service = new ServiceOnInvoice();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                service.setServiceId(resultSet.getInt("service_id"));
                service.setInvoiceId(resultSet.getInt("invoices_id"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return service;
    }

    @Override
    public List<ServiceOnInvoice> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.service_on_invoice";
        List<ServiceOnInvoice> serviceList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ServiceOnInvoice service = new ServiceOnInvoice();
                service.setServiceId(resultSet.getInt("service_id"));
                service.setInvoiceId(resultSet.getInt("invoices_id"));
                serviceList.add(service);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return serviceList;
    }

    @Override
    public void insert(ServiceOnInvoice serviceOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.service_on_invoice(service_id, invoices_id) VALUES (?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, serviceOnInvoice.getServiceId());
            preparedStatement.setInt(2, serviceOnInvoice.getInvoiceId());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, ServiceOnInvoice serviceOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.service_on_invoice SET service_id = ?, invoices_id = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, serviceOnInvoice.getServiceId());
            preparedStatement.setInt(2, serviceOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, id);
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
        String sql = "DELETE FROM mydb.service_on_invoice WHERE id = ?";
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
