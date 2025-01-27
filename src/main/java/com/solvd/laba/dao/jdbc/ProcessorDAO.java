package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IProcessorDAO;
import com.solvd.laba.model.Processor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessorDAO implements IProcessorDAO {

    public static final Logger LOGGER = LogManager.getLogger(ProcessorDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Processor getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.processors WHERE id = ?";
        Processor processor = new Processor();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                processor.setModel(resultSet.getString("model"));
                processor.setMaxFrequency(resultSet.getFloat("max_frequency"));
                processor.setNumberOfCores(resultSet.getInt("number_of_cores"));
                processor.setCache(resultSet.getFloat("cache"));
                processor.setPrice(resultSet.getFloat("price"));
                processor.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return processor;
    }

    @Override
    public List<Processor> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.processors";
        List<Processor> processors = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Processor processor = new Processor();
                processor.setModel(resultSet.getString("model"));
                processor.setMaxFrequency(resultSet.getFloat("max_frequency"));
                processor.setNumberOfCores(resultSet.getInt("number_of_cores"));
                processor.setCache(resultSet.getFloat("cache"));
                processor.setPrice(resultSet.getFloat("price"));
                processor.setQuantity(resultSet.getInt("quantity"));
                processors.add(processor);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return processors;
    }

    @Override
    public void insert(Processor processor) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.processors(model, max_frequency, number_of_cores, cache, price, quantity) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, processor.getModel());
            preparedStatement.setFloat(2, processor.getMaxFrequency());
            preparedStatement.setInt(3, processor.getNumberOfCores());
            preparedStatement.setFloat(4, processor.getCache());
            preparedStatement.setFloat(5, processor.getPrice());
            preparedStatement.setInt(6, processor.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Processor processor) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.processors SET model = ?, max_frequency = ?, number_of_cores = ?, cache = ?, price = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, processor.getModel());
            preparedStatement.setFloat(2, processor.getMaxFrequency());
            preparedStatement.setInt(3, processor.getNumberOfCores());
            preparedStatement.setFloat(4, processor.getCache());
            preparedStatement.setFloat(5, processor.getPrice());
            preparedStatement.setInt(6, processor.getQuantity());
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
        String sql = "DELETE FROM mydb.processors WHERE id = ?";
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
