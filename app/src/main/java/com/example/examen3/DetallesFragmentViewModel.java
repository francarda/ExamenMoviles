package com.example.examen3;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class DetallesFragmentViewModel extends ViewModel {


    private MutableLiveData<Nota> nota = new MutableLiveData<>();

    public DetallesFragmentViewModel() {

    }

    public void recibirBundle(Bundle bundle){
        if (bundle != null) {

            Nota notab = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                notab = bundle.getSerializable("Nota", Nota.class);
            }

            if (notab != null) {
              nota.setValue(notab);

            }else{
                notab=new Nota("--","Moviles", "Alumnos","detalles");

                nota.setValue(notab);
            }
        }


    }
    public LiveData<Nota> getMNota() {
        /*if(nota==null){
            nota= new MutableLiveData<>();
        }*/

        return nota;
    }
    /*public void cagarLista(){

        notas.setValue(MainActivity.listaNotas);


    }*/
}
