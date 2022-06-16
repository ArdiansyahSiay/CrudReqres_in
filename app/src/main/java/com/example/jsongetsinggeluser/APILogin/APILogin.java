package com.example.jsongetsinggeluser.APILogin;

import com.example.jsongetsinggeluser.ModelLogin.RequestModel;
import com.example.jsongetsinggeluser.ModelLogin.ResponRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APILogin {

    @POST("/api/login")
//    @FormUrlEncoded
    Call<ResponRequest> loginRequest(@Body RequestModel requestModel);
}
