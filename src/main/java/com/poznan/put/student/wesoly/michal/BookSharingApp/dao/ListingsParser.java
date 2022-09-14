package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

public class ListingsParser {
    public static String getLatestListingsQuery(int amountOfListings) {
        return  "SELECT * FROM listings " +
                "WHERE available = 'true'" +
                "ORDER BY id DESC" +
                "FETCH FIRST " + amountOfListings + " ROWS ONLY";
    }
    public static String getOwnListingsQuery(int book_owner) {
        return  "SELECT * FROM listings" +
                "WHERE book_owner = '" + book_owner +
                "ORDER BY id DESC";
    }
    public static String saveNewListing(String isbn, int book_owner) {
        return  "INSERT INTO listings ('book_id', 'book_owner', 'borrower', 'available' VALUES" +
                "('" + isbn + "', " + "" +
                "'" + book_owner + "', " +
                "NULL, TRUE)";
    }
}
