package com.example.alex.passgen;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;

/**
 * Created by Alex on 01/02/2018.
 */

public class AdaptadorPalabras extends RecyclerView.Adapter<AdaptadorPalabras.WordViewHolder> {
    private final LinkedList<Cuenta> listaStrings;
    private LayoutInflater inflador;

    AdaptadorPalabras(Context contexto,LinkedList<Cuenta> listaStrings){
        inflador=LayoutInflater.from(contexto);
        this.listaStrings=listaStrings;
    }



    @Override
    public AdaptadorPalabras.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView=inflador.inflate(R.layout.listapalabras_item,parent,false); //Infla el layout con la informacion
        return new WordViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder(AdaptadorPalabras.WordViewHolder holder, int position) {
        Cuenta mCurrent = listaStrings.get(position);
        holder.cuentaTV.setText(mCurrent.getNombre());
        holder.filtroTV.setText(mCurrent.getFiltro());
        holder.contraTV.setText(mCurrent.getContraseña());
        holder.imagenV.setImageBitmap(mCurrent.getImagen());
    }

    @Override
    public int getItemCount() {
        return listaStrings.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder{ //Inicializar variables
        public final TextView cuentaTV;
        public final TextView contraTV;
        public final TextView filtroTV;
        public final ImageView imagenV;
        final AdaptadorPalabras adaptador;



        WordViewHolder(View itemView,AdaptadorPalabras adaptador){ //Se les pasa todos los items del layout más el adapatador por argumentos
            super(itemView);

            cuentaTV=(TextView)itemView.findViewById(R.id.tV_Cuenta);
            contraTV=(TextView)itemView.findViewById(R.id.tV_Contrasenia);
            filtroTV=(TextView)itemView.findViewById(R.id.tv_Filtro);
            imagenV=(ImageView)itemView.findViewById(R.id.imagen_Cuenta);
            this.adaptador=adaptador;
        }
    }
}
