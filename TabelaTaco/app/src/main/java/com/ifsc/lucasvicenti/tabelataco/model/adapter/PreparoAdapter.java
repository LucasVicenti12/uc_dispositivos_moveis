package com.ifsc.lucasvicenti.tabelataco.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ifsc.lucasvicenti.tabelataco.R;
import com.ifsc.lucasvicenti.tabelataco.model.entities.Preparo;

import java.util.List;

public class PreparoAdapter extends ArrayAdapter<Preparo> {
    public PreparoAdapter(@NonNull Context context, @NonNull List<Preparo> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Preparo preparo = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.preparo_item, parent, false
            );
        }

        final TextView prepare = convertView.findViewById(R.id.prepare);

        if(preparo != null){
            prepare.setText(
                    String.format("%s - %s", preparo.codigoPreparo, preparo.formaPreparo)
            );
        }

        return convertView;
    }
}
