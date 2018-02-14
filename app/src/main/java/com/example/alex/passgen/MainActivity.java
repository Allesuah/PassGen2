package com.example.alex.passgen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private LinkedList<Cuenta> mListaPal;
    private RecyclerView mRecyclerView;
    private AdaptadorPalabras mAdaptador;
    private int mCount = 0;
    public static SharedPreferences archivo;
    public static String sharedPrefFile="com.example.alex.passgen";
    Cuenta cuenta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        archivo=getSharedPreferences(sharedPrefFile,MODE_PRIVATE);

       if(savedInstanceState!=null){ //Aqui estas recibiendo los datos guardados en Preferences (añadidos en NuevaCuenta.java)
           Gson gson = new Gson();
           String json = archivo.getString("objetoCuenta", "");
           Cuenta recibeDato = gson.fromJson(json, Cuenta.class);

       }else{//Si no hay nada en el Preferences creas una lista de tipo Cuenta
           mListaPal=new LinkedList<>();
       }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //Crea un adaptador y lo llena con la info para ser mostrada

        mAdaptador = new AdaptadorPalabras(this, mListaPal);

        //Conectar el adaptador con el Recycler

        mRecyclerView.setAdapter(mAdaptador);

        //Dar al Recycler la layout

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab);

    }

    public void lanzarActividad(View view){
        Intent intActividad=new Intent(this, NuevaCuenta.class);
        startActivity(intActividad);

    }
}


