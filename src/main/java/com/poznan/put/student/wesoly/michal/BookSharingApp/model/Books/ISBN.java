package com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books;

public class ISBN {
    public String type;
    public String identifier;

    public ISBN(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
