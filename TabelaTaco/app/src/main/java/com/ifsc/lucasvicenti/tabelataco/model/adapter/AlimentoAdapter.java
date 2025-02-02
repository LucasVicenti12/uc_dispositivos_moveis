package com.ifsc.lucasvicenti.tabelataco.model.adapter;

import android.annotation.SuppressLint;
import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ifsc.lucasvicenti.tabelataco.R;
import com.ifsc.lucasvicenti.tabelataco.model.entities.Alimento;

import java.util.List;

public class AlimentoAdapter extends ArrayAdapter<Alimento> {
    public AlimentoAdapter(@NonNull Context context, @NonNull List<Alimento> objects) {
        super(context, 0, objects);
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Alimento alimento = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.alimento_item, parent, false
            );
        }

        final TextView code = convertView.findViewById(R.id.code);
        final TextView name = convertView.findViewById(R.id.name);
        final TextView category = convertView.findViewById(R.id.category);

        final View content = convertView.findViewById(R.id.content);
        final View header = convertView.findViewById(R.id.header);
        final ListView prepareList = convertView.findViewById(R.id.prepare_list);

        if (alimento != null) {
            code.setText(alimento.codigo.toString());
            name.setText(alimento.nome);
            category.setText(alimento.categoria);
            prepareList.setAdapter(
                    new PreparoAdapter(getContext(), alimento.preparos)
            );

            ajustarAlturaPreparo(prepareList);
        }

        header.setOnClickListener(l -> {
            if(content.getVisibility() == View.VISIBLE){
                content.setVisibility(View.GONE);
            }else{
                content.setVisibility(View.VISIBLE);
            }
        });

        return convertView;
    }

    private void ajustarAlturaPreparo(ListView preparo){
        final Adapter adapter = preparo.getAdapter();
        double alturaTotal = 0;

        for(int i = 0; i < adapter.getCount(); i++){
            final View item = adapter.getView(i, null, preparo);

            item.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            );

            alturaTotal += item.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = preparo.getLayoutParams();

        params.height = (int) alturaTotal + (preparo.getDividerHeight() * (adapter.getCount() - 1));

        preparo.setLayoutParams(params);
        preparo.requestLayout();
    }
}
