package com.jozamo74.herramientas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ComunicaMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void menu(int queboton){

        Intent intent = new Intent(this,ActividadHerramientas.class);
        intent.putExtra("BOTONPULSADO", queboton);

        startActivity(intent);
    }



}
