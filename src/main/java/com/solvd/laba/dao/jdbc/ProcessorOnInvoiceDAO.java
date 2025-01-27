package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IProcessorOnInvoiceDAO;
import com.solvd.laba.model.ProcessorOnInvoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessorOnInvoiceDAO implements IProcessorOnInvoiceDAO {

    public static final Logger LOGGER = LogManager.getLogger(ProcessorOnInvoiceDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public ProcessorOnInvoice getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.processors_on_invoice WHERE id = ?";
        ProcessorOnInvoice processor = new ProcessorOnInvoice();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                processor.setProcessorId(resultSet.getInt("processors_id"));
                processor.setInvoiceId(resultSet.getInt("invoices_id"));
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
    public List<ProcessorOnInvoice> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.processors_on_invoice";
        List<ProcessorOnInvoice> processors = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ProcessorOnInvoice processor = new ProcessorOnInvoice();
                processor.setProcessorId(resultSet.getInt("processors_id"));
                processor.setInvoiceId(resultSet.getInt("invoices_id"));
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
    public void insert(ProcessorOnInvoice processorOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.processors_on_invoice(processors_id, invoices_id, quantity) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, processorOnInvoice.getProcessorId());
            preparedStatement.setInt(2, processorOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, processorOnInvoice.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, ProcessorOnInvoice processorOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.processors_on_invoice SET processors_id = ?, invoices_id = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, processorOnInvoice.getProcessorId());
            preparedStatement.setInt(2, processorOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, processorOnInvoice.getQuantity());
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
        String sql = "DELETE FROM mydb.processors_on_invoice WHERE id = ?";
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
