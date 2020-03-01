package com.example.gestiondenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AnadirAlumno extends AppCompatActivity {

    String[] nombresArray;
    int[] nota1Array;
    int[] nota2Array;
    int[] nota3Array;
    int contador;
    boolean validacion = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_alumno);

        Intent recogerDatos = getIntent();

        nombresArray = recogerDatos.getStringArrayExtra("nombresArray");
        contador = recogerDatos.getIntExtra("contador", 0);
        nota1Array = recogerDatos.getIntArrayExtra("nota1Array");
        nota2Array = recogerDatos.getIntArrayExtra("nota2Array");
        nota3Array = recogerDatos.getIntArrayExtra("nota3Array");


        final Button btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String nombreGuardar="";
                int notaUnoGuardar=0;
                int notaDosGuardar=0;
                int notaTresGuardar=0;

                EditText nombreAlumno = findViewById(R.id.edtNombreAlumno);
                if(!nombreAlumno.getText().toString().equals("")) {
                    nombreGuardar = nombreAlumno.getText().toString();
                } else {
                    validacion = false;
                    Toast toastNombre = Toast.makeText(getApplicationContext(),"ERROR, El nombre esta vacio.",Toast.LENGTH_SHORT);
                    toastNombre.setMargin(1000,500);
                    toastNombre.show();
                }

                EditText nota1 = findViewById(R.id.edtNota1);
                if(!nota1.getText().toString().equals("")){
                    notaUnoGuardar = Integer.parseInt(nota1.getText().toString());
                } else {
                    validacion = false;
                    Toast toastN1 = Toast.makeText(getApplicationContext(),"ERROR, la nota 1 esta vacia.",Toast.LENGTH_SHORT);
                    toastN1.setMargin(1000,500);
                    toastN1.show();
                }

                EditText nota2 = findViewById(R.id.edtNota2);
                if(!nota2.getText().toString().equals("")){
                    notaDosGuardar = Integer.parseInt(nota2.getText().toString());
                } else {
                    validacion = false;
                    Toast toastN2 = Toast.makeText(getApplicationContext(),"ERROR, la nota 2 esta vacia.",Toast.LENGTH_SHORT);
                    toastN2.setMargin(1000,500);
                    toastN2.show();
                }

                EditText nota3 = findViewById(R.id.edtNota3);
                if(!nota3.getText().toString().equals("")) {
                    notaTresGuardar = Integer.parseInt(nota3.getText().toString());
                } else {
                    validacion = false;
                    Toast toastN3 = Toast.makeText(getApplicationContext(),"ERROR, la nota 3 esta vacia.",Toast.LENGTH_SHORT);
                    toastN3.setMargin(1000,500);
                    toastN3.show();
                }

                if(validacion == true) {
                    if (notaUnoGuardar < 0 || notaUnoGuardar > 10) {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "ERROR, la nota 1 es incorrecta", Toast.LENGTH_SHORT);
                        toast1.setMargin(1000, 500);
                        toast1.show();
                    } else if (notaDosGuardar < 0 || notaDosGuardar > 10) {
                        Toast toast2 = Toast.makeText(getApplicationContext(), "ERROR, la nota 2 es incorrecta", Toast.LENGTH_SHORT);
                        toast2.setMargin(1000, 500);
                        toast2.show();
                    } else if (notaTresGuardar < 0 || notaTresGuardar > 10) {
                        Toast toast3 = Toast.makeText(getApplicationContext(), "ERROR, la nota 3 es incorrecta", Toast.LENGTH_SHORT);
                        toast3.setMargin(1000, 500);
                        toast3.show();
                    } else {
                        nombresArray[contador] = nombreGuardar;
                        nota1Array[contador] = notaUnoGuardar;
                        nota2Array[contador] = notaDosGuardar;
                        nota3Array[contador] = notaTresGuardar;

                        contador++;

                        Toast toast = Toast.makeText(getApplicationContext(), "Guardado con Exito", Toast.LENGTH_SHORT);
                        toast.setMargin(1000, 500);
                        toast.show();
                    }
                }
            }

        });
    }

        @Override
        public void onBackPressed(){

            Intent returnIntent = new Intent();
            returnIntent.putExtra("nombresArray", nombresArray);
            returnIntent.putExtra("nota1Array", nota1Array);
            returnIntent.putExtra("nota2Array", nota2Array);
            returnIntent.putExtra("nota3Array", nota3Array);
            returnIntent.putExtra("contador",contador);


            setResult(RESULT_OK, returnIntent);
            finish();

    }
}
