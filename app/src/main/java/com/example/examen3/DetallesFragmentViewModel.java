package com.example.examen3;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class DetallesFragmentViewModel extends ViewModel {


    private MutableLiveData<Nota> nota = new MutableLiveData<>();
    private MutableLiveData<String> mensaje= new MutableLiveData<>();

    public DetallesFragmentViewModel() {

    }

    public void recibirBundle(Bundle bundle){
        if (bundle != null) {

            String men= null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                men= bundle.getSerializable("Nota",String.class);
            }

            // Luego, puedes usar "nota" para configurar tus vistas o realizar otras acciones
            if (men!= null) {
              mensaje.setValue(men);

            }else{
                //notab=new Nota("--","Moviles", "Alumnos","detalles");
            men="no ha llegado";
                mensaje.setValue(men);
            }
        }


    }
    public LiveData<Nota> getMNota() {
        if(nota==null){
            nota= new MutableLiveData<>();
        }

        return nota;
    }
    public LiveData<String> getMen() {
        if(mensaje==null){
            mensaje = new MutableLiveData<>();
            mensaje.setValue("mensaje");
        }

        return mensaje;
    }
    /*public void cagarLista(){

        notas.setValue(MainActivity.listaNotas);


    }*/
}
