package com.example.reciclatechapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormCadastro extends AppCompatActivity {

    private EditText edit_nome, edit_email, edit_senha;
    private Button bt_cadastrar;
    String[] mensagens = {
            "Preencha todos os campos",
            "Cadastro realizado com sucesso!",
            "Erro ao cadastrar!",
            "Erro de conexão com o servidor"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);
        iniciarComponentes();
        UsuarioApi usuarioApi = RetrofitClient.getUsuarioApi();

        bt_cadastrar.setOnClickListener(v -> {
            String nome = edit_nome.getText().toString().trim();
            String email = edit_email.getText().toString().trim();
            String senha = edit_senha.getText().toString().trim();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                mostrarSnackbar(v, mensagens[0]);
            } else {
                cadastrarUsuario(nome, email, senha, v, usuarioApi);

                // Aguarda um tempo e depois vai para a TelaPrincipal (opcional)
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    Intent intent = new Intent(FormCadastro.this, TelaPrincipal.class);
                    startActivity(intent);
                }, 3500); // Aguarda o tempo da Snackbar (3,5s)


            }
        });
    }

    private void cadastrarUsuario(String nome, String email, String senha, View v, UsuarioApi usuarioApi) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        Call<Usuario> call = usuarioApi.cadastrarUsuario(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    mostrarSnackbar(v, mensagens[1]);
                } else {
                    mostrarSnackbar(v, mensagens[2] + " Código: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                mostrarSnackbar(v, mensagens[3] + ": " + t.getMessage());
            }
        });
    }
    private void iniciarComponentes() {
        edit_nome = findViewById(R.id.edit_nome);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        bt_cadastrar = findViewById(R.id.bt_cadastrar);
    }
    private void mostrarSnackbar(View view, String mensagem) {
        Snackbar snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.setBackgroundTint(Color.DKGRAY);
        snackbar.setTextColor(Color.WHITE);
        snackbar.show();
    }
}
