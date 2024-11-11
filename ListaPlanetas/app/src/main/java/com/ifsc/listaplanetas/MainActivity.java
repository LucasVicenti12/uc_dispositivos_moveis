package com.ifsc.listaplanetas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    List<Planeta> planetas = Arrays.asList(
            new Planeta(R.drawable.mercury, "Mercúrio"),
            new Planeta(R.drawable.venus, "Venus"),
            new Planeta(R.drawable.earth, "Terra"),
            new Planeta(R.drawable.mars, "Marte"),
            new Planeta(R.drawable.neptune, "Netuno"),
            new Planeta(R.drawable.saturn, "Saturno"),
            new Planeta(R.drawable.sun, "Sol"),
            new Planeta(R.drawable.uranus, "Urano"),
            new Planeta(R.drawable.jupter, "Júpiter")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PlanetaAdapterRecyclerView planetaAdapterRV = new PlanetaAdapterRecyclerView(this,
                R.layout.planeta_item,
                planetas
        );

        recyclerView.setAdapter(planetaAdapterRV);
    }
}