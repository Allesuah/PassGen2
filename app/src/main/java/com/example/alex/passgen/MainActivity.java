package com.example.alex.passgen;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private LinkedList<String> mListaPal = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private AdaptadorPalabras mAdaptador;
    private int mCount = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i++) {
            mListaPal.addLast("BLA:" + mCount++);
            Log.d("WordList", mListaPal.getLast());
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //Crear un adaptador y llenarlo con la info para ser mostrada

        mAdaptador = new AdaptadorPalabras(this, mListaPal);

        //Conectar el adaptador con el Recycler

        mRecyclerView.setAdapter(mAdaptador);

        //Dar al Recycler la layout

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab);

    }

    public void lanzarActividad(View view){
        Intent inActividad=new Intent(this, NuevaCuenta.class);
        startActivity(inActividad);

    }
}


