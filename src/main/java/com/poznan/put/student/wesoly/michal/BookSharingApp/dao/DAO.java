package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class DAO {
    private final DatabaseConnection connection;
    DAO() throws SQLException {
        this.connection = new DatabaseConnection();
    }

    public ResultSet runQuery(String query) throws SQLException {
        ResultSet result;
        connection.connect();

        try {
            Statement statement = connection.getConnection().createStatement();
            result = statement.executeQuery(query);
        }
        catch (SQLException e) {
            result = null;
        }
        connection.disconnect();
        return result;
    }
}
