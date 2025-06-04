package com.example.reciclatechapp.api;

import com.example.reciclatechapp.models.Caixa;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface CaixaApi {

    @GET("caixa")
    Call<List<Caixa>> getAllCaixa();


    @GET("caixa/latest")
    Call<Caixa> getLatestCaixa();

    @GET("caixa/{id}")
    Call<Caixa> getCaixaById(@Path("id") Integer id);

    @POST("caixa")
    Call<Caixa> addCaixaEntry(@Body Caixa newEntry);

    @PUT("caixa/{id}")
    Call<Caixa> updateCaixa(@Path("id") Integer id, @Body Caixa caixaDetails);

    @DELETE("caixa/{id}")
    Call<Void> deleteCaixa(@Path("id") Integer id);
}

