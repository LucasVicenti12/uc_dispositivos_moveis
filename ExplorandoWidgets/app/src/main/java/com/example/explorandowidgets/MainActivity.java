package com.example.explorandowidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import static com.example.explorandowidgets.ErrosCadastro.mostraAlerta;
import static com.example.explorandowidgets.ErrosCadastro.NOME_INVALIDO;
import static com.example.explorandowidgets.ErrosCadastro.SOBRENOME_INVALIDO;
import static com.example.explorandowidgets.ErrosCadastro.EMAIL_INVALIDO;
import static com.example.explorandowidgets.ErrosCadastro.SENHA_INVALIDA;
import static com.example.explorandowidgets.ErrosCadastro.CONFIRMACAO_SENHA_INVALIDA;
import static com.example.explorandowidgets.ErrosCadastro.SENHA_NAO_BATE;
import static com.example.explorandowidgets.ErrosCadastro.SENHA_INVALIDA_TAMANHO;

public class MainActivity extends AppCompatActivity {
    EditText nome;
    EditText sobrenome;
    EditText email;
    EditText senha;
    EditText confirmarSenha;
    Button botaoCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.name);
        sobrenome = findViewById(R.id.surname);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.password);
        confirmarSenha = findViewById(R.id.confirmPassword);
        botaoCadastro = findViewById(R.id.registerButton);

        botaoCadastro.setOnClickListener(view -> {
            final String nomeVal = nome.getText().toString();
            final String sobrenomeVal = sobrenome.getText().toString();
            final String emailVal = email.getText().toString();
            final String senhaVal = senha.getText().toString();
            final String confirmarSenhaVal = confirmarSenha.getText().toString();

            final StringBuilder errosConcat = new StringBuilder();

            if(nomeVal.isEmpty()){
                errosConcat.append(NOME_INVALIDO).append("\n");
            }
            if(sobrenomeVal.isEmpty()){
                errosConcat.append(SOBRENOME_INVALIDO).append("\n");
            }
            if(emailVal.isEmpty()){
                errosConcat.append(EMAIL_INVALIDO).append("\n");
            }
            if(senhaVal.isEmpty()){
                errosConcat.append(SENHA_INVALIDA).append("\n");
            }
            if(senhaVal.length() < 8){
                errosConcat.append(SENHA_INVALIDA_TAMANHO).append("\n");
            }
            if(confirmarSenhaVal.isEmpty()){
                errosConcat.append(CONFIRMACAO_SENHA_INVALIDA).append("\n");
            }
            if(!senhaVal.equals(confirmarSenhaVal)){
                errosConcat.append(SENHA_NAO_BATE).append("\n");
            }

            if (errosConcat.length() > 0){
                mostraAlerta(this, errosConcat.toString());
                return;
            }

            final Cadastro cadastro = new Cadastro(
                    nomeVal,
                    sobrenomeVal,
                    emailVal,
                    senhaVal,
                    confirmarSenhaVal
            );

            final Intent intent = new Intent(getApplicationContext(), CadastroResultado.class);
            intent.putExtra("cadastro", cadastro);
            startActivity(intent);
        });
    }
}