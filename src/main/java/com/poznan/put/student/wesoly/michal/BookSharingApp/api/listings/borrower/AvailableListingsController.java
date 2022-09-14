package com.poznan.put.student.wesoly.michal.BookSharingApp.api.listings.borrower;

import com.google.gson.Gson;
import com.poznan.put.student.wesoly.michal.BookSharingApp.api.Response;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsParser;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.Book;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.ISBN;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@CrossOrigin
@RestController
public class AvailableListingsController {
    @GetMapping(value="/api/books/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLatestAvailableListings() {
        Gson gson = new Gson();
        Response jsonResponse = new Response();
        try {
            ListingsDAO dao = new ListingsDAO();
            ResultSet resultSet = dao.runQuery(ListingsParser.getLatestListingsQuery(10));

            // No results
            if (resultSet.next()) {
                int i = 1;
                while (resultSet.next()) {
                    Book book = new Book();
                    book.id = new ISBN("ISBN-13", resultSet.getString("id"));
                    book.title = resultSet.getString("title");
                    String authors = resultSet.getString("authors").substring(1, resultSet.getString("authors").length() - 1);
                    book.authors = Arrays.asList(authors.split(", "));

                    jsonResponse.addToResponseBody("Book" + i, book);
                    i++;
                }
            }
            return gson.toJson(jsonResponse);
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Can't proccess book listings");
    }
}
