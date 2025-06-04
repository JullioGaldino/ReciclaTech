package com.example.reciclatechapp.back_act;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.reciclatechapp.R;
import com.example.reciclatechapp.api.SaidaApi;
import com.example.reciclatechapp.models.Saida;
import com.example.reciclatechapp.retrofit.RetrofitClient;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroSaida extends AppCompatActivity {

    private EditText editFuncionario, editValor, editFormaPagamento, editDesc_produto;
    private Button btnSalvar;
    private final String[] mensagens = {
            "Preencha todos os campos",
            "Saída registrada com sucesso!",
            "Erro ao registrar saída",
            "Erro de conexão com o servidor"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_saida);
        iniciarComponentes();

        SaidaApi saidaApi = RetrofitClient.getRetrofitInstance().create(SaidaApi.class);

        btnSalvar.setOnClickListener(v -> {
            String funcionario = editFuncionario.getText().toString().trim();
            String valorStr = editValor.getText().toString().trim();
            String formaPagamento = editFormaPagamento.getText().toString().trim();
            String Desc_produto = editDesc_produto.getText().toString().trim();

            if (funcionario.isEmpty() || valorStr.isEmpty() || formaPagamento.isEmpty() || Desc_produto.isEmpty()) {
                mostrarSnackbar(v, mensagens[0]);
            } else {
                float valor = Float.parseFloat(valorStr);
                registrarSaida(funcionario, valor, formaPagamento, Desc_produto, v, saidaApi);
            }
        });
    }

    private void registrarSaida(String funcionario, float valor, String formaPagamento, String desc_produto, View v, SaidaApi saidaApi) {
        Saida saida = new Saida();
        saida.setFuncionario(funcionario);
        saida.setValor(valor);
        saida.setForma_de_Pg(formaPagamento);
        saida.setDesc_produto(desc_produto);

        Call<Saida> call = saidaApi.registrarSaida(saida);
        call.enqueue(new Callback<Saida>() {
            @Override
            public void onResponse(Call<Saida> call, Response<Saida> response) {
                if (response.isSuccessful()) {
                    mostrarSnackbar(v, mensagens[1]);
                } else {
                    mostrarSnackbar(v, mensagens[2] + " Código: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Saida> call, Throwable t) {
                mostrarSnackbar(v, mensagens[3] + ": " + t.getMessage());
            }
        });
    }

    private void iniciarComponentes() {
        editFuncionario = findViewById(R.id.editNovoFuncionario);
        editValor = findViewById(R.id.editValor);
        editFormaPagamento = findViewById(R.id.editFormaPagamento);
        editDesc_produto = findViewById(R.id.editMotivo);
        btnSalvar = findViewById(R.id.btnSalvar);
    }

    private void mostrarSnackbar(View view, String mensagem) {
        Snackbar snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.setBackgroundTint(Color.DKGRAY);
        snackbar.setTextColor(Color.WHITE);
        snackbar.show();
    }
}