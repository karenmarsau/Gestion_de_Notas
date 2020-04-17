package com.example.gestiondenotas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;

public class MostrarAlumnos extends AppCompatActivity {

    String[] nombresArray;
    int[] nota1Array;
    int[] nota2Array;
    int[] nota3Array;
    int contador;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_alumnos);
        Intent intent = getIntent();
        nombresArray = intent.getStringArrayExtra("nombresArray");
        nota1Array = intent.getIntArrayExtra("nota1Array");
        nota2Array = intent.getIntArrayExtra("nota2Array");
        nota3Array = intent.getIntArrayExtra("nota3Array");
        contador = intent.getIntExtra("contador", 0);

        final Button btnOrderNombre = findViewById(R.id.btnAlumnos);
        btnOrderNombre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Arrays.sort(nombresArray);
            }
        });

        final Button btnModificarDatos = findViewById(R.id.btnModificar);
        btnModificarDatos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToModificar();
            }
        });

        recyclerView = findViewById(R.id.recyclerNotas);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, nombresArray, nota1Array, nota2Array, nota3Array, contador);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));

    }
    private void goToModificar(){

        Intent intentModificar = new Intent(this, ModificarDatos.class);
        intentModificar.putExtra("nombresArray", nombresArray);
        intentModificar.putExtra("contador", contador);
        intentModificar.putExtra("nota1Array",nota1Array);
        intentModificar.putExtra("nota2Array",nota2Array);
        intentModificar.putExtra("nota3Array",nota3Array);

        startActivityForResult(intentModificar, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode == RESULT_OK){
                nombresArray = data.getStringArrayExtra("nombresArray");
                nota1Array = data.getIntArrayExtra("nota1Array");
                nota2Array = data.getIntArrayExtra("nota2Array");
                nota3Array = data.getIntArrayExtra("nota3Array");
                contador = data.getIntExtra("contador", 0);


                RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, nombresArray, nota1Array, nota2Array, nota3Array, contador);
                recyclerView.setAdapter(adapter);
            }
        }
    }

    @Override
    public void onBackPressed() {

        Intent returnIntent = new Intent();
        returnIntent.putExtra("nombresArray", nombresArray);
        returnIntent.putExtra("nota1Array", nota1Array);
        returnIntent.putExtra("nota2Array", nota2Array);
        returnIntent.putExtra("nota3Array", nota3Array);
        returnIntent.putExtra("contador", contador);

        setResult(RESULT_OK, returnIntent);
        finish();

    }

}
