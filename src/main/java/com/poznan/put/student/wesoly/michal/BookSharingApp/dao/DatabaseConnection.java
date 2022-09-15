package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public DatabaseConnection() throws SQLException {
        Driver myDriver = new org.postgresql.Driver();
        DriverManager.registerDriver( myDriver );
    }

    @Value("${spring.datasource.url}")
    private final static String DBURL =
            "jdbc:postgresql://ec2-52-51-3-22.eu-west-1.compute.amazonaws.com:5432/dhgciti3li751?sslmode=require";
    private Connection connection = null;
    private boolean isConnected = false;

    public void connect() throws SQLException {
        if (!isConnected) {
            connection = DriverManager.getConnection(DBURL, "pxjcpesuxpkdui", "415139ec8ff3155fac9da0080fed2af35c8d6492d441a4ef0028db71be4b7dd1");
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
