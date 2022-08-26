package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public DatabaseConnection() throws SQLException {
        Driver myDriver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();
        DriverManager.registerDriver( myDriver );
    }

    private final static String DBURL = "jdbc:sqlserver://book-sharing-project.database.windows.net:1433;" +
            "database=book_sharing_database;" +
            "user=michalwesoly@book-sharing-project;" +
            "password=d351749AB!;" +
            "encrypt=true;" +
            "trustServerCertificate=false;" +
            "hostNameInCertificate=*.database.windows.net;" +
            "loginTimeout=30;";

    private Connection connection = null;
    private boolean isConnected = false;

    public void connect() throws SQLException {
        if (!isConnected) {
            connection = DriverManager.getConnection(DBURL);
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
