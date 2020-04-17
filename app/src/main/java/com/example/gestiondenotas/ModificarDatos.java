package com.example.gestiondenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModificarDatos extends AppCompatActivity {
    String[] nombresArray;
    int[] nota1Array;
    int[] nota2Array;
    int[] nota3Array;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_datos);

        Intent modificarDatos = getIntent();

        nombresArray = modificarDatos.getStringArrayExtra("nombresArray");
        nota1Array = modificarDatos.getIntArrayExtra("nota1Array");
        nota2Array = modificarDatos.getIntArrayExtra("nota2Array");
        nota3Array = modificarDatos.getIntArrayExtra("nota3Array");
        contador = modificarDatos.getIntExtra("contador", 0);

        final Button btnGuardar = findViewById(R.id.btnSave);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                String nombreAnt = "";
                String nombreNuevo = "";
                boolean encontrar = false;
                boolean validacion = true;

                EditText nombreAnterior = findViewById(R.id.edtNomAnt);
                if(!nombreAnterior.getText().toString().equals("")) {
                    nombreAnt = nombreAnterior.getText().toString();
                } else {
                    validacion = false;
                    Toast toast1 = Toast.makeText(getApplicationContext(),"ERROR, el nombre esta vacio.",Toast.LENGTH_SHORT);
                    toast1.setMargin(1000,500);
                    toast1.show();
                }

                EditText nombreNuevo_ = findViewById(R.id.edtNomNew);
                    if(!nombreNuevo_.getText().toString().equals("")) {
                        nombreNuevo = nombreNuevo_.getText().toString();
                    } else {
                        validacion = false;
                        Toast toast2 = Toast.makeText(getApplicationContext(),"ERROR, el nombre esta vacio.",Toast.LENGTH_SHORT);
                        toast2.setMargin(1000,500);
                        toast2.show();
                    }

                if(validacion == true) {
                    for (int i = 0; i < nombresArray.length; i++) {
                        if (nombreAnt.equals(nombresArray[i]) && !encontrar) {
                            encontrar = true;
                            nombresArray[i] = nombreNuevo;
                            Toast toastMod = Toast.makeText(getApplicationContext(), "Modificado con Exito", Toast.LENGTH_SHORT);
                            toastMod.setMargin(1000, 500);
                            toastMod.show();
                        }
                    }

                    if (!encontrar) {
                        Toast toast = Toast.makeText(getApplicationContext(), "ERROR, no existe.", Toast.LENGTH_SHORT);
                        toast.setMargin(1000, 500);
                        toast.show();
                    }
                }
            }
        });

        final Button btnGuardar2 = findViewById(R.id.btnSave2);
        btnGuardar2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            String nomAlumno="";
            int evaluacion = 0;
            int nota = 0;
            boolean encontrar = false;
            boolean validacion = true;

            EditText nombre = findViewById(R.id.edtNom);
            if(!nombre.getText().toString().equals("")) {
                nomAlumno = nombre.getText().toString();
            } else {
                validacion = false;
                Toast toast1 = Toast.makeText(getApplicationContext(),"ERROR, el nombre esta vacio.",Toast.LENGTH_SHORT);
                toast1.setMargin(1000,500);
                toast1.show();
            }

            EditText eval = findViewById(R.id.edtEval);
            if(!eval.getText().toString().equals("")){
                evaluacion = Integer.parseInt(eval.getText().toString());
            } else {
                validacion = false;
                Toast toastN1 = Toast.makeText(getApplicationContext(),"ERROR, la evaluación esta vacia.",Toast.LENGTH_SHORT);
                toastN1.setMargin(1000,500);
                toastN1.show();
            }

            EditText nota1 = findViewById(R.id.edtNota);
            if(!nota1.getText().toString().equals("")){
                nota = Integer.parseInt(nota1.getText().toString());
            } else {
                validacion = false;
                Toast toastN1 = Toast.makeText(getApplicationContext(),"ERROR, la nota esta vacia.",Toast.LENGTH_SHORT);
                toastN1.setMargin(1000,500);
                toastN1.show();
            }

            if(validacion == true) {

                if (nota < 0 || nota > 10) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "ERROR, la nota a actualizar es incorrecta", Toast.LENGTH_SHORT);
                    toast1.setMargin(1000, 500);
                    toast1.show();
                } else {
                    for (int i = 0; i < nombresArray.length; i++) {
                        if (nomAlumno.equals(nombresArray[i]) && !encontrar) {
                            encontrar = true;
                            if (evaluacion == 1){
                                nota1Array[i] = nota;
                            }else if(evaluacion == 2){
                                nota2Array[i] = nota;
                            }else if(evaluacion == 3){
                                nota3Array[i] = nota;
                            }

                            Toast toastMod = Toast.makeText(getApplicationContext(), "Modificado con Exito", Toast.LENGTH_SHORT);
                            toastMod.setMargin(1000, 500);
                            toastMod.show();
                        }
                    }

                    if (!encontrar) {
                        Toast toast = Toast.makeText(getApplicationContext(), "ERROR, no existe.", Toast.LENGTH_SHORT);
                        toast.setMargin(1000, 500);
                        toast.show();
                    }
                }
            }


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
