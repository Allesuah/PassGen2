package com.example.alex.passgen;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Alex on 12/02/2018.
 */

//Clase para recorrer datos.
public class Cuenta {
    //variables
    String filtro;
    String contraseña;
    String  nombre;
    Bitmap imagen;

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String toJSON(){
        //Falta poner comillas simples
        return'{filtro:"'+filtro+'", contraseña:'"+contraseña+"', nombre:'"+nombre+"'imagen:'"+imagen+"'}';
    }
}
