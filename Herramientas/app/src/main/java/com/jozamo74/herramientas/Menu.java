package com.jozamo74.herramientas;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {


    private final int[] BOTONESMENU = {R.id.linterna,R.id.muscia,R.id.nivel};
    private final int[] BOTONESILUMINADOS = {R.drawable.linterna2, R.drawable.musica2, R.drawable.nivel2};
    private int boton = -1; //Por defecto si no ponemos ningún valor es 0 y se ilumnia el boton primero del array

    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View miMenu =  inflater.inflate(R.layout.fragment_menu, container, false);

        if(getArguments() != null) boton = getArguments().getInt("BOTONPULSADO"); //La primera vez en cargar no se cumplirá

        ImageButton botonMenu;

        //Poner a la escucha los botones
        for(int i= 0; i < BOTONESMENU.length; i++){
            botonMenu = (ImageButton)miMenu.findViewById(BOTONESMENU[i]); //construye botón

            if(boton == i){
                botonMenu.setImageResource(BOTONESILUMINADOS[i]); //construye botón iluminado que se pulso
            }

            final int botonPulsado = i;

            botonMenu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View view){
                        Activity estaActividad = getActivity(); //optener la actividad en la que estamos al pulsar el botón
                        ((ComunicaMenu)estaActividad).menu(botonPulsado); //Casteo  pasar botón pulsado
                    }

            });
        }

        return  miMenu;
    }

}
