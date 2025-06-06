    package com.example.reciclatechapp.back_act;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    import com.example.reciclatechapp.R;

    public class TelaPrincipal extends AppCompatActivity {


        private ImageView bt_saida;
        private ImageView bt_caixa;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_tela_principal);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            IniciarComponetes();

            bt_saida.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(TelaPrincipal.this,Fsaida.class);
                    startActivity(intent);

                }
            });

            bt_caixa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(TelaPrincipal.this,Fcaixa.class);
                    startActivity(intent);

                }
            });

        }
        private void IniciarComponetes(){
            bt_saida = findViewById(R.id.bt_saida);
            bt_caixa = findViewById(R.id.bt_caixa);

        }
    }