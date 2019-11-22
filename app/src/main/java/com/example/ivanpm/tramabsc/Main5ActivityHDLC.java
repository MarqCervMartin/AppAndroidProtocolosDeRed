package com.example.ivanpm.tramabsc;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class Main5ActivityHDLC extends Activity {
    TextView FL,DI,CO,IN,CRRC,FLD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5_hdlc);
        RecibeImprime();
    }
    private void RecibeImprime(){
        Bundle extras = getIntent().getExtras();
        String CRC = extras.getString("CRC2");
        String Direccion = extras.getString("Direccion2");
        String Control = extras.getString("Control2");
        String Informacion = extras.getString("Informacion2");
        CRRC = (TextView) findViewById(R.id.cr);
        CRRC.setText(CRC);
        DI = (TextView) findViewById(R.id.d);
        DI.setText(Direccion);
        CO = (TextView) findViewById(R.id.c);
        CO.setText(Control);
        IN = (TextView) findViewById(R.id.in);
        IN.setText(Informacion);
        String Flag = "7e",FlagD = "7e";
        FLD = (TextView) findViewById(R.id.fd);
        FLD.setText(FlagD);
        FL = (TextView) findViewById(R.id.f);
        FL.setText(Flag);


    }
}
