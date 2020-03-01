package com.example.gestiondenotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class ApruebaTodos extends AppCompatActivity {
    String[] nombresArray;
    int[] nota1Array;
    int[] nota2Array;
    int[] nota3Array;
    int contador;
    int nuevanota=5;
    float notaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprueba_todos);

        Intent intent = getIntent();
        nombresArray = intent.getStringArrayExtra("nombresArray");
        nota1Array = intent.getIntArrayExtra("nota1Array");
        nota2Array = intent.getIntArrayExtra("nota2Array");
        nota3Array = intent.getIntArrayExtra("nota3Array");
        contador = intent.getIntExtra("contador", 0);

        for(int i=0; i<nota1Array.length; i++){
            if(nota1Array[i]<5) {
                nota1Array[i] = nuevanota;
            }
            if(nota2Array[i]<5){
                nota2Array[i] = nuevanota;
            }
            if(nota3Array[i]<5){
                nota3Array[i]=nuevanota;
            }
        }


        RecyclerView recyclerView = findViewById(R.id.recyclerNotas);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, nombresArray, nota1Array, nota2Array, nota3Array, contador);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
    }
}
