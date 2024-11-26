package com.ifsc.conexaosqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("database", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS txt (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome VARCHAR)");

        final EditText txtIncluir = findViewById(R.id.texto);
        final Button btnIncluir = findViewById(R.id.btn_incluir);

        btnIncluir.setOnClickListener(view -> {
            final String texto = txtIncluir.getText().toString();

            final ContentValues cv = new ContentValues();

            cv.put("nome", texto);

            db.insert("txt", null, cv);

            listagem();
        });

        listagem();
    }

    private void listagem() {
        final Cursor cursor = db.rawQuery("SELECT t.nome FROM txt t ORDER BY t.nome DESC", null);

        final List<String> listaNotas = new ArrayList<>();

        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            final String nome = cursor.getString(cursor.getColumnIndex("nome"));

            listaNotas.add(nome);
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listaNotas
        );

        final ListView listView = findViewById(R.id.lista_notas);

        listView.setAdapter(adapter);
    }
}