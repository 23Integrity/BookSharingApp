package com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class Book implements Serializable {
    public ISBN id = new ISBN("ISBN-13", "0");
    public String title = null;
    public List<String> authors = null;

    public Book() {}
    public Book(ResultSet resultSet) {
        try {
            this.id = new ISBN("ISBN-13", resultSet.getString("id"));
            this.title = resultSet.getString("title");
            String authors = resultSet.getString("authors").substring(1, resultSet.getString("authors").length() - 1);
            this.authors = Arrays.asList(authors.split(", "));
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
