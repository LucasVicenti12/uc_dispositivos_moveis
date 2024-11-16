package com.ifsc.listaplanetas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlanetaAdapterRecyclerView extends RecyclerView.Adapter<PlanetaAdapterRecyclerView.PlanetaVH> {
    Context context;
    int resource;
    List<Planeta> planetas;

    public PlanetaAdapterRecyclerView(Context context, int resource, List<Planeta> planetas) {
        this.context = context;
        this.resource = resource;
        this.planetas = planetas;
    }

    @NonNull
    @Override
    public PlanetaVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = View.inflate(this.context, this.resource, null);
        return new PlanetaVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetaVH holder, int position) {
        final Planeta planeta = this.planetas.get(position);

        holder.imageView.setImageResource(planeta.foto);
        holder.textView.setText(planeta.nome);
    }

    @Override
    public int getItemCount() {
        return planetas.size();
    }

    public class PlanetaVH extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public PlanetaVH(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
