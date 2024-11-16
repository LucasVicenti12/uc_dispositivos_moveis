package com.example.explorandowidgets;

import java.io.Serializable;

public class Cadastro implements Serializable {
    final String nome;
    final String sobrenome;
    final String email;
    final String senha;
    final String confirmarSenha;

    public Cadastro(
            String nome,
            String sobrenome,
            String email,
            String senha,
            String confirmarSenha
    ) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
    }
}
