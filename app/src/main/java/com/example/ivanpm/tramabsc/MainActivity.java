package com.example.ivanpm.tramabsc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button hdlc;
    Button uno;
    Button ppp;
    Button ethernet;
    Button wifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uno =(Button)findViewById(R.id.b1);
        uno.setOnClickListener(new View.OnClickListener() { //Evento del botón
            @Override
            public void onClick(View v) {//Método para cuando de click
                Intent inteuno = new Intent(MainActivity.this, Main2Activity.class);//Manda a la actividad Serie
                startActivity(inteuno);//Inicia la actividad
            }

        });

        hdlc = (Button)findViewById(R.id.b2);
        hdlc.setOnClickListener(new View.OnClickListener() { //Evento del botón
            @Override
            public void onClick(View v) {//Método para cuando de click
                Intent intedos = new Intent(MainActivity.this, Main4ActivityHDLC.class);//Manda a la actividad Serie
                startActivity(intedos);//Inicia la actividad
            }

        });
        //Boton para saltar a la activity del protocolo PPP
        ppp = (Button)findViewById(R.id.b3);
        ppp.setOnClickListener(new View.OnClickListener() { //Evento del botón
            @Override
            public void onClick(View v) {//Método para cuando de click
                Intent intetres = new Intent(MainActivity.this, Main6ActivityPPP.class);//Manda a la actividad Serie
                startActivity(intetres);//Inicia la actividad
            }

        });

        ethernet =(Button)findViewById(R.id.b4);
        ethernet.setOnClickListener(new View.OnClickListener() { //Evento del botón
            @Override
            public void onClick(View v) {//Método para cuando de click
                Intent intecuatro = new Intent(MainActivity.this, Main8ActivityEthernet.class);//Manda a la actividad Serie
                startActivity(intecuatro);//Inicia la actividad
            }

        });

        wifi =(Button)findViewById(R.id.b5);
        wifi.setOnClickListener(new View.OnClickListener() { //Evento del botón
            @Override
            public void onClick(View v) {//Método para cuando de click
                Intent intecinco = new Intent(MainActivity.this, Main10ActivityWifi.class);//Manda a la actividad Serie
                startActivity(intecinco);//Inicia la actividad
            }

        });


    }
}
