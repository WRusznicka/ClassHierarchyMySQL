package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IWarrantyDAO;
import com.solvd.laba.model.Warranty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarrantyDAO implements IWarrantyDAO {

    public static final Logger LOGGER = LogManager.getLogger(WarrantyDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Warranty getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.warranties WHERE id = ?";
        Warranty warranty = new Warranty();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                warranty.setTypeOfWarrantyId(resultSet.getInt("types_of_warranty_id"));
                warranty.setDuration(resultSet.getString("duration"));
                warranty.setExtraPrice(resultSet.getFloat("extra_price"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return warranty;
    }

    @Override
    public List<Warranty> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.warranties";
        List<Warranty> warranties = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Warranty warranty = new Warranty();
                warranty.setTypeOfWarrantyId(resultSet.getInt("types_of_warranty_id"));
                warranty.setDuration(resultSet.getString("duration"));
                warranty.setExtraPrice(resultSet.getFloat("extra_price"));
                warranties.add(warranty);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return warranties;
    }

    @Override
    public void insert(Warranty warranty) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.warranties(types_of_warranty_id, duration, extra_price) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, warranty.getTypeOfWarrantyId());
            preparedStatement.setString(2, warranty.getDuration());
            preparedStatement.setFloat(3, warranty.getExtraPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Warranty warranty) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.warranties SET types_of_warranty_id = ?, duration = ?, extra_price = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, warranty.getTypeOfWarrantyId());
            preparedStatement.setString(2, warranty.getDuration());
            preparedStatement.setFloat(3, warranty.getExtraPrice());
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
        String sql = "DELETE FROM mydb.warranties WHERE id = ?";
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
