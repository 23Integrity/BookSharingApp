package com.poznan.put.student.wesoly.michal.BookSharingApp.api.books;

import com.google.gson.Gson;
import com.poznan.put.student.wesoly.michal.BookSharingApp.api.books.GoogleBooksAPIController;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.BooksDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.BooksParser;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.utility.Books.CheckIfBookExists;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.Book;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.BooksTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin
@RestController
public class BookSearchController {
    @GetMapping (value="/api/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findBookByIsbn(@PathVariable String id) {
        Gson gson = new Gson();
        Optional<Book> bookOptional = Optional.ofNullable(CheckIfBookExists.checkIfBookExistsOrAddToDatabase(id));
        if (bookOptional.isPresent()) {
            return gson.toJson(bookOptional.get());
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "The book couldn't be added.");
    }
}
