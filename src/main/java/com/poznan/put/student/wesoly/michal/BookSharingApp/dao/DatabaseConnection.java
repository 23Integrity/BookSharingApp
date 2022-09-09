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

    private final static String DBURL = "jdbc:postgresql://ec2-54-76-43-89.eu-west-1.compute.amazonaws.com:5432/d114kje7vdncln?sslmode=require";
    private Connection connection = null;
    private boolean isConnected = false;

    public void connect() throws SQLException {
        if (!isConnected) {
            connection = DriverManager.getConnection(DBURL, "dyyfikenvgkqax", "dc5c76532800ed49bbdfcab316aff2a56ce012947d0c8edd8bb284002c2b179b");
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
