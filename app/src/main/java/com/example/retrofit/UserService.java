package com.example.retrofit;

import com.example.retrofit.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

       @GET("contacts/")
    Call<UserResponse> getAllUsers();

}
