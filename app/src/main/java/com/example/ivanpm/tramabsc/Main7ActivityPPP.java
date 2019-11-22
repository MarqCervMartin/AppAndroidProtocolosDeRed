package com.example.ivanpm.tramabsc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main7ActivityPPP extends AppCompatActivity {
    TextView band1,dire,con,proto,tex,crc,band2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7_ppp);
        RecibeImprime();
    }
    private void RecibeImprime(){
        Bundle extras = getIntent().getExtras();
        String CRC = extras.getString("CRC22");
        String DAT = extras.getString("DAT22");
        String P = extras.getString("Protoccolo");

        String banderas="7E",control="03",direccion="FF" ;

        crc = (TextView) findViewById(R.id.cr);
        crc.setText(CRC);
        band1 = (TextView) findViewById(R.id.b1);
        band1.setText(banderas);
        dire = (TextView) findViewById(R.id.direc);
        dire.setText(direccion);
        con = (TextView) findViewById(R.id.cntl);
        con.setText(control);
        proto = (TextView) findViewById(R.id.prot);
        proto.setText(P);
        band2 = (TextView) findViewById(R.id.b2);
        band2.setText(banderas);
        tex = (TextView) findViewById(R.id.tex);
        tex.setText(DAT);
    }
}
