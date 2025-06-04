package com.example.reciclatechapp.retrofit;

import com.example.reciclatechapp.api.UsuarioApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://4983-45-235-105-242.ngrok-free.app";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static UsuarioApi getUsuarioApi() {
        return getRetrofitInstance().create(UsuarioApi.class);
    }
}


