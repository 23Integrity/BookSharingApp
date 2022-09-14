package com.poznan.put.student.wesoly.michal.BookSharingApp.dao.utility.Books;

import com.poznan.put.student.wesoly.michal.BookSharingApp.api.books.GoogleBooksAPIController;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.BooksDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.BooksParser;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.Book;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.BooksTemplate;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.ISBN;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckIfBookExists {
    public static Book checkIfBookExistsOrAddToDatabase(String isbn) {
        try {
            BooksDAO dao = new BooksDAO();
            boolean secondRun = false; // for running a loop twice

            while (!secondRun) {
                ResultSet resultSet = dao.runQuery(BooksParser.findBookWithISBN(isbn));
                if (!resultSet.next()) {
                    GoogleBooksAPIController controller = new GoogleBooksAPIController(new RestTemplateBuilder());
                    BooksTemplate template = controller.getBookISBNJSON(isbn);
                    dao.runQuery(BooksParser.createSaveQuery(template));
                    secondRun = true;
                } else {
                    return new Book(resultSet);
                }
            }
        }
        catch(SQLException e) {
            System.out.println(e);
            return null;
        }
        return null;
    }
}
