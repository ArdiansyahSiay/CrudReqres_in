package com.example.jsongetsinggeluser.API;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectRetro {

    private static final String BASE_URL = "http://reqres.in/";
    private static APIretrofit service;
    public APIretrofit getService(){
            if (service==null){
                OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
                Retrofit.Builder retroBuilder = new Retrofit.Builder()
                        .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = retroBuilder.client(okHttpBuilder.build()).build();

                service = retrofit.create(APIretrofit.class);

            }
            return service;
    }
}
