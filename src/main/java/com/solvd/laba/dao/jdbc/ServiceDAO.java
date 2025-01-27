package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IServiceDAO;
import com.solvd.laba.model.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO implements IServiceDAO {

    public static final Logger LOGGER = LogManager.getLogger(ServiceDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Service getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.service WHERE id = ?";
        Service service = new Service();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                service.setName(resultSet.getString("name"));
                service.setDescription(resultSet.getString("description"));
                service.setPrice(resultSet.getFloat("price"));
                service.setDuration(resultSet.getString("duration"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return service;
    }

    @Override
    public List<Service> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.service";
        List<Service> serviceList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Service service = new Service();
                service.setName(resultSet.getString("name"));
                service.setDescription(resultSet.getString("description"));
                service.setPrice(resultSet.getFloat("price"));
                service.setDuration(resultSet.getString("duration"));
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
    public void insert(Service service) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.service(name, description, price, duration) VALUES (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setString(2, service.getDescription());
            preparedStatement.setFloat(3, service.getPrice());
            preparedStatement.setString(4, service.getDuration());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Service service) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.service SET name = ?, description = ?, price = ?, duration =? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setString(2, service.getDescription());
            preparedStatement.setFloat(3, service.getPrice());
            preparedStatement.setString(4, service.getDuration());
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
        String sql = "DELETE FROM mydb.service WHERE id = ?";
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
