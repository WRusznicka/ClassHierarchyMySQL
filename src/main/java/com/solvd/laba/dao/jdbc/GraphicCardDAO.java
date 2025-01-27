package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IGraphicCardDAO;
import com.solvd.laba.model.GraphicCard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GraphicCardDAO implements IGraphicCardDAO {

    public static final Logger LOGGER = LogManager.getLogger(GraphicCardDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public GraphicCard getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.graphic_cards WHERE id = ?";
        GraphicCard graphics = new GraphicCard();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                graphics.setModel(resultSet.getString("model"));
                graphics.setPrice(resultSet.getFloat("price"));
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
    public List<GraphicCard> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.graphic_cards";
        List<GraphicCard> graphicsList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                GraphicCard graphics = new GraphicCard();
                graphics.setModel(resultSet.getString("model"));
                graphics.setPrice(resultSet.getFloat("price"));
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
    public void insert(GraphicCard graphicCard) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.graphic_cards(model, price, quantity) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, graphicCard.getModel());
            preparedStatement.setFloat(2, graphicCard.getPrice());
            preparedStatement.setInt(3, graphicCard.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, GraphicCard graphicCard) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.graphic_cards SET model = ?, price = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, graphicCard.getModel());
            preparedStatement.setFloat(2, graphicCard.getPrice());
            preparedStatement.setInt(3, graphicCard.getQuantity());
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
        String sql = "DELETE FROM mydb.graphic_cards WHERE id = ?";
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
