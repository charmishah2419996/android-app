package com.radius.assignment.model;

import java.util.List;

public class UserResponse {

    List<UserResults> results;

    public UserResponse() {
    }

    public UserResponse(List<UserResults> results) {
        this.results = results;
    }

    public List<UserResults> getResults() {
        return results;
    }

    public void setResults(List<UserResults> results) {
        this.results = results;
    }
}
