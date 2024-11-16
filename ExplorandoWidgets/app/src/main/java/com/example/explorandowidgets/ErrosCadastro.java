package com.example.explorandowidgets;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class ErrosCadastro {
    static final String NOME_INVALIDO = "Nome deve ser informado";
    static final String SOBRENOME_INVALIDO = "Sobrenome deve ser informado";
    static final String EMAIL_INVALIDO = "Email deve ser informado";
    static final String SENHA_INVALIDA = "Senha deve ser informado";
    static final String CONFIRMACAO_SENHA_INVALIDA = "Confirmação da senha deve ser informado";
    static final String SENHA_NAO_BATE = "Confirmação da senha não bate com a senha";
    static final String SENHA_INVALIDA_TAMANHO = "Senha deve ter no minimo 8 caracteres";

    static void mostraAlerta(Context context, String mensagem) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder
                .setTitle("Erro cadastro")
                .setMessage(mensagem)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
}
