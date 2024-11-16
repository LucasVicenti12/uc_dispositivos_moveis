package com.example.explorandowidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CadastroResultado extends AppCompatActivity {
    TextView nome;
    TextView email;
    TextView senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_resultado);

        nome = findViewById(R.id.result_name);
        email = findViewById(R.id.result_email);
        senha = findViewById(R.id.result_senha);

        final Cadastro cadastro = (Cadastro) getIntent().getSerializableExtra("cadastro");

        if(cadastro != null){
            nome.setText(String.format("%s %s", cadastro.nome, cadastro.sobrenome));
            email.setText(cadastro.email);

            final String senhaOmitida =
                    cadastro.senha.substring(0, 5) +
                    "*".repeat(cadastro.senha.substring(5).length());

            senha.setText(senhaOmitida);
        }
    }
}