package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.Books;

public class BooksParser {
    public static String createSaveQuery(Books book) {
        System.out.println(book.getItems().get(0).getVolumeInfo().getIndustryIdentifiers().get(1).getIdentifier());
        System.out.println(book.getItems().get(0).getVolumeInfo().getTitle());
        return "INSERT INTO books VALUES " +
                "('"+ book.getItems().get(0).getVolumeInfo().getIndustryIdentifiers().get(1).getIdentifier() +
                "', '" + book.getItems().get(0).getVolumeInfo().getTitle() +
                "', '" + book.getItems().get(0).getVolumeInfo().getAuthors().toString() + "');";
    }
    public static String findBookWithISBN(String isbn) {
        return "SELECT * FROM books WHERE id = '" + isbn + "'";
    }
}
