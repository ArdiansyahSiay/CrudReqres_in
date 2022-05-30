package com.example.jsongetsinggeluser.API;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface APIretrofit {
    @GET("/api/users/2")
    Call<Response> pickData();
}
