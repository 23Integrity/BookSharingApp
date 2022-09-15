package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

public class ListingsParser {
    public static String getLatestListingsQuery(int amountOfListings) {
        return  "SELECT * FROM listings " +
                "WHERE available = 'true' " +
                "ORDER BY id DESC " +
                "FETCH FIRST " + amountOfListings + " ROWS ONLY";
    }
    public static String getOwnListingsQuery(int book_owner) {
        return  "SELECT * FROM listings" +
                "WHERE book_owner = '" + book_owner + " " +
                "ORDER BY id DESC";
    }
    public static String findListingByISBNAndOwner(String isbn, int owner_id) {
        return  "SELECT * FROM listings" +
                "WHERE book_id = '" + isbn + "' " +
                "AND book_owner = '" + owner_id + "' ";

    }
    public static String saveNewListing(String isbn, int book_owner) {
        return  "INSERT INTO listings ('book_id', 'book_owner', 'borrower', 'available') VALUES" +
                "('" + isbn + "', " +
                "'" + book_owner + "', " +
                "NULL, TRUE)";
    }
    public static String getListingDetails(int id) {
        return  "SELECT * FROM listings WHERE id = '" + id + "'";
    }
    public static String deleteListing(int id) {
        return  "DELETE FROM listings " +
                "WHERE id = '" + id + "'";
    }
}
