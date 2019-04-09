package com.radius.assignment;

import com.radius.assignment.model.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface UserInterface {

    @GET("/iranjith4/radius-intern-mobile/master/users.json")
    Call<UserResponse> getUsers();
}
