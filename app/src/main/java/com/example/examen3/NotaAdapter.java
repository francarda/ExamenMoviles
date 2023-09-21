package com.example.examen3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder>{
    private List<Nota> notas;
    private Context context;
    private LayoutInflater li;

    public NotaAdapter(List<Nota> notas, Context context, LayoutInflater li) {
        this.notas = notas;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= li.inflate(R.layout.item_nota, parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.alumno.setText("Alumno: " + notas.get(position).getAlummno());
    holder.nota.setText("Nota: "+ notas.get(position).getNota());
    holder.materia.setText("Materia: " + notas.get(position).getMateria());
    holder.notaCompleta=notas.get(position);


    }

    @Override
    public int getItemCount() {

        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView alumno;
        private TextView materia;
        private TextView nota;
        private Nota notaCompleta= new Nota("","","","");

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            alumno=itemView.findViewById(R.id.tvAlumno);
            materia=itemView.findViewById(R.id.tvMateria);
            nota= itemView.findViewById(R.id.tvNota);

           itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle= new Bundle();
                    notaCompleta= new Nota("10","Mate","alguien","detalle");
                    bundle.putSerializable("Nota", notaCompleta);

                    Navigation.findNavController(view).navigate(R.id.detallesNota, bundle);


                }
            });

        }
    }
}
