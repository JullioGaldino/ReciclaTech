package com.example.reciclatechapp.back_act;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.reciclatechapp.R;
import com.example.reciclatechapp.api.CaixaApi;
import com.example.reciclatechapp.models.Caixa;
import com.example.reciclatechapp.retrofit.RetrofitClient;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fcaixa extends AppCompatActivity {
    private EditText editValor, editResponsavel, editMetodoPg;
    private Button btnSalvar;
    private TextView tvSaldoTotal, tvSaidasDia;

    private CaixaApi caixaApi;

    String[] mensagens = {
            "Preencha todos os campos",
            "Entrada adicionada com sucesso!",
            "Erro ao adicionar entrada",
            "Falha na conexão ao adicionar entrada",
            "Valor inválido",
            "Erro ao buscar saldo inicial",
            "Falha na conexão ao buscar saldo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caixa);

        iniciarComponentes();
        configurarApi();
        buscarSaldoInicial();
        configurarListeners();
    }

    private void iniciarComponentes() {
        tvSaldoTotal = findViewById(R.id.tvSaldoTotal);
        tvSaidasDia = findViewById(R.id.tvSaidasDia);
        editValor = findViewById(R.id.editValor3);
        editResponsavel = findViewById(R.id.editNovoFuncionario3);
        editMetodoPg = findViewById(R.id.editFormaPagamento3);
        btnSalvar = findViewById(R.id.btnSalvar);
    }

    private void configurarApi() {
        caixaApi = RetrofitClient.getRetrofitInstance().create(CaixaApi.class);
    }

    private void buscarSaldoInicial() {
        Call<Caixa> call = caixaApi.getLatestCaixa();
        call.enqueue(new Callback<Caixa>() {
            @Override
            public void onResponse(Call<Caixa> call, Response<Caixa> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Caixa latestCaixa = response.body();
                    atualizarSaldoTotalUI(latestCaixa.getSaldoTotal());
                } else {
                    atualizarSaldoTotalUI(0.0f);
                }
            }

            @Override
            public void onFailure(Call<Caixa> call, Throwable t) {
                atualizarSaldoTotalUI(0.0f);
                mostrarSnackbar(findViewById(android.R.id.content), mensagens[6]);
            }
        });
    }

    private void configurarListeners() {
        btnSalvar.setOnClickListener(v -> {
            String valorStr = editValor.getText().toString().trim();
            String responsavel = editResponsavel.getText().toString().trim();
            String metodoPg = editMetodoPg.getText().toString().trim();

            if (valorStr.isEmpty() || responsavel.isEmpty() || metodoPg.isEmpty()) {
                mostrarSnackbar(v, mensagens[0]);
                return;
            }

            try {
                Float valor = Float.parseFloat(valorStr);

                Caixa novaEntrada = new Caixa(valor, responsavel, metodoPg);


                adicionarEntrada(novaEntrada, v);

            } catch (NumberFormatException e) {
                mostrarSnackbar(v, mensagens[4]);
            }
        });
    }

    private void adicionarEntrada(Caixa novaEntrada, View view) {
        Call<Caixa> call = caixaApi.addCaixaEntry(novaEntrada);
        call.enqueue(new Callback<Caixa>() {
            @Override
            public void onResponse(Call<Caixa> call, Response<Caixa> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Caixa caixaSalva = response.body();

                    atualizarUltimaSaidaUI(caixaSalva.getValor());
                    atualizarSaldoTotalUI(caixaSalva.getSaldoTotal());

                    mostrarSnackbar(view, mensagens[1]);
                    limparCampos();
                } else {
                    mostrarSnackbar(view, mensagens[2] + " Código: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Caixa> call, Throwable t) {
                mostrarSnackbar(view, mensagens[3]);
            }
        });
    }


    private void atualizarSaldoTotalUI(Float saldo) {
        String saldoFormatado = String.format(Locale.getDefault(), "Saldo Total: R$ %.2f", saldo != null ? saldo : 0.0f);
        tvSaldoTotal.setText(saldoFormatado);
    }

    private void atualizarUltimaSaidaUI(Float valor) {
        String saidaFormatada = String.format(Locale.getDefault(), "Última Saída: R$ %.2f", valor != null ? valor : 0.0f);
        tvSaidasDia.setText(saidaFormatada);
    }

    private void limparCampos() {
        editValor.setText("");
        editResponsavel.setText("");
        editMetodoPg.setText("");

    }
    private void mostrarSnackbar(View view, String mensagem) {
        Snackbar snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.setBackgroundTint(Color.DKGRAY);
        snackbar.setTextColor(Color.WHITE);
        snackbar.show();
    }
}

