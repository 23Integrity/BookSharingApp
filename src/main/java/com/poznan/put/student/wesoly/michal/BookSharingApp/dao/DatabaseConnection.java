package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public DatabaseConnection() throws SQLException {
        Driver myDriver = new org.postgresql.Driver();
        DriverManager.registerDriver( myDriver );
    }

    private final static String DBURL = "jdbc:postgresql://34.71.19.68:5432/postgres";
//            "sslmode=disable" +
//            "user=postgres;" +
//            "password=d351749AB!;";

    private Connection connection = null;
    private boolean isConnected = false;

    public void connect() throws SQLException {
        if (!isConnected) {
            connection = DriverManager.getConnection(DBURL, "postgres", "d351749AB!");
            isConnected = true;
        }
    }
    public void disconnect() throws SQLException {
        if (isConnected) {
            connection.close();
            isConnected = false;
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
