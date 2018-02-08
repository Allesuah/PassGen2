package com.example.alex.passgen;

import android.content.Intent;
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

    TextView nombreTV;
    TextView filtroTV;
    EditText nombreET;
    EditText filtroET;
    TextView contraTV;
    Button generador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aniadir_cuenta);

        nombreTV=(TextView)findViewById(R.id.NombreTag);
        filtroTV=(TextView)findViewById(R.id.FiltroTag);
        nombreET=(EditText) findViewById(R.id.NombreEt);
        filtroET=(EditText)findViewById(R.id.FiltroEt);
        contraTV=(TextView)findViewById(R.id.contraTV);
        generador=(Button)findViewById(R.id.GeneraButton);




    }
}
