package com.example.examen3;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.examen3.databinding.FragmentDetallesNotaBinding;


public class DetallesNota extends Fragment {
    private DetallesFragmentViewModel vm;
    private FragmentDetallesNotaBinding binding;
    private static Nota not;
    private Bundle bn;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    public static  DetallesNota newInstance(String param1, String param2) {

        DetallesNota fragment = new DetallesNota();
        Bundle args = new Bundle();
        args.putSerializable("Nota", not);
        fragment.setArguments(args);
        return fragment;

    }
    public DetallesNota() {
        // Required empty public constructor
    }



    @Override
    public void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            not = (Nota) bundle.getSerializable("Nota");
        }




    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle= getArguments();
        /*bn=bundle;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            not =bn.getSerializable("Nota", Nota.class);
        }*/
        if (bundle != null) {

            Nota notab = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                notab = bundle.getSerializable("Nota", Nota.class);
            }

            if (notab != null) {
                not=notab;

            }else{
                notab=new Nota("--","Moviles", "Alumnos","detalles");
                not=notab;

            }
        }
        vm = new ViewModelProvider(this).get(DetallesFragmentViewModel.class);

        binding = FragmentDetallesNotaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*vm.getMNota().observe(getViewLifecycleOwner(), new Observer<Nota>() {
            @Override
            public void onChanged(Nota nota) {
                Nota mNota= nota;
                String detalle=mNota.getDetalle();
                String materia= mNota.getMateria();
                String Nota= mNota.getNota();
                binding.tvDetalleDetalle.setText("Detalles: " +detalle);
                binding.tvDetalleMateria.setText("Materia: " + materia);
                binding.tvdetalleNota.setText("Nota: "+nota );

            }
        });*/
        String detalle=not.getDetalle();
        String materia= not.getMateria();
        String nota= not.getNota();
        String nombre= not.getAlummno();
        binding.tvDetalleDetalle.setText("detalle: "+ detalle);
        binding.tvDetalleMateria.setText("Materia: " + materia);
        binding.tvdetalleNota.setText("Nota: "+ nota);
        binding.tvDetalleNombre.setText("Alumno: "+ nombre);

        return root;
    }
}