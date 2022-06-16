package com.example.jsongetsinggeluser.APIgetList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroConnection {

    private static final String BASE_URL="http://reqres.in/";
    private static Retrofit koneksi;

    public static Retrofit getKoneksi(){
        if (koneksi==null){
            koneksi = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return koneksi;
    }
}
