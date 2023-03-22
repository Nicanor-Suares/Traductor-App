package com.example.traductor;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData <String> resultado = null;
    private HashMap palabras = new HashMap<String, String>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
        guardarPalabras();
    }

    public void guardarPalabras(){
        palabras.put("casa", "house");
        palabras.put("cocina", "kitchen");
        palabras.put("auto", "car");
        palabras.put("moto", "motorcycle");
        palabras.put("agua", "water");
    }

    public MutableLiveData<String> getResultado() {
        if (resultado == null) {
            resultado = new MutableLiveData<>();
        }
        return resultado;
    }

    public void traducir(String palabra) {
        String traduccion = (String) palabras.get(palabra);
        if (traduccion != null) {
            resultado.setValue(traduccion);
        } else {
            resultado.setValue("Palabra no encontrada");
        }
    }

}
