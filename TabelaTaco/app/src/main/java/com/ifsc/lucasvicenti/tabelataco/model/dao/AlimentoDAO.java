package com.ifsc.lucasvicenti.tabelataco.model.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ifsc.lucasvicenti.tabelataco.model.entities.Alimento;
import com.ifsc.lucasvicenti.tabelataco.model.entities.Preparo;

import org.intellij.lang.annotations.Language;

import java.util.ArrayList;
import java.util.List;

public class AlimentoDAO {
    private final SQLiteDatabase db;
    @Language("RoomSql")
    private final String alimentoQuery = "SELECT codigo, " +
            "nome_alimento, " +
            "categoria FROM alimentos_lip_acucares_100g a ";

    @Language("RoomSql")
    private final String preparoQuery = "SELECT cod_preparo, " +
            "forma_preparo FROM alimentos_lip_acucares_100g a WHERE a.codigo = ?";

    public AlimentoDAO(Context context) {
        this.db = context.openOrCreateDatabase("tabela_taco", Context.MODE_PRIVATE, null);
    }

    public List<Alimento> buscaListaAlimentos(String busca) {
        String query = alimentoQuery;
        String[] args = null;

        if (!busca.isBlank()) {
            query += "WHERE a.codigo || ' ' || a.nome_alimento LIKE '%' || ? || '%' ";
            args = new String[]{busca};
        }

        query += "GROUP BY a.codigo, a.nome_alimento, a.categoria ORDER BY a.codigo, a.nome_alimento";

        final Cursor cursor = db.rawQuery(query, args);
        final List<Alimento> alimentos = new ArrayList<>();

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            final Cursor cursor1 = db.rawQuery(preparoQuery, new String[]{Long.toString(cursor.getLong(0))});

            final List<Preparo> preparos = new ArrayList<>();

            cursor1.moveToFirst();

            while (!cursor1.isAfterLast()) {
                preparos.add(
                        new Preparo(
                                cursor1.getLong(0),
                                cursor1.getString(1)
                        )
                );

                cursor1.moveToNext();
            }

            alimentos.add(
                    new Alimento(
                            cursor.getLong(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            preparos
                    )
            );

            cursor.moveToNext();
        }

        return alimentos;
    }
}
