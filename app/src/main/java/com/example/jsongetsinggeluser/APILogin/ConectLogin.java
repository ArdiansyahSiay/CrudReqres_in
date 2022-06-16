package com.example.jsongetsinggeluser.APILogin;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConectLogin {

    private static final String BASE_URL="https://reqres.in/";
    private static Retrofit servisRetro;

    public static Retrofit getServisRetro(){
        if (servisRetro == null){
            servisRetro = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return servisRetro;
    }
}
