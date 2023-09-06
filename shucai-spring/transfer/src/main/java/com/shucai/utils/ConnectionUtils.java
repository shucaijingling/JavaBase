package com.shucai.utils;

public class ConnectionUtils {

    private ConnectionUtils() {

    }

    private static ConnectionUtils connectionUtils = new ConnectionUtils();

    public static ConnectionUtils getInstance(){
        return connectionUtils;
    }
}
