package com.example.gestiondenotas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


    String[] nombresArray;
    int[] nota1Array;
    int[] nota2Array;
    int[] nota3Array;
    Context context;
    float notaFinal;
    int contador;

    public RecyclerViewAdapter(Context con, String [] arrayNombres, int[] notaN1, int[] notaN2, int[] notaN3, int cont) {
        nombresArray = arrayNombres;
        nota1Array = notaN1;
        nota2Array = notaN2;
        nota3Array = notaN3;
        contador = cont;
        context = con;
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_alumnos_row, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.etiquetaNom.setText(nombresArray[position]);

        String nota1S = Integer.toString(nota1Array[position]);
        String nota2S = Integer.toString(nota2Array[position]);
        String nota3S = Integer.toString(nota3Array[position]);
        holder.etiquetaNota1.setText(nota1S);
        holder.etiquetaNota2.setText(nota2S);
        holder.etiquetaNota3.setText(nota3S);

        float nota1 = Float.parseFloat(nota1S);
        float nota2 = Float.parseFloat(nota2S);
        float nota3 = Float.parseFloat(nota3S);


        DecimalFormat df = new DecimalFormat("0.00");

        notaFinal = (nota1 + nota2 + nota3)/3;
        String notaFinalS = df.format(notaFinal);
        holder.etiquetaNotaFinal.setText(notaFinalS);


    }

    @Override
    public int getItemCount() {
        return contador;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView etiquetaNom;
        TextView etiquetaNota1;
        TextView etiquetaNota2;
        TextView etiquetaNota3;
        TextView etiquetaNotaFinal;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            etiquetaNom = itemView.findViewById(R.id.nameStudent);
            layout = itemView.findViewById(R.id.layout);
            
            etiquetaNota1 = itemView.findViewById(R.id.txtnote1);

            etiquetaNota2 = itemView.findViewById(R.id.txtnote2);

            etiquetaNota3 = itemView.findViewById(R.id.txtnote3);

            etiquetaNotaFinal = itemView.findViewById(R.id.txtFinal);
        }

    }

}
