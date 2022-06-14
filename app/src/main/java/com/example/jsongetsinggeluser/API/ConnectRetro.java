package com.example.jsongetsinggeluser.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectRetro {

    private static final String BASE_URL = "https://reqres.in/";

    private static Retrofit retrofitService;

    public static Retrofit getRetrofitService(){
        if (retrofitService==null){
            retrofitService = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofitService;
    }
}
