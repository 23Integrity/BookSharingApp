package com.poznan.put.student.wesoly.michal.BookSharingApp.api.listings.owner;

import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.BooksParser;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsParser;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.utility.Books.CheckIfBookExists;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.utility.Listings.CheckIfListingExists;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@CrossOrigin
@RestController
public class AddNewListingController {
    @PostMapping(value="api/listings/add")
    public void addNewListing(@RequestParam(name="id") String id, @RequestParam(name="user") int user_id) {
        Optional<Book> bookOptional = Optional.ofNullable(CheckIfBookExists.checkIfBookExistsOrAddToDatabase(id));
        if (bookOptional.isPresent()) {
            try {
                Book book = bookOptional.get();
                ListingsDAO dao = new ListingsDAO();
                dao.runQuery(ListingsParser.saveNewListing(id, user_id));
                if (CheckIfListingExists.checkIfListingExists(id, user_id)) {
                    throw new ResponseStatusException(HttpStatus.ACCEPTED);
                }
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't create a listing.");
            }
            catch (SQLException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "SQL error");
            }
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Can't add this book to database.");
    }
}
