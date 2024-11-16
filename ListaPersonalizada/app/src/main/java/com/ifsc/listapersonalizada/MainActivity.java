package com.ifsc.listapersonalizada;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.list_view);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                lista
        );

        listView.setAdapter(adapter);

        final Button btnConfirmar = findViewById(R.id.btn_confirmar);
        final EditText texto = findViewById(R.id.campo_texto);

        btnConfirmar.setOnClickListener(view -> {
            final String valor = texto.getText().toString();

            if (valor.isEmpty()) {
                new AlertDialog.Builder(this)
                        .setTitle("Valor inválido")
                        .setMessage("Informe um valor válido")
                        .create()
                        .show();
                return;
            }

            adapter.add(valor);
        });
    }
}