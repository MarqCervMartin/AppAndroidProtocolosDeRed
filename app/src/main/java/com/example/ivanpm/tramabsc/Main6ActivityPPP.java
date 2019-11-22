package com.example.ivanpm.tramabsc;

import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class Main6ActivityPPP extends AppCompatActivity implements View.OnClickListener{
    private EditText a,b;
    private TextView res;
    Button tramappp;
    private Spinner spinneruno;
    String DAT2, CRC2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6_ppp);

        spinneruno = (Spinner)findViewById(R.id.spinner1);

        String [] Opciones = {"Reservado", "Internet Protocol", "OSI Network Layer", "Xerox NS IDP", "DECnet Phase IV",
                "Appletalk", "Novell IPX", "Luxcom", "Sigma Network System", "Internet Protocol Control Protocol",
                "OSI Network Layer Control Protocol", "Xerox NS IDP Control Protocol",
                "DECnet Phase IV Control Protocol", "Appletalk Control Protocol", "Novell IPX Control Protocol",
                "Link Control Protocol", "Password Authentication Protocol (PAP)", "Challenge Handshake Authentication Protocol (CHAP)"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Opciones);
        spinneruno.setAdapter(adapter);

        a = (EditText) findViewById(R.id.ETC);
        b = (EditText) findViewById(R.id.ETT);
        res =(TextView)findViewById(R.id.t1);
        tramappp = (Button) findViewById(R.id.btnG);
        //tramappp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (a.getText().toString().isEmpty() || b.getText().toString().isEmpty()){//Condicion por si las casillas estan vacias
            res.setText("Ingrese valores");
        }else {
            res.setText("Generando Trama");
            Proceso();
        }

    }
    public void Proceso(){
        String seleccion = spinneruno.getSelectedItem().toString();
        //String Protocolo = Opcion(seleccion);

        CRC2 = a.getText().toString();
        DAT2 = b.getText().toString();
        long cc = Long.parseLong(CRC2,2);

        String arrS[];
        int tamaño = DAT2.length();
        arrS = new String[tamaño];

        for(int i=0;i<DAT2.length();i++){
            //by = (byte)DAT.charAt(i);
            //arr[i] = String.format("%h",by);
            int tm = DAT2.codePointAt(i);
            String HX = Integer.toHexString(tm);
            arrS[i] = HX;
        }
        DAT2 = Arrays.toString(arrS);
        CRC2 = Long.toHexString(cc);

        Intent intetressubuno = new Intent(Main6ActivityPPP.this,Main7ActivityPPP.class);
        intetressubuno.putExtra("CRC22",CRC2);
        intetressubuno.putExtra("DAT22",DAT2);
        intetressubuno.putExtra("Protoccolo",Opcion(seleccion));

        startActivity(intetressubuno);

    }

    public String Opcion(String selec){
        switch (selec){
            case "Reservado":
                return "0001-001F ";
                //break;
            case "Internet Protocol":
                return "0021";
                //break;
            case "OSI Network Layer":
                return "0023";
            //break;
            case "Xerox NS IDP":
                return "0025";
            //break;
            case "DECnet Phase IV":
                return "0027";
            //break;
            case "Appletalk":
                return "0029";
            //break;
            case "Novell IPX":
                return "002B";
            //break;
            case "Luxcom":
                return "0231";
            //break;
            case "Sigma Network System":
                return "0233";
            //break;
            case "Internet Protocol Control Protocol":
                return "8021";
            //break;
            case "OSI Network Layer Control Protocol":
                return "8023";
            //break;
            case "Xerox NS IDP Control Protocol":
                return "8025";
            //break;
            case "DECnet Phase IV Control Protocol":
                return "8027";
            //break;
            case "Appletalk Control Protocol":
                return "8029";
            //break;
            case "Novell IPX Control Protocol":
                return "802B";
            //break;
            case "Link Control Protocol":
                return "C021";
            //break;
            case "Password Authentication Protocol (PAP)":
                return "C023";
            //break;
            case "Challenge Handshake Authentication Protocol (CHAP)":
                return "C223";
            //break;
            default:
                return "";
              //  break;
        }
    }

}
