package com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Book implements Serializable {
    public ISBN id = new ISBN("ISBN-13", "0");
    public String title = null;
    public List<String> authors = null;
}
