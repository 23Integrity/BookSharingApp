package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;
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
    private final static String DBURL = System.getenv("JDBC_DATABASE_URL");
    private Connection connection = null;
    private boolean isConnected = false;

    public void connect() throws SQLException {
        if (!isConnected) {
            connection = DriverManager.getConnection(DBURL, System.getenv("JDBC_DATABASE_USERNAME"), System.getenv("JDBC_DATABASE_PASSWORD"));
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
