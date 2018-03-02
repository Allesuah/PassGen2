package com.example.alex.passgen;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
        holder.contraTV.setText(mCurrent.getContrasenia());

    }

    @Override
    public int getItemCount() {
        return listaStrings.size();
    }

    //Elimina linea
    public void removeItem(int position){
        listaStrings.remove(position);
        notifyItemRemoved(position);
    }

    //Restaura linea
    public void restoreItem(Cuenta cuenta, int position){
        listaStrings.add(position,cuenta);
        notifyItemInserted(position);
    }



    class WordViewHolder extends RecyclerView.ViewHolder{ //Inicializar variables
        public final TextView cuentaTV,contraTV,filtroTV;
        final AdaptadorPalabras adaptador;
        public RelativeLayout frontal,fondo;



        WordViewHolder(View itemView,AdaptadorPalabras adaptador){ //Se les pasa todos los items del layout más el adapatador por argumentos
            super(itemView);

            cuentaTV=itemView.findViewById(R.id.tV_Cuenta);
            contraTV=itemView.findViewById(R.id.tV_Contrasenia);
            filtroTV=itemView.findViewById(R.id.tv_Filtro);
            frontal=itemView.findViewById(R.id.delantera);
            fondo=itemView.findViewById(R.id.fondo);
            this.adaptador=adaptador;
        }
    }
}
