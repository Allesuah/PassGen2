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
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import OpenHelper.SQLite_OpenHelper;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public static AdaptadorPalabras mAdaptador;
    public static final int INTENTRECIBIDO=1;
    FloatingActionButton fab;
    SQLite_OpenHelper helper;
    SQLiteDatabase db;
    String query="SELECT * FROM Cuenta";

    Cursor c;
    LinkedList<Cuenta>listaCuenta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recibirData();

        //Toast.makeText(this,"Nombre:"+listaCuenta.get(0).getNombre(),Toast.LENGTH_LONG).show();

    }

    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==INTENTRECIBIDO){
            if(resultCode==RESULT_OK){

            }
        }
    }

    public void lanzarActividad(View view){
        Intent intActividad=new Intent(this, NuevaCuenta.class);
        startActivityForResult(intActividad,INTENTRECIBIDO);

    }

    /*public void updateBD(){

        this.mAdaptador.notifyDataSetChanged();
        Notificar al recycler view que se ha actualizado la información y visualizar
        mRecyclerView.getAdapter().notifyItemInserted(w);
    }*/

    public void resetearInfo(){
        mAdaptador.notifyDataSetChanged();
        recibirData();

    }

    public void leerBD(){
        listaCuenta=new LinkedList<Cuenta>();

        if(c.moveToFirst()){
            do{
                listaCuenta.add(new Cuenta(
                        c.getInt(0), //id
                        c.getString(1), //Nombre
                        c.getString(2), //Pass
                        c.getString(3)//Filtro
                ));
            } while(c.moveToNext());

        }else{
            Toast.makeText(this,"NINGUN VALOR",Toast.LENGTH_LONG).show();
        }
        cargarListView();
    }

    public void cargarListView(){
        //Asigna el recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);


        mRecyclerView.invalidate();

        //Crea un adaptador y lo llena con la info para ser mostrada

        mAdaptador = new AdaptadorPalabras(this, listaCuenta);


        //Conectar el adaptador con el Recycler

        mRecyclerView.setAdapter(mAdaptador);

        //Dar al Recycler la layout

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void recibirData(){
        helper = new SQLite_OpenHelper(this,"Passgen",null,1);
        db =  helper.getReadableDatabase();
        c = db.rawQuery(query,null);
        leerBD();

    }
}




