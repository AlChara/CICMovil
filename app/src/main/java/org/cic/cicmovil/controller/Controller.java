package org.cic.cicmovil.controller;

import android.app.Application;
import android.util.Patterns;


import java.util.regex.Pattern;

/**
 * Created by PERSONAL on 26/03/2017.
 */

public class Controller extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    private boolean validarNombre(String nombre){
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        return patron.matcher(nombre).matches() || nombre.length() > 30;
    }

    private boolean validadTelefono(String telefono){
        return Patterns.PHONE.matcher(telefono).matches();
    }

    private boolean esCorreoValido(String correo){
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }
}
