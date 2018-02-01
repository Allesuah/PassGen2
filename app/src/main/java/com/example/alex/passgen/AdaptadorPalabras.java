package com.example.alex.passgen;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Alex on 01/02/2018.
 */

public class AdaptadorPalabras extends RecyclerView.Adapter<AdaptadorPalabras.WordViewHolder> {


    @Override
    public AdaptadorPalabras.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AdaptadorPalabras.WordViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder{
        public final TextView cuentaTV;
        public final TextView contraTV;
        public final TextView filtroTV;
        public final ImageView imagenV;

        WordViewHolder(View itemView1,View itemView2,View itemView3,View itemView4,AdaptadorPalabras adaptador){
            super(itemView1);

            cuentaTV=(TextView)itemView1.findViewById(R.id.tV_Cuenta);
            contraTV=(TextView)itemView2.findViewById(R.id.tV_Contrasenia);
            filtroTV=(TextView)itemView3.findViewById(R.id.tv_Filtro);
            imagenV=(ImageView)itemView4.findViewById(R.id.imagen_Cuenta);


        }
    }
}
