package com.testautomation.database;

import com.testautomation.config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseManager {
    private Connection connection;

    public void connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
    }

    public ResultSet executeQuery(String query) throws Exception {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws Exception {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
