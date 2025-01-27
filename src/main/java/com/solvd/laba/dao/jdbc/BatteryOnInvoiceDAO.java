package com.solvd.laba.dao.jdbc;

import com.solvd.laba.BasicConnectionPool;
import com.solvd.laba.dao.IBatteryOnInvoiceDAO;
import com.solvd.laba.model.BatteryOnInvoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatteryOnInvoiceDAO implements IBatteryOnInvoiceDAO {

    public static final Logger LOGGER = LogManager.getLogger(BatteryOnInvoiceDAO.class);
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public BatteryOnInvoice getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.batteries_on_invoice WHERE id = ?";
        BatteryOnInvoice battery = new BatteryOnInvoice();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                battery.setBatteryId(resultSet.getInt("batteries_id"));
                battery.setInvoiceId(resultSet.getInt("invoices_id"));
                battery.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return battery;
    }

    @Override
    public List<BatteryOnInvoice> getEntities() {
        Connection connection = connectionPool.getConnection();
        String sql = "SELECT * FROM mydb.batteries_on_invoice";
        List<BatteryOnInvoice> batteries = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                BatteryOnInvoice battery = new BatteryOnInvoice();
                battery.setBatteryId(resultSet.getInt("batteries_id"));
                battery.setInvoiceId(resultSet.getInt("invoices_id"));
                battery.setQuantity(resultSet.getInt("quantity"));
                batteries.add(battery);
            }
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return batteries;
    }

    @Override
    public void insert(BatteryOnInvoice batteryOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "INSERT INTO mydb.batteries_on_invoice(batteries_id, invoices_id, quantity) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, batteryOnInvoice.getBatteryId());
            preparedStatement.setInt(2, batteryOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, batteryOnInvoice.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, BatteryOnInvoice batteryOnInvoice) {
        Connection connection = connectionPool.getConnection();
        String sql = "UPDATE mydb.batteries_on_invoice SET batteries_id = ?, invoices_id = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, batteryOnInvoice.getBatteryId());
            preparedStatement.setInt(2, batteryOnInvoice.getInvoiceId());
            preparedStatement.setInt(3, batteryOnInvoice.getQuantity());
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
        String sql = "DELETE FROM mydb.batteries_on_invoice WHERE id = ?";
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
