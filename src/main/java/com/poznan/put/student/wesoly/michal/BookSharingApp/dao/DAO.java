package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class DAO {
    private final DatabaseConnection connection;
    DAO() throws SQLException {
        this.connection = new DatabaseConnection();
    }

    public ResultSet runQuery(String query) throws SQLException {
        ResultSet result = null;
        connection.connect();

        try {
            Statement statement = connection.getConnection().createStatement();
            result = statement.executeQuery(query);
            return result;

        }
        catch (SQLException e) {
            System.out.printf("!Error: " + e);
        }
        return result;
    }
}
