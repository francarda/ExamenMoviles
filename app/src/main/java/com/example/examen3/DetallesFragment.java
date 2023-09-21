package com.example.examen3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.examen3.databinding.FragmentDetallesBinding;
import com.example.examen3.databinding.FragmentHomeBinding;
import com.example.examen3.ui.home.HomeViewModel;

import java.util.List;

class DetallesFragment extends Fragment {



    private DetallesFragmentViewModel vm;
    private FragmentDetallesBinding binding;

    public DetallesFragment(DetallesFragmentViewModel vm) {
        this.vm = vm;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(DetallesFragmentViewModel.class);

        binding = FragmentDetallesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
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



       return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle= getArguments();
        vm.recibirBundle(bundle);

    }

}
    /*public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detalles, container, false);
    }*/
