package com.poznan.put.student.wesoly.michal.BookSharingApp.dao.utility.Listings;

import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsParser;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckIfListingExists {
    public static boolean checkIfListingExists(String isbn, int owner_id) {
        try {
            ListingsDAO dao = new ListingsDAO();
            ResultSet resultSet = dao.runQuery(ListingsParser.findListingByISBNAndOwner(isbn, owner_id));
            return resultSet.next();
        }
        catch (SQLException e) {
            return false;
        }
    }
}
