package com.shucai.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component("transactionManager")
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;


    public void beginTransaction() throws SQLException {
        connectionUtils.getCurrentConn().setAutoCommit(false);
    }

    public void commitTransaction() throws SQLException {
        connectionUtils.getCurrentConn().commit();

    }

    public void rollbackTransaction() throws SQLException {
        connectionUtils.getCurrentConn().rollback();
    }
}
