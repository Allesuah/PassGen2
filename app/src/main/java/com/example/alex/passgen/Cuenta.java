package com.example.alex.passgen;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Alex on 12/02/2018.
 */

//Clase para recorrer datos.
public class Cuenta {
    //variables
    int id;
    String filtro;
    String contrasenia;
    String  nombre;




    Cuenta(int id, String filtro, String contrasenia, String nombre){
        this.filtro=filtro;
        this.contrasenia=contrasenia;
        this.nombre=nombre;
        this.id=id;

    }

    Cuenta(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }


}
