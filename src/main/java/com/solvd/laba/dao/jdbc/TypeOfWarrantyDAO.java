package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.ITypeOfWarrantyDAO;
import com.solvd.laba.model.TypeOfWarranty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfWarrantyDAO implements ITypeOfWarrantyDAO {

    public static final Logger LOGGER = LogManager.getLogger(TypeOfWarrantyDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public TypeOfWarranty getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.types_of_warranty WHERE id = ?";
        TypeOfWarranty type = new TypeOfWarranty();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                type.setName(resultSet.getString("name"));
                type.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return type;
    }

    @Override
    public List<TypeOfWarranty> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.types_of_warranty";
        List<TypeOfWarranty> types = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                TypeOfWarranty type = new TypeOfWarranty();
                type.setName(resultSet.getString("name"));
                type.setDescription(resultSet.getString("description"));
                types.add(type);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return types;
    }

    @Override
    public void insert(TypeOfWarranty typeOfWarranty) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.types_of_warranty(name, description) VALUES (?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, typeOfWarranty.getName());
            preparedStatement.setString(2, typeOfWarranty.getDescription());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, TypeOfWarranty typeOfWarranty) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.types_of_warranty SET name = ?, description = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, typeOfWarranty.getName());
            preparedStatement.setString(2, typeOfWarranty.getDescription());
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
        String sql = "DELETE FROM mydb.types_of_warranty WHERE id = ?";
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
