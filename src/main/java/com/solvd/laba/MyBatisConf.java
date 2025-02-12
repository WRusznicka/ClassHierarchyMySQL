package com.solvd.laba;

import com.solvd.laba.dao.IAddressDAO;
import com.solvd.laba.dao.IUserDAO;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.ResourceBundle;

public class MyBatisConf {

    public static SqlSessionFactory buildSqlSessionFactory() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        PooledDataSource dataSource
                = new PooledDataSource(resourceBundle.getString("driver"), resourceBundle.getString("url"), resourceBundle.getString("user"), resourceBundle.getString("password"));
        Environment environment
                = new Environment("Development", new JdbcTransactionFactory(), dataSource);

        Configuration configuration = new Configuration(environment);

        configuration.addMapper(IAddressDAO.class);
        configuration.addMapper(IUserDAO.class);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        return builder.build(configuration);
    }
}
