package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IAddressDAO;
import com.solvd.laba.model.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements IAddressDAO {

    public static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Address getEntityById(int id) {
        Address address = new Address();
        String sql = "SELECT * FROM mydb.addresses WHERE id=?";
        Connection connection = connectionPool.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                address.setCountry(resultSet.getString("country"));
                address.setState(resultSet.getString("state"));
                address.setCity(resultSet.getString("city"));
                address.setAddressLine(resultSet.getString("address_line"));
                address.setZipCode(resultSet.getString("zip_code"));
                address.setUsersId(resultSet.getLong("users_id"));
            }
        }catch (SQLException e){
            LOGGER.error("Error");
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return address;
    }

    @Override
    public List<Address> getEntities() {
        List<Address> addresses = new ArrayList<>();
        String sql = "SELECT * FROM mydb.addresses";
        Connection connection = connectionPool.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Address address = new Address();
                address.setCountry(resultSet.getString("country"));
                address.setState(resultSet.getString("state"));
                address.setCity(resultSet.getString("city"));
                address.setAddressLine(resultSet.getString("address_line"));
                address.setZipCode(resultSet.getString("zip_code"));
                address.setUsersId(resultSet.getLong("users_id"));
                addresses.add(address);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return addresses;
    }

    @Override
    public List<Address> getEntitiesByUser(int id) {
        List<Address> addresses = new ArrayList<>();
        String sql = "SELECT * FROM mydb.addresses where WHERE users_id=?";
        Connection connection = connectionPool.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Address address = new Address();
                address.setCountry(resultSet.getString("country"));
                address.setState(resultSet.getString("state"));
                address.setCity(resultSet.getString("city"));
                address.setAddressLine(resultSet.getString("address_line"));
                address.setZipCode(resultSet.getString("zip_code"));
                address.setUsersId(resultSet.getLong("users_id"));
                addresses.add(address);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return addresses;
    }

    @Override
    public void insert(Address address) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT into mydb.addresses(country, state, city, address_line, zip_code, users_id) VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getState());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getAddressLine());
            preparedStatement.setString(5, address.getZipCode());
            preparedStatement.setLong(6, address.getUsersId());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Address address) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.addresses SET country = ?, state = ?, city = ?, address_line = ?, zip_code = ?, users_id = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getState());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getAddressLine());
            preparedStatement.setString(5, address.getZipCode());
            preparedStatement.setLong(6, address.getUsersId());
            preparedStatement.setInt(7, id);
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
        String sql = "DELETE from mydb.addresses where id = ?";
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
