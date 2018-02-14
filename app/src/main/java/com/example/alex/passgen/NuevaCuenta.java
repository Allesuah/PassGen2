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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

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

    public void guardarDatos(){ //Aqui estas colocando en el objeto cuenta cada dato recogido por los EditTexts
            cuenta=new Cuenta();
            cuenta.setNombre(nombreET.getText().toString());
            cuenta.setFiltro(filtroET.getText().toString());
            cuenta.setContrasenia(contraTV.getText().toString());

        SharedPreferences  mPrefs = getPreferences(MODE_PRIVATE); //Aqui estas guardando en el Preferences los datos de cada objeto Cuenta
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(cuenta);
        prefsEditor.putString("objetoCuenta", json);
        prefsEditor.commit();

    }
    public void generarContrasenia(){
        RequestQueue queue= Volley.newRequestQueue(this);
        String url="http://www.passwordrandom.com/query?command=password";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        contraTV.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });



    }
}
