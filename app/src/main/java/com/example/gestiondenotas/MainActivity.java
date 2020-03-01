package com.example.gestiondenotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int maxNotas=50;

    String[] nombresArray= new String [maxNotas];
    int[] nota1Array = new int[maxNotas];
    int[] nota2Array = new int[maxNotas];
    int[] nota3Array = new int[maxNotas];

    int contador=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton imageButtonAnadir = findViewById(R.id.imageButtonAnadir);
        imageButtonAnadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToAnadirAlumno();
            }
        });

        final ImageButton imageButtonMostrar= findViewById(R.id.imageButtonMostrar);
        imageButtonMostrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToMostrarAlumno();
            }
        });

        final ImageButton imageButtonAprueba = findViewById(R.id.imageButtonAprueba);
        imageButtonAprueba.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToApruebaTodos();
            }
        });

        final ImageButton imageButtonAyuda = findViewById(R.id.imageButtonAyuda);
        imageButtonAyuda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToAyuda();
            }
        });
    }


    private void goToAnadirAlumno(){

        Intent intentAnadir = new Intent(this,AnadirAlumno.class);
        intentAnadir.putExtra("nombresArray", nombresArray);
        intentAnadir.putExtra("contador", contador);
        intentAnadir.putExtra("nota1Array",nota1Array);
        intentAnadir.putExtra("nota2Array",nota2Array);
        intentAnadir.putExtra("nota3Array",nota3Array);


        startActivityForResult(intentAnadir, 1);

    }

    private void goToMostrarAlumno(){

        Intent intentMostrar = new Intent(this,MostrarAlumnos.class);
        intentMostrar.putExtra("nombresArray", nombresArray);
        intentMostrar.putExtra("contador", contador);
        intentMostrar.putExtra("nota1Array",nota1Array);
        intentMostrar.putExtra("nota2Array",nota2Array);
        intentMostrar.putExtra("nota3Array",nota3Array);


        startActivityForResult(intentMostrar, 1);

    }

    private void goToApruebaTodos(){
        Intent intentAprueba = new Intent(this, ApruebaTodos.class);
        intentAprueba.putExtra("nombresArray", nombresArray);
        intentAprueba.putExtra("contador", contador);
        intentAprueba.putExtra("nota1Array",nota1Array);
        intentAprueba.putExtra("nota2Array",nota2Array);
        intentAprueba.putExtra("nota3Array",nota3Array);

        startActivity(intentAprueba);
    }

    private void goToAyuda(){
        Intent intentAyuda = new Intent(this, Ayuda.class);
        intentAyuda.putExtra("nombresArray", nombresArray);
        intentAyuda.putExtra("contador", contador);
        intentAyuda.putExtra("nota1Array",nota1Array);
        intentAyuda.putExtra("nota2Array",nota2Array);
        intentAyuda.putExtra("nota3Array",nota3Array);


        startActivityForResult(intentAyuda, 1);

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

                //TextView textNombre = findViewById(R.id.textView2);
                //textNombre.setText(nombresArray[0] + "---" + Integer.toString(contador));
            }
        }
    }



}
