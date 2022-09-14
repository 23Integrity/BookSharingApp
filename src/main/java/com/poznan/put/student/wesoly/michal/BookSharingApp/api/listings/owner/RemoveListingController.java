package com.poznan.put.student.wesoly.michal.BookSharingApp.api.listings.owner;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RemoveListingController {
    @DeleteMapping(value = "/api/listings/delete")
    public String removeListing(@RequestParam(name = "id") int id, @RequestParam(name = "listing") int listing_id) {
        Gson gson = new Gson();
        // TODO - check how to write a delete query, create a parser and create this functionality
    }
}
