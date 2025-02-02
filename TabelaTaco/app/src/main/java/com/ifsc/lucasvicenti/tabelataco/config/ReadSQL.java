package com.ifsc.lucasvicenti.tabelataco.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadSQL {
    public static void read(
            Context context,
            SQLiteDatabase db,
            String file
    ) throws Exception {
        final InputStream stream = context.getAssets().open(file);
        try (
                final BufferedReader buffer = new BufferedReader(
                        new InputStreamReader(stream)
                )
        ) {
            final StringBuilder command = new StringBuilder();
            String line;

            while ((line = buffer.readLine()) != null) {
                command.append(line);

                if (line.contains(";")) {
                    db.execSQL(command.toString());

                    command.setLength(0);
                }
            }
        }
    }
}
