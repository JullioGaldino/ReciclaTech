package com.example.reciclatechapp.api;

import com.example.reciclatechapp.models.Saida;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SaidaApi {
    @POST("registro_de_saida")
    Call<Saida> registrarSaida(@Body Saida saida);
}