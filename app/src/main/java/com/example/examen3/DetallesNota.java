package com.example.examen3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examen3.databinding.FragmentDetallesBinding;


public class DetallesNota extends Fragment {
    private DetallesFragmentViewModel vm;
    private FragmentDetallesBinding binding;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Bundle bn;
    private String mParam1;
    private String mParam2;
    public static  DetallesNota newInstance(String param1, String param2) {
        DetallesNota fragment = new  DetallesNota();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public DetallesNota() {
        // Required empty public constructor
    }



    @Override
    public void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle= getArguments();
        bn=bundle;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vm = new ViewModelProvider(this).get(DetallesFragmentViewModel.class);
        vm.recibirBundle(bn);
        binding = FragmentDetallesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm.recibirBundle(bn);
        vm.getMNota().observe(getActivity(), new Observer<Nota>() {
            @Override
            public void onChanged(Nota nota) {
                Nota mNota= nota;
                binding.tvDetalleDetalle.setText("Detalles: " + mNota.getDetalle()+"");
                binding.tvDetalleMateria.setText("Materia: " + mNota.getMateria()+"");
                binding.tvdetalleNota.setText("Nota: "+ mNota.getMateria()+"");
                binding.tvDetalleNombre.setText("Nombre del Alumno: "+ mNota.getAlummno()+"");
            }
        });
        vm.getMen().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvDetalleNombre.setText("mensaje: "+ s);
            }
        });
        vm.recibirBundle(bn);
        return inflater.inflate(R.layout.fragment_detalles_nota, container, false);
    }
}