package com.radius.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radius.assignment.model.UserResponse;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class UserListActivity extends AppCompatActivity {

    private RecyclerView rvUsers;
    public static final String BASE_URL = "https://raw.githubusercontent.com";
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        rvUsers = findViewById(R.id.rv_users);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        UserInterface userInterface = retrofit.create(UserInterface.class);

        Call<UserResponse> userResponseCall = userInterface.getUsers();

        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                    rvUsers.setHasFixedSize(false);
                    linearLayoutManager = new LinearLayoutManager(UserListActivity.this);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    rvUsers.setLayoutManager(linearLayoutManager);
                    rvUsers.setItemViewCacheSize(10);
                    rvUsers.setAdapter(new UserListAdapter(response.body().getResults(), UserListActivity.this));

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("TTT", "On Failure" + t.getMessage());
            }
        });

    }
}
