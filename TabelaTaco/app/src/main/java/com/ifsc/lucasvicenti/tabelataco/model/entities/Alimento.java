package com.ifsc.lucasvicenti.tabelataco.model.entities;

import java.util.List;

public class Alimento {
    public final Long codigo;
    public final String nome;
    public final String categoria;
    public final List<Preparo> preparos;

    public Alimento(
            Long codigo,
            String nome,
            String categoria,
            List<Preparo> preparos
    ) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preparos = preparos;
    }
}
