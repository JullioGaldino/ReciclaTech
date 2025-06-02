package com.reciclagem.entradas;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrarEntradaActivity extends AppCompatActivity {

    private EditText etFuncionario, etValor, etMotivo;
    private Spinner spinnerFormaPagamento;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_entrada);

        etFuncionario = findViewById(R.id.etFuncionario);
        etValor = findViewById(R.id.etValor);
        etMotivo = findViewById(R.id.etMotivo);
        spinnerFormaPagamento = findViewById(R.id.spinnerFormaPagamento);
        btnSalvar = findViewById(R.id.btnSalvar);

        String[] formasPagamento = {"Dinheiro", "Cartão", "Pix"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, formasPagamento);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFormaPagamento.setAdapter(adapter);

        btnSalvar.setOnClickListener(v -> salvarEntrada());
    }

    private void salvarEntrada() {
        String funcionario = etFuncionario.getText().toString();
        String valor = etValor.getText().toString();
        String motivo = etMotivo.getText().toString();
        String forma = spinnerFormaPagamento.getSelectedItem().toString();

        if (funcionario.isEmpty() || valor.isEmpty() || motivo.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Aqui você pode integrar com o backend
        Toast.makeText(this, "Entrada salva com sucesso!", Toast.LENGTH_LONG).show();
    }
}
