package com.example.reciclatechapp.api;

import com.example.reciclatechapp.models.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioApi {
    @POST("usuario")
    Call<Usuario> cadastrarUsuario(@Body Usuario usuario);
}
