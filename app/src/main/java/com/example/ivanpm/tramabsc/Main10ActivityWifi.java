package com.example.ivanpm.tramabsc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Main10ActivityWifi extends AppCompatActivity implements View.OnClickListener {
    private EditText a,b,c,d,e,f,g,h,i;
    Button trama;
    TextView res;
    String CRC, Duracion , MAC1, MAC2, MAC3, Secuencia, MAC4, DAT,Control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10_wifi);
        a = (EditText) findViewById(R.id.ETDuracion);
        b = (EditText) findViewById(R.id.ETMac1);
        c = (EditText) findViewById(R.id.ETMac2);
        d = (EditText) findViewById(R.id.ETMac3);
        e = (EditText) findViewById(R.id.ETSecuencia);
        f = (EditText) findViewById(R.id.ETMac4);
        g = (EditText) findViewById(R.id.ETDatos);
        h = (EditText) findViewById(R.id.ETCrc);
        i = (EditText) findViewById(R.id.ETControl);

        res =(TextView)findViewById(R.id.t1);
        trama = (Button) findViewById(R.id.button);
        trama.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        if (a.getText().toString().isEmpty() || b.getText().toString().isEmpty()
                || c.getText().toString().isEmpty() || d.getText().toString().isEmpty()
                || e.getText().toString().isEmpty() || f.getText().toString().isEmpty()
                || g.getText().toString().isEmpty() || h.getText().toString().isEmpty()
                || i.getText().toString().isEmpty()){//Condicion por si las casillas estan vacias
            res.setText("Ingrese valores");

        }else {
            res.setText("Generando Trama");
            Proceso();
            //Limpiar();
        }
    }

    public void Proceso(){
        //Texto de editText a string
        Control = i.getText().toString();
        Duracion = a.getText().toString();
        MAC1 = b.getText().toString();
        MAC2 = c.getText().toString();
        MAC3 = d.getText().toString();
        Secuencia = e.getText().toString();
        MAC4 = f.getText().toString();
        DAT = g.getText().toString();
        CRC = h.getText().toString();
        //Parseo a base dos el numero binario (CRC, DURACION Y SECUENCIA)
        long cc = Long.parseLong(CRC,2);
        //int cc = Integer.parseInt(SYN, 2);
        int con = Integer.parseInt(Control, 2);
        int dura = Integer.parseInt(Duracion, 2);
        int secuen = Integer.parseInt(Secuencia, 2);



        //Método para el campo de texto pasar de string a hexadecimal
        String arrS[];
        int tamaño = DAT.length();
        arrS = new String[tamaño];

        for(int i=0;i<DAT.length();i++){
            int tm = DAT.codePointAt(i);
            String HX = Integer.toHexString(tm);
            arrS[i] = HX;
        }
        String datosArray = "";
        for (String elemento: arrS) {
            datosArray += elemento + "";
        }
        DAT = datosArray;
        //Con el método toHextring pasamos el entero a base hexadecimal con salida string

        CRC = Long.toHexString(cc);
        Duracion = Integer.toHexString(dura);
        Secuencia = Integer.toHexString(secuen);
        Control = Integer.toHexString(con);
        //Entre la linea intent y start mandamos las variables para retomarlas en la otra activity con putExtra
        Intent intecincosubuno = new Intent(Main10ActivityWifi.this,Main11ActivityWifiCarousel.class);
        intecincosubuno.putExtra("Con2",Control);
        intecincosubuno.putExtra("DURA2",Duracion);
        intecincosubuno.putExtra("M1",MAC1);
        intecincosubuno.putExtra("M2",MAC2);
        intecincosubuno.putExtra("M3",MAC3);
        intecincosubuno.putExtra("SEC",Secuencia);
        intecincosubuno.putExtra("M4",MAC4);
        intecincosubuno.putExtra("DAT2",DAT);
        intecincosubuno.putExtra("CRC2",CRC);
        startActivity(intecincosubuno);

    }
}
