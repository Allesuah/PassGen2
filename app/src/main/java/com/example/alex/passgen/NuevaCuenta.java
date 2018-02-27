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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;




import java.util.LinkedList;

import OpenHelper.SQLite_OpenHelper;




/**
 * Created by Alex on 08/02/2018.
 *
 * Clase que registrará una nueva cuenta y guardará los datos en un archivo para luego mostrar.
 */

public class NuevaCuenta extends AppCompatActivity {

    TextView nombreTV;
    TextView filtroTV;
    EditText nombreET;
    EditText filtroET;
    TextView contraTV;
    Button generador;
    public static AdaptadorPalabras mAdaptador;
    Cuenta cuenta;
    public static final String INTCUENTA="Cuenta";
    LinkedList<Cuenta> listaCuenta;
    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"Passgen",null,1);
    //public static SharedPreferences archivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aniadir_cuenta);

        nombreTV = (TextView) findViewById(R.id.NombreTag);
        filtroTV = (TextView) findViewById(R.id.FiltroTag);
        nombreET = (EditText) findViewById(R.id.NombreEt);
        filtroET = (EditText) findViewById(R.id.FiltroEt);
        contraTV = (TextView) findViewById(R.id.contraTV);
        generador = (Button) findViewById(R.id.GeneraButton);


    }

    public void guardarDatos(View view){
        helper.abrir();
        long test = helper.insertarRegistro((nombreET.getText().toString()),(contraTV.getText().toString()),(filtroET.getText().toString()));
        helper.cerrar();


        Toast.makeText(this,"Cuenta guardada",Toast.LENGTH_LONG).show();

        Intent iniciarPadre=new Intent();
        setResult(RESULT_OK,iniciarPadre);
        finish();

    }
    public void generarContrasenia(View view){
        RequestQueue queue= Volley.newRequestQueue(this);
        String url="http://www.passwordrandom.com/query?command=password";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        contraTV.setText(response);
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                contraTV.setText("No funciona el generador");
            }
        });
        queue.add(stringRequest);




    }
}