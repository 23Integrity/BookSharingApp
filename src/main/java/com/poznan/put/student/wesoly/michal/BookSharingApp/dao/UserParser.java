package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

import com.poznan.put.student.wesoly.michal.BookSharingApp.model.User;

public class UserParser {
    public static String createSaveQuery(User user) {
        return "INSERT INTO users (login, password) VALUES ('"+ user.getLogin() + "', '" + user.getPassword() +"');";
    }

    public static String checkIfPasswordIsCorrectQuery(User user) {
        return "SELECT COUNT(1) FROM users WHERE login = '" + user.getLogin() + "' AND password = '" + user.getPassword() + "'";
    }
    public static String checkIfUserExists(User user) {
        return "SELECT COUNT(1) FROM users WHERE login = '" + user.getLogin() + "'";
    }
}
