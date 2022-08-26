package com.poznan.put.student.wesoly.michal.BookSharingApp.api.auth.errors;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserExistsStatus {
    public String UserExistsStatusException() {
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Such user already exists.");
    }
}
