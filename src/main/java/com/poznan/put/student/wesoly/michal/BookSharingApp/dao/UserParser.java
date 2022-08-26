package com.poznan.put.student.wesoly.michal.BookSharingApp.dao;

import com.poznan.put.student.wesoly.michal.BookSharingApp.model.User;

public class UserParser {
    //Metoda tworząca zapytanie SQL zapisujące uzytkownika do bazy
    public static String createSaveQuery(User user) {
        return "INSERT INTO users VALUES ('"+ user.getLogin() + "', '" + user.getPassword() +"');";
    }

    public static String checkIfPasswordIsCorrectQuery(User user) {
        return "SELECT COUNT(1) AS 'count' FROM users WHERE login = '" + user.getLogin() + "' AND password = '" + user.getPassword() + "'";
    }
    public static String checkIfUserExists(User user) {
        return "SELECT COUNT(1) AS 'count' FROM users WHERE login = '" + user.getLogin() + "'";
    }
}
