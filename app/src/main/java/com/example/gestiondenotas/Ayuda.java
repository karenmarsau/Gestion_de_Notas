package com.example.gestiondenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ayuda extends AppCompatActivity {
    String[] nombresArray;
    int[] nota1Array;
    int[] nota2Array;
    int[] nota3Array;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        Intent modificarDatos = getIntent();

        nombresArray = modificarDatos.getStringArrayExtra("nombresArray");
        nota1Array = modificarDatos.getIntArrayExtra("nota1Array");
        nota2Array = modificarDatos.getIntArrayExtra("nota2Array");
        nota3Array = modificarDatos.getIntArrayExtra("nota3Array");
        contador = modificarDatos.getIntExtra("contador", 0);

        final Button btnVaciar = findViewById(R.id.btnSave);
        btnVaciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                for(int i=0; i<contador; i++){
                    nombresArray[i]="";
                    nota1Array[i]=0;
                    nota2Array[i]=0;
                    nota3Array[i]=0;
                }
                contador=0;

                Toast toast = Toast.makeText(getApplicationContext(), "Vaciado con Exito", Toast.LENGTH_SHORT);
                toast.setMargin(1000, 500);
                toast.show();
            }
        });
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
