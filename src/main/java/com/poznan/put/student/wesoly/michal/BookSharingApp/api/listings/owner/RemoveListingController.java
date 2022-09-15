package com.poznan.put.student.wesoly.michal.BookSharingApp.api.listings.owner;

import com.google.gson.Gson;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsParser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.ResultSet;
import java.sql.SQLException;

@CrossOrigin
@RestController
public class RemoveListingController {
    @DeleteMapping(value = "/api/listings/delete")
    public void removeListing(@RequestParam(name = "listing") int listing_id) {
        Gson gson = new Gson();
        try {
            ListingsDAO dao = new ListingsDAO();
            ResultSet resultSet = dao.runQuery(ListingsParser.deleteListing(listing_id));
            if (resultSet.next()) {
                throw new ResponseStatusException(HttpStatus.OK, "Success");
            }
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Can't delete this record");
        }
        catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Can't delete this record (exception).");
        }
    }
}
