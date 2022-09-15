package com.poznan.put.student.wesoly.michal.BookSharingApp.api.listings.owner;

import com.google.gson.Gson;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.ListingsParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.ResultSet;
import java.sql.SQLException;

@CrossOrigin
@RestController
public class OwnListingsController {
    @GetMapping(value = "/api/listings/own/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOwnListings(@PathVariable int id) {
        Gson gson = new Gson();
        try {
            ListingsDAO dao = new ListingsDAO();
            ResultSet resultSet = dao.runQuery(ListingsParser.getOwnListingsQuery(id));
            return gson.toJson(resultSet);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "SQL error.");
        }
    }
}
