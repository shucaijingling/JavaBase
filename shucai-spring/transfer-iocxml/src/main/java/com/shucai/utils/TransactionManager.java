package com.shucai.utils;

import java.sql.SQLException;

public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /*private TransactionManager() {

    }

    private static TransactionManager instance = new TransactionManager();

    public static TransactionManager getInstance() {
        return instance;
    }*/

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
