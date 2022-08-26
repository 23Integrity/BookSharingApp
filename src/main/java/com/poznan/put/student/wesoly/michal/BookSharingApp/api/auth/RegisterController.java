package com.poznan.put.student.wesoly.michal.BookSharingApp.api.auth;

import com.google.gson.Gson;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.UserDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.UserParser;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

@RestController
public class RegisterController {
    @PostMapping(value = "/api/auth/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sign_up(@RequestParam(name = "login") Optional<String> login,
                          @RequestParam(name = "password") Optional<String> password) {

        Response jsonResponse = new Response(new HashMap<String, Object>());
        int count = 0;
        Gson gson = new Gson();

        if (login.isPresent() && password.isPresent()) {
            User user = new User(login.get(), password.get());

            try {
                UserDAO dao = new UserDAO();
                Optional<ResultSet> result =
                        Optional.ofNullable(dao.runQuery(UserParser.checkIfUserExists(user)));

                if (result.isPresent()) {
                    while (result.get().next()) {
                        count = result.get().getInt("count");
                    }
                    result.get().close();
                }

                if (count == 0) {
                    jsonResponse.addToResponseBody("register", 200);
                    return gson.toJson(jsonResponse);
                }
                jsonResponse.addToResponseBody("register", 400);
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Such user already exists.");
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error occurred while proccessing your request.");
    }
}
