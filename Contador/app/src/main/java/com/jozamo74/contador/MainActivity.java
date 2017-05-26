package com.jozamo74.contador;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    public int contador;
    public TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado = (TextView)findViewById(R.id.textView1);
        contador = 0;

        textoResultado.setText(""+contador);

    }
    /*
    //Guarda información del contador
    public void onSaveInstanceState(Bundle estado){
        estado.putInt("cuenta",contador);
        super.onSaveInstanceState(estado);
    }

    //Recupera información del contador
    public void onRestoreInstanceState(Bundle estado){
        super.onRestoreInstanceState(estado);

        contador = estado.getInt("cuenta");
        textoResultado.setText(""+contador);
    }
    */

    public void incrementaContador(View view){

        contador++;
        textoResultado.setText("" + contador);
    }


    //Para guardar la información
    public void onPause(){
        super.onPause(); //Se llama a la clase padre de donde se hereda

        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this); //Creamos objeto
        SharedPreferences.Editor miEditor = datos.edit(); //lo hacemos editable
        miEditor.putInt("cuenta", contador); //Decimos q vamos a almacernar
        miEditor.apply(); //Transferimos información a almacenar
    }

    //Para recuperar la información
    public void onResume(){
        super.onResume();

        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this); //Creamos objeto
        contador = datos.getInt("cuenta",0); //Recuperamos el valor guardado con la clave cuenta y si no lo recupera por defecto sera cero
        textoResultado.setText(""+contador);
    }



    public void restaContador(View view){

        contador--;
        if (contador < 0){
            CheckBox negativos = (CheckBox) findViewById(R.id.checkBox);
            if(!negativos.isChecked()){
                contador = 0;
            }
        }
        textoResultado.setText("" + contador);
    }



    public void resetearContador(View view){

        EditText num_reset = (EditText)findViewById(R.id.n_reseteo);

        try{
            contador = Integer.parseInt(num_reset.getText().toString());
        }catch (Exception e){
            contador = 0;
        }

        num_reset.setText("");
        textoResultado.setText("" + contador);

        InputMethodManager miTeclado = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE); //almacenamos nuestro teclado
        miTeclado.hideSoftInputFromWindow(num_reset.getWindowToken(),0); //Oculto teclado

    }

    /*public void mostarResultado(){

        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText(contador+"");

    }*/
}
