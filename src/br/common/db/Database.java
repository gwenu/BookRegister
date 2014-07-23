package br.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String dbDriver;
    private String dbUrl;
    private String username;
    private String password;
    private Connection connection = null;

    public Database(String dbDriver, String dbUrl, String username, String password) {
        this.dbDriver = dbDriver;
        this.dbUrl = dbUrl;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            System.out.println(dbDriver);
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Connection opened!");

        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Connection closed!");
    }
}