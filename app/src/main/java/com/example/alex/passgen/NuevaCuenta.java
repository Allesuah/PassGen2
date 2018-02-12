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
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * Created by Alex on 08/02/2018.
 *
 * Clase que registrará una nueva cuenta y guardará los datos en un archivo para luego mostrar.
 */

public class NuevaCuenta extends AppCompatActivity {

    static final String E_NOM="cuenta";
    static final String E_FIL="Filtro";
    static final String E_CONT="Pass";
    TextView nombreTV;
    TextView filtroTV;
    EditText nombreET;
    EditText filtroET;
    TextView contraTV;
    Button generador;
    Cuenta cuenta;

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

    public void guardarDatos(){
            cuenta=new Cuenta();
            cuenta.setNombre(nombreET.getText().toString());
            cuenta.setFiltro(filtroET.getText().toString());
            cuenta.setContraseña(contraTV.getText().toString());


            /*
            SharedPreferences.Editor editor = MainActivity.archivo.edit();
            editor.p
            editor.putString(E_NOM, );
            editor.putString(E_FIL, filtro);
            editor.putString(E_CONT, contra);

            editor.apply();

            Hay que convertirlo
            */


    }
    public void generarContraseña(){


    }
}
