package com.example.ivanpm.tramabsc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private EditText a,b,c,d,e,f,g;
    Button trama;
    TextView res;
    String CRC, SYN , SOH, CAB , STX, ETX, DAT;
    //int cc,sn,sh,cb,sx,ex;
    //int cifra,resultado=0,exp=0;
    //byte by;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a = (EditText) findViewById(R.id.e1);
        b = (EditText) findViewById(R.id.e2);
        c = (EditText) findViewById(R.id.e3);
        d = (EditText) findViewById(R.id.e4);
        e = (EditText) findViewById(R.id.e5);
        f = (EditText) findViewById(R.id.e6);
        g = (EditText) findViewById(R.id.e7);
        res =(TextView)findViewById(R.id.t1);
        trama = (Button) findViewById(R.id.b2);
        trama.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        if (a.getText().toString().isEmpty() || b.getText().toString().isEmpty()
                || c.getText().toString().isEmpty() || d.getText().toString().isEmpty()
                || e.getText().toString().isEmpty() || f.getText().toString().isEmpty()
                || g.getText().toString().isEmpty()
                ){//Condicion por si las casillas estan vacias
            res.setText("Ingrese valores");
        }else {
                res.setText("Generando Trama");
                Proceso();
                //Limpiar();
        }

    }
    public void Proceso(){
        //Texto de editText a string
        CRC = a.getText().toString();
        SYN = b.getText().toString();
        SOH = c.getText().toString();
        CAB = d.getText().toString();
        STX = e.getText().toString();
        ETX = f.getText().toString();
        DAT = g.getText().toString();
        //Parseo a base dos el numero binario
        long cc = Long.parseLong(CRC,2);
        //int cc = Integer.parseInt(SYN, 2);
        int sn = Integer.parseInt(SYN, 2);
        int sh = Integer.parseInt(SOH, 2);
        int cb = Integer.parseInt(CAB, 2);
        int sx = Integer.parseInt(STX, 2);
        int ex = Integer.parseInt(ETX, 2);


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
        DAT = Arrays.toString(arrS);
        //Con el método toHextring pasamos el entero a base hexadecimal con salida string
        CRC = Long.toHexString(cc);
        SYN = Integer.toHexString(sn);
        SOH = Integer.toHexString(sh);
        CAB = Integer.toHexString(cb);
        STX = Integer.toHexString(sx);
        ETX = Integer.toHexString(ex);

        //ETX = Integer.toHexString(Conversion(ex));


        //Entre la linea intent y start mandamos las variables para retomarlas en la otra activity con putExtra
        Intent inteunosubuno = new Intent(Main2Activity.this,Main3Activity.class);
        inteunosubuno.putExtra("CRC2",CRC);
        inteunosubuno.putExtra("SYN2",SYN);
        inteunosubuno.putExtra("SOH2",SOH);
        inteunosubuno.putExtra("CAB2",CAB);
        inteunosubuno.putExtra("STX2",STX);
        inteunosubuno.putExtra("ETX2",ETX);
        inteunosubuno.putExtra("DAT2",DAT);
        startActivity(inteunosubuno);

    }
    public void Limpiar(){
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        e.setText("");
        f.setText("");
        g.setText("");
    }/*
    public int Conversion( int CadenaBin){
        do{
            cifra = CadenaBin%10;
            resultado = resultado + cifra*(int)Math.pow(2,exp);
            exp++;
            CadenaBin = CadenaBin/10;
        }while(CadenaBin > 0);
        return resultado;
    }*/
}
