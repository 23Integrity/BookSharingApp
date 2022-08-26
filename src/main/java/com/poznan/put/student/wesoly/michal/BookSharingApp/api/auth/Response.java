package com.poznan.put.student.wesoly.michal.BookSharingApp.api.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Response {
    private final Map<String, Object> responseBody;

    public Response() {
        responseBody = new HashMap<String, Object>();
    }
    public Response(Map<String, Object> responseBody) {
        this.responseBody = responseBody;
    }

    public Map<String, Object> getResponseBody() {
        return responseBody;
    }
    public void addToResponseBody(String name, Object obj) {
        Optional<Object> responseToAdd = Optional.ofNullable(obj);
        if (responseToAdd.isPresent()) {
            responseBody.put(name, responseToAdd.get());
        }
        else {
            System.out.println("Empty object");
        }
    }
}
