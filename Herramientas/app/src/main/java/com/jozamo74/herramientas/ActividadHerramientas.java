package com.jozamo74.herramientas;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActividadHerramientas extends AppCompatActivity implements ComunicaMenu{

    Fragment [] misFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_herramientas);

        misFragmentos = new Fragment[3];

        misFragmentos[0] = new Linterna();
        misFragmentos[1] = new Musica();
        misFragmentos[2] = new Nivel();

        //info del botón pulsado
        Bundle extras = getIntent().getExtras(); //información del botón pulsado

        menu(extras.getInt("BOTONPULSADO"));


    }

    @Override
    public void menu(int botonPulsado) {

        FragmentManager miManejador = getFragmentManager();
        FragmentTransaction miTransaccion = miManejador.beginTransaction();

        //Creamos los fragment con los botones ilumninados
        Fragment menu_iluminado = new Menu();
        Bundle datos = new Bundle(); //para pasar el botón pulsado
        datos.putInt("BOTONPULSADO",botonPulsado);
        menu_iluminado.setArguments(datos); //pasamos dato del fragment que tiene que crear según botón pulsado
        miTransaccion.replace(R.id.menu,menu_iluminado);

        miTransaccion.replace(R.id.herramientas,misFragmentos[botonPulsado]);
        miTransaccion.commit();

    }
}
