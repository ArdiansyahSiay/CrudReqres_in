package com.example.jsongetsinggeluser.API;

import com.example.jsongetsinggeluser.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIretrofit {
    @GET("/api/users/2")
    Call<ResponseModel> pickData();
}
