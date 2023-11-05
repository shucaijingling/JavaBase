package com.shucai.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component("connectionUtils")
public class ConnectionUtils {

    @Autowired
    private DataSource druidDataSource;

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public Connection getCurrentConn() throws SQLException {
        Connection connection = threadLocal.get();

        if (connection == null) {
            connection = druidDataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }
}
