package com.poznan.put.student.wesoly.michal.BookSharingApp.api.books;

import com.google.gson.Gson;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.BooksDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.BooksParser;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.Book;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.BooksTemplate;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.ISBN;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class BooksController {
    @GetMapping (value="/api/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findBookByIsbn(@PathVariable String id) {
        try {
            Gson gson = new Gson();
            BooksDAO dao = new BooksDAO();
            boolean secondRun = false; // variable used for running a loop: if there's no book in database, it's added

            while (!secondRun) {
                Optional<ResultSet> resultSetOptional = Optional.of(dao.runQuery(BooksParser.findBookWithISBN(id)));
                if (resultSetOptional.isPresent()) {
                    ResultSet resultSet = resultSetOptional.get();
                    // Checking if query result is empty
                    // Empty
                    if (!resultSet.next()) {
                        GoogleBooksAPIController googleBooks = new GoogleBooksAPIController(new RestTemplateBuilder());
                        BooksTemplate template = googleBooks.getBookISBNJSON(id);
                        dao.runQuery(BooksParser.createSaveQuery(template));
                        secondRun = true;
                    }
                    // Not empty
                    else {
                        Book book =     new Book();
                        book.id =       new ISBN("ISBN-13", resultSet.getString("id"));
                        book.title =    resultSet.getString("title");
                        String authors = resultSet.getString("authors").substring(1, resultSet.getString("authors").length()-1);

                        book.authors = Arrays.asList(authors.split(", "));
                        return gson.toJson(book);
                    }
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "The book couldn't be added.");
    }
}
