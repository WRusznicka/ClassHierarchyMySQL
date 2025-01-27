package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IGraphicCardOnInvoiceDAO;
import com.solvd.laba.model.GraphicCardOnInvoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GraphicCardOnInvoiceDAO implements IGraphicCardOnInvoiceDAO {

    public static final Logger LOGGER = LogManager.getLogger(GraphicCardOnInvoiceDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public GraphicCardOnInvoice getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.graphic_cards_on_invoice WHERE id = ?";
        GraphicCardOnInvoice graphics = new GraphicCardOnInvoice();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                graphics.setGraphicCardId(resultSet.getInt("graphic_cards_id"));
                graphics.setInvoiceId(resultSet.getInt("invoices_id"));
                graphics.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return graphics;
    }

    @Override
    public List<GraphicCardOnInvoice> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.graphic_cards_on_invoice";
        List<GraphicCardOnInvoice> graphicsList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                GraphicCardOnInvoice graphics = new GraphicCardOnInvoice();
                graphics.setGraphicCardId(resultSet.getInt("graphic_cards_id"));
                graphics.setInvoiceId(resultSet.getInt("invoices_id"));
                graphics.setQuantity(resultSet.getInt("quantity"));
                graphicsList.add(graphics);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return graphicsList;
    }

    @Override
    public void insert(GraphicCardOnInvoice graphicCardOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.graphic_cards_on_invoice(graphic_cards_id, invoices_id, quantity) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, graphicCardOnInvoice.getGraphicCardId());
            preparedStatement.setInt(2, graphicCardOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, graphicCardOnInvoice.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, GraphicCardOnInvoice graphicCardOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.graphic_cards_on_invoice SET graphic_cards_id = ?, invoices_id = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, graphicCardOnInvoice.getGraphicCardId());
            preparedStatement.setInt(2, graphicCardOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, graphicCardOnInvoice.getQuantity());
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
        String sql = "DELETE FROM mydb.graphic_cards_on_invoice WHERE id = ?";
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
