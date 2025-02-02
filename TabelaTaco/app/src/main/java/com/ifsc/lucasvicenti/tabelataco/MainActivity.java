package com.ifsc.lucasvicenti.tabelataco;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static com.ifsc.lucasvicenti.tabelataco.config.ReadSQL.read;

import androidx.appcompat.app.AppCompatActivity;

import com.ifsc.lucasvicenti.tabelataco.controller.AlimentoController;
import com.ifsc.lucasvicenti.tabelataco.model.adapter.AlimentoAdapter;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    ListView listaAlimentos;
    EditText barraDeBusca;
    AlimentoController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createConnection();

        controller = new AlimentoController(this);

        listaAlimentos = findViewById(R.id.food_list);
        barraDeBusca = findViewById(R.id.search);
    }

    @Override
    protected void onStart() {
        super.onStart();

        carregaLista("");

        barraDeBusca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                carregaLista(s.toString());
            }
        });
    }

    private void createConnection() {
        this.db = openOrCreateDatabase("tabela_taco", MODE_PRIVATE, null);
        try {
            read(this, this.db, "taco_sqlite.sql");

            Toast.makeText(this, getString(R.string.importacao_concluida), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void carregaLista(String busca){
        listaAlimentos.setAdapter(
                new AlimentoAdapter(this, controller.buscaListaAlimentos(busca))
        );
    }
}