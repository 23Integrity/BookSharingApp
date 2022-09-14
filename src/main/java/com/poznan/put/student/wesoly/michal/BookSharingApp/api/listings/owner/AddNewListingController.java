package com.poznan.put.student.wesoly.michal.BookSharingApp.api.listings.owner;

import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsParser;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.utility.Books.CheckIfBookExists;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.Book;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@CrossOrigin
@RestController
public class AddNewListingController {
    @PostMapping(value="api/listings/add")
    public String addNewListing(@RequestParam(name="id") String id, @RequestParam(name="user") int user_id) {
        Optional<Book> bookOptional = Optional.ofNullable(CheckIfBookExists.checkIfBookExistsOrAddToDatabase(id));
        if (bookOptional.isPresent()) {
            try {
                Book book = bookOptional.get();
                ListingsDAO dao = new ListingsDAO();
                ResultSet resultSet = dao.runQuery(ListingsParser.saveNewListing(id, user_id));
                // TODO check if query was successful
            }
            catch (SQLException e) {

            }
        }

        }
}
