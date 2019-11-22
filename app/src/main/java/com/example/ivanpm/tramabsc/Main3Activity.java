package com.example.ivanpm.tramabsc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView CR,SY,SO,CA,ST,ET,DA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        RecibeImprime();
    }

    private void RecibeImprime(){
        Bundle extras = getIntent().getExtras();
        String CRC = extras.getString("CRC2");
        String SYN = extras.getString("SYN2");
        String SOH = extras.getString("SOH2");
        String CAB = extras.getString("CAB2");
        String STX = extras.getString("STX2");
        String ETX = extras.getString("ETX2");
        String DAT = extras.getString("DAT2");
        CR = (TextView) findViewById(R.id.CR);
        CR.setText(CRC);
        SY = (TextView) findViewById(R.id.SY);
        SY.setText(SYN);
        SO = (TextView) findViewById(R.id.SO);
        SO.setText(SOH);
        CA = (TextView) findViewById(R.id.CA);
        CA.setText(CAB);
        ST = (TextView) findViewById(R.id.ST);
        ST.setText(STX);
        ET = (TextView) findViewById(R.id.ET);
        ET.setText(ETX);
        DA = (TextView) findViewById(R.id.DA);
        DA.setText(DAT);
    }
}
