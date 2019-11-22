package com.example.ivanpm.tramabsc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class Main8ActivityEthernet extends AppCompatActivity implements View.OnClickListener{
    private EditText a,b,d,e;
    Button trama;
    TextView res;
    String CRC, DES , ORG, LONGIT, DAT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8_ethernet);
        a = (EditText) findViewById(R.id.e1);
        b = (EditText) findViewById(R.id.e2);
        //c = (EditText) findViewById(R.id.e3);
        d = (EditText) findViewById(R.id.e4);
        e = (EditText) findViewById(R.id.e5);


        res =(TextView)findViewById(R.id.t1);
        trama = (Button) findViewById(R.id.btnG);
        trama.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        if (a.getText().toString().isEmpty() || b.getText().toString().isEmpty()
                || d.getText().toString().isEmpty() || e.getText().toString().isEmpty() ){//Condicion por si las casillas estan vacias
            res.setText("Ingrese valores");
        }else {
            res.setText("Generando Trama");
            Proceso();
            //Limpiar();
        }

    }
    public void Proceso(){
        //Texto de editText a string

        DES = a.getText().toString();
        ORG = b.getText().toString();
        //TIP = c.getText().toString();
        DAT = d.getText().toString();
        CRC = e.getText().toString();

        //Parseo a base dos el numero binario
        long cc = Long.parseLong(CRC,2);
        //int cc = Integer.parseInt(SYN, 2);
        //int de = Integer.parseInt(DES, 2);
        //int or = Integer.parseInt(ORG, 2);
        //int ti = Integer.parseInt(TIP, 2);

/*
        String arrS2[];
        int tamaño2 = DES.length();
        arrS2 = new String[tamaño2];

        for(int i=0;i<DES.length();i++){
            //by = (byte)DAT.charAt(i);
            //arr[i] = String.format("%h",by);
            int tm = DES.codePointAt(i);
            String HX = Integer.toHexString(tm);
            arrS2[i] = HX;
        }
        String datosArray2 = "";
        for (String elemento: arrS2) {
            datosArray2 += elemento + "";
        }

        DES = datosArray2;//Arrays.toString(arrS)*/

        //Método para el campo de texto pasar de string a hexadecimal
        String arrS[];
        int tamaño = DAT.length();
        arrS = new String[tamaño];

        for(int i=0;i<DAT.length();i++){
            //by = (byte)DAT.charAt(i);
            //arr[i] = String.format("%h",by);
            int tm = DAT.codePointAt(i);
            String HX = Integer.toHexString(tm);
            arrS[i] = HX;
        }
        String datosArray = "";
        for (String elemento: arrS) {
            datosArray += elemento + "";
        }

        DAT = datosArray;//Arrays.toString(arrS);
        //Con el método toHextring pasamos el entero a base hexadecimal con salida string
        CRC = Long.toHexString(cc);
        //DES = datosArray2;
        //ORG = Integer.toHexString(or);
        //TIP = Integer.toHexString(ti);
        LONGIT = Retorno(DAT,CRC,DES,ORG);
        DAT = Relleno(DAT);

        //Entre la linea intent y start mandamos las variables para retomarlas en la otra activity con putExtra
        //Main9ActivityEthernetCarousel
        //Intent intecuatrosubuno = new Intent(Main8ActivityEthernet.this,Main9ActivityEthernet.class);
        Intent intecuatrosubuno = new Intent(Main8ActivityEthernet.this,Main9ActivityEthernetCarousel.class);
        intecuatrosubuno.putExtra("CRC2",CRC);
        intecuatrosubuno.putExtra("DES2",DES);
        intecuatrosubuno.putExtra("ORG2",ORG);
        intecuatrosubuno.putExtra("TIP2",LONGIT);
        intecuatrosubuno.putExtra("DAT2",DAT);
        startActivity(intecuatrosubuno);

    }
    public String Retorno(String a, String b, String c, String d){
        int lengA = a.length();
        if(lengA%2!=0){
            lengA = lengA+1;
        }
        int lengB = b.length();
        if(lengB%2!=0){
            lengB = lengB+1;
        }
        int lengC = c.length();
        if(lengC%2!=0){
            lengC = lengC+1;
        }
        int lengD = d.length();
        if(lengD%2!=0){
            lengD = lengD+1;
        }
        int totalBytes = 0;
        lengA = lengA/2;
        lengB = lengB/2;
        lengC = lengC/2;
        lengD = lengD/2;
        totalBytes = lengA+lengB+lengC+lengD;
        String longitudRetorno = Integer.toHexString(totalBytes);
        return longitudRetorno;

    }
    String Basura = "00";
    public String Relleno(String datos){
        int lengDatos= datos.length();
        lengDatos = lengDatos/2;
        int rellenar = 0;
        if(lengDatos<47){
            rellenar = 56 - lengDatos;
            String arr[] = new String[rellenar];

            for(int i=0;i<rellenar;i++){
                arr[i] = Basura;
            }
/*
            for (String elemento: arr){
                elemento = Basura;
                elemento++;
            }*/
            String aux = Arrays.toString(arr);
            datos = datos+aux;
        }

        return datos;

    }
}
