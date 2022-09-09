package com.poznan.put.student.wesoly.michal.BookSharingApp.api.books;

import com.google.gson.Gson;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.BooksTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleBooksAPIController {
    private final RestTemplate restTemplate;
    private final String apiKey = "AIzaSyAgHkBbf_jGchkIK_RFIO-n7owTG4k0Jos";

    public GoogleBooksAPIController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

//    public String getBookSearchDataJSON(String title) {
//        String url = "https://www.googleapis.com/books/v1/volumes?q="+title+"&key="+apiKey;
//        Gson gson = new Gson();
//        return gson.toJson(this.restTemplate.getForObject(url, String.class));
//    }
//
//    public String getBookSearchDataJSON(String title, String author) {
//        String url = "https://www.googleapis.com/books/v1/volumes?q="+title+"+inauthor:"+author+"&key="+apiKey;
//        Gson gson = new Gson();
//        return gson.toJson(this.restTemplate.getForObject(url, String.class));
//    }
    public BooksTemplate getBookISBNJSON(String isbn) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:"+isbn+"&key="+apiKey;
        Gson gson = new Gson();

        return gson.fromJson(this.restTemplate.getForObject(url, String.class), BooksTemplate.class);
    }
}
