package com.example.alex.passgen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import OpenHelper.SQLite_OpenHelper;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdaptadorPalabras mAdaptador;
    private int mCount = 0;
    public static String sharedPrefFile="com.example.alex.passgen";
    Cuenta cuenta;
    public static final int INTENTRECIBIDO=1;
    FloatingActionButton fab;
    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"Cuenta",null,1);
    SQLiteDatabase db= helper.getReadableDatabase();
    String query="SELECT * FROM Cuenta";

    Cursor c=db.rawQuery(query,null);
    List<Cuenta>listaCuenta=new ArrayList<Cuenta>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(cursor.moveToFirst()){
            do{
                listaCuenta.add(new Cuenta(
                        c.getInt(0), //id
                        c.getString(1), //Nombre
                        c.getString(2), //Pass
                        c.getString(3),//Filtro
                ));
            } while(cursor.moveToNext());

        }

    }

    public void lanzarActividad(View view){
        Intent intActividad=new Intent(this, NuevaCuenta.class);
        startActivityForResult(intActividad,INTENTRECIBIDO);

    }

    public void cargarListView(){
        //Asigna el recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //Crea un adaptador y lo llena con la info para ser mostrada

        mAdaptador = new AdaptadorPalabras(this, mListaPal);

        //Conectar el adaptador con el Recycler

        mRecyclerView.setAdapter(mAdaptador);

        //Dar al Recycler la layout

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==INTENTRECIBIDO){
            if(resultCode==RESULT_OK){
                String respuesta=data.getStringExtra(NuevaCuenta.INTCUENTA);
                cargarListView();
            }
        }
    }
}


