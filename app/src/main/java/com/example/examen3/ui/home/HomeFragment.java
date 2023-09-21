package com.example.examen3.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen3.Nota;
import com.example.examen3.NotaAdapter;
import com.example.examen3.R;
import com.example.examen3.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel vm;

    private RecyclerView rv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm= new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vm.getListaNotas().observe(getViewLifecycleOwner(), new Observer<List<Nota>>() {
            @Override
            public void onChanged(List<Nota> notas) {
                rv= getActivity().findViewById(R.id.rvNotas);
                GridLayoutManager gl= new GridLayoutManager(getActivity(),notas.size(),GridLayoutManager.HORIZONTAL,false);
                rv.setLayoutManager(gl);
                NotaAdapter na= new NotaAdapter(notas,getActivity(),getLayoutInflater());
                rv.setAdapter(na);
            }

        });
        vm.cagarLista();
        return root;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        vm.cagarLista();
    }

    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        vm.cagarLista();
    }

    @Override
    public void onStart() {
        super.onStart();
        vm.cagarLista();
    }

    @Override
    public void onResume() {
        super.onResume();
        vm.cagarLista();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}