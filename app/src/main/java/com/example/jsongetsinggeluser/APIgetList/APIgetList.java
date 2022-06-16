package com.example.jsongetsinggeluser.APIgetList;

import com.example.jsongetsinggeluser.ModelGetList.RequestModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIgetList {

    @GET("/api/unknown")
    Call<RequestModel> dataPick();
}
