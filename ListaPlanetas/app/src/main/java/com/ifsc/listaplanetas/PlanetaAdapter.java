package com.ifsc.listaplanetas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter {
    private int resource;
    public PlanetaAdapter(
            @NonNull Context context,
            int resource,
            @NonNull List<Planeta> objects
    ) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(getContext());

        final View view = inflater.inflate(resource, parent, false);

        final TextView textView = view.findViewById(R.id.textView);
        final ImageView imageView = view.findViewById(R.id.imageView);

        final Planeta planeta = (Planeta) getItem(position);

        textView.setText(planeta.nome);
        imageView.setImageResource(planeta.foto);

        return view;
    }
}
