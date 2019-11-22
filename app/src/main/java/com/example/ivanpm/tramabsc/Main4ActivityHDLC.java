package com.example.ivanpm.tramabsc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;


public class Main4ActivityHDLC extends AppCompatActivity implements View.OnClickListener {
    private EditText b, c, d, e;
    TextView Generando;
    Button t;
    String Direccion,Control,Informacion,CRC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_hdlc);
        b = (EditText) findViewById(R.id.e2);
        c = (EditText) findViewById(R.id.e3);
        d = (EditText) findViewById(R.id.e4);
        e = (EditText) findViewById(R.id.e5);
        Generando = (TextView) findViewById(R.id.t2);
        t = (Button) findViewById(R.id.bt);
        t.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (b.getText().toString().isEmpty() || c.getText().toString().isEmpty() || d.getText().toString().isEmpty()
                || e.getText().toString().isEmpty() ) {//Condicion por si las casillas estan vacias
            Generando.setText("Ingrese valores");
        } else {
            Generando.setText("Generando Trama");
            Proceso();
            //Limpiar();
        }

    }

    public void Proceso() {
        Direccion = b.getText().toString();
        Control = c.getText().toString();
        Informacion = d.getText().toString();
        CRC = e.getText().toString();
        long cc = Long.parseLong(CRC,2);
        int direc = Integer.parseInt(Direccion, 2);
        int contr = Integer.parseInt(Control, 2);

        int tamaño = Informacion.length();
        String arrS[];
        arrS = new String[tamaño];

        for(int i=0;i<Informacion.length();i++){
            int tm = Informacion.codePointAt(i);
            String HX = Integer.toHexString(tm);
            arrS[i] = HX;
        }
        Informacion = Arrays.toString(arrS);

        CRC = Long.toHexString(cc);
        Direccion = Integer.toHexString(direc);
        Control = Integer.toHexString(contr);

        Intent intedossubdos = new Intent(Main4ActivityHDLC.this,Main5ActivityHDLC.class);
        intedossubdos.putExtra("CRC2",CRC);
        intedossubdos.putExtra("Direccion2",Direccion);
        intedossubdos.putExtra("Control2",Control);
        intedossubdos.putExtra("Informacion2",Informacion);
        startActivity(intedossubdos);
    }
}
