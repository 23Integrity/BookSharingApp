package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.BooksTemplate;

public class BooksParser {
    // Add book to database
    public static String createSaveQuery(BooksTemplate book) {
        return "INSERT INTO books VALUES " +
                "('"+ book.getItems().get(0).getVolumeInfo().getIndustryIdentifiers().get(1).getIdentifier() +
                "', '" + book.getItems().get(0).getVolumeInfo().getTitle() +
                "', '" + book.getItems().get(0).getVolumeInfo().getAuthors().toString() + "');";
    }
    // Find a book by ISBN-13
    public static String findBookWithISBN(String isbn) {
        return "SELECT * FROM books WHERE id = '" + isbn + "'";
    }
}
