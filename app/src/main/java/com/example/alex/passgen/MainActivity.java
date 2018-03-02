package com.example.alex.passgen;

import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;



import java.util.LinkedList;


import OpenHelper.SQLite_OpenHelper;



public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener{

    private RecyclerView mRecyclerView;
    public static AdaptadorPalabras mAdaptador;
    public static final int INTENTRECIBIDO=1;
    FloatingActionButton fab;
    SQLite_OpenHelper helper;
    SQLiteDatabase db;
    String query="SELECT * FROM Cuenta";
    private CoordinatorLayout coordinatorLayout;
    Cursor c;
    LinkedList<Cuenta>listaCuenta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView =findViewById(R.id.recyclerview);
        recibirData();
        fab=findViewById(R.id.fab);
        coordinatorLayout=findViewById(R.id.coord);
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback= new RecyclerItemTouchHelper(0,ItemTouchHelper.LEFT,this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerView);



    }

    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==INTENTRECIBIDO){
            if(resultCode==RESULT_OK){
                recibirData();
                mAdaptador.notifyItemInserted(listaCuenta.size()+1);

            }
        }
    }

    public void lanzarActividad(View view){
        Intent intActividad=new Intent(this, NuevaCuenta.class);
        startActivityForResult(intActividad,INTENTRECIBIDO);

    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction,int position){
      if(viewHolder instanceof AdaptadorPalabras.WordViewHolder){
          String name=listaCuenta.get(viewHolder.getAdapterPosition()).getNombre();


          final Cuenta deletedCuenta =listaCuenta.get(viewHolder.getAdapterPosition());
          final int deletedIndex =viewHolder.getAdapterPosition();

          mAdaptador.removeItem(viewHolder.getAdapterPosition());

          Snackbar snackbar=Snackbar
                  .make(coordinatorLayout,name+" Eliminado",Snackbar.LENGTH_LONG);
          snackbar.setAction("DESHACER ?",new View.OnClickListener(){
              @Override
                      public void onClick(View view){

                  mAdaptador.restoreItem(deletedCuenta,deletedIndex);
              }
          });
          helper.eliminar(name);
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
      }
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
       /* mRecyclerView = findViewById(R.id.recyclerview);


        mRecyclerView.invalidate();

        //Crea un adaptador y lo llena con la info para ser mostrada

        mAdaptador = new AdaptadorPalabras(this, listaCuenta);


        //Conectar el adaptador con el Recycler

        mRecyclerView.setAdapter(mAdaptador);

        //Dar al Recycler la layout

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
*/
       RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getApplicationContext());
       mRecyclerView.setLayoutManager(mLayoutManager);
       mRecyclerView.setItemAnimator(new DefaultItemAnimator());
       mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));mAdaptador = new AdaptadorPalabras(this, listaCuenta);
        mAdaptador = new AdaptadorPalabras(this, listaCuenta);
       mRecyclerView.setAdapter(mAdaptador);
    }

    public void recibirData(){
        helper = new SQLite_OpenHelper(this,"Passgen",null,1);
        db =  helper.getReadableDatabase();
        c = db.rawQuery(query,null);
        leerBD();

    }
}




