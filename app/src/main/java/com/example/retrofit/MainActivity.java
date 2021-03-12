package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;

    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        usersAdapter = new UsersAdapter(new UsersAdapter.ClickedItem() {
            @Override
            public void ClickedUser(UserResponse userResponse) {
                MainActivity.this.ClickedUser(userResponse);
            }
        });

        Call<UserResponse> userlist = ApiClient.getUserService().getAllUsers();

        userlist.enqueue(
                new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if(response.isSuccessful()){
                            usersAdapter.setData(response.body().contacts);
                            recyclerView.setAdapter(usersAdapter);

                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {

                    }
                }
//                new Callback<List<UserResponse>>() {
//                    @Override
//                    public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
//
//                        if(response.isSuccessful()){
//                            List<UserResponse> userResponses = response.body();
//                            usersAdapter.setData(userResponses);
//                            recyclerView.setAdapter(usersAdapter);
//
//                        }
//
//                    }
//
//
//                    @Override
//                    public void onFailure(Call<List<UserResponse>> call, Throwable t) {
//                        Log.e("failure",t.getLocalizedMessage());
//
//                    }
//                }
        );




    }



    public void ClickedUser(UserResponse userResponse) {

//    startActivity(new Intent(this,UserDetailsActivity.class).putExtra("data",userResponse));

    }
}
