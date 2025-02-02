package com.ifsc.lucasvicenti.tabelataco.controller;

import android.content.Context;

import com.ifsc.lucasvicenti.tabelataco.model.dao.AlimentoDAO;
import com.ifsc.lucasvicenti.tabelataco.model.entities.Alimento;

import java.util.List;

public class AlimentoController {
    private AlimentoDAO alimentoDAO;

    public AlimentoController(Context context) {
        this.alimentoDAO = new AlimentoDAO(context);
    }

    public List<Alimento> buscaListaAlimentos(String busca){
        return alimentoDAO.buscaListaAlimentos(busca);
    }
}
