package com.example.examen3.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examen3.MainActivity;
import com.example.examen3.Nota;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Nota>> listaN;

    public HomeViewModel() {

    }

    public LiveData<List<Nota>> getListaNotas() {
        if(listaN==null){
            listaN= new MutableLiveData<>();
        }

        return listaN;
    }
    public void cagarLista(){



        listaN.setValue(MainActivity.listaNotas);
    }


}