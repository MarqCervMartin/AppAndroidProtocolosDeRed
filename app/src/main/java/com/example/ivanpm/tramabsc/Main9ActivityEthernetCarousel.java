package com.example.ivanpm.tramabsc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class Main9ActivityEthernetCarousel extends AppCompatActivity {

    CarouselPicker carrusel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9_ethernet_carousel);
        RecibeImprime();
    }
    private void RecibeImprime(){
        Bundle extras = getIntent().getExtras();
        String CRC = extras.getString("CRC2");
        String DES = extras.getString("DES2");
        String ORG = extras.getString("ORG2");
        String TIP = extras.getString("TIP2");
        String DAT = extras.getString("DAT2");

        carrusel = (CarouselPicker)findViewById(R.id.CarouselPicker);
        List<CarouselPicker.PickerItem>texto = new ArrayList<>();
        texto.add(new CarouselPicker.TextItem("Preambulo\nAAAAAAAAAAAAAA",15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("FSC\nAB",15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("Destino\n"+DES,15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("Origen\n"+ORG,15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("Longitud\n"+TIP,15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("Dato\n"+DAT,15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("CRC\n"+CRC,15));
        CarouselPicker.CarouselViewAdapter textAdapter = new CarouselPicker.CarouselViewAdapter(this, texto, 0);
        carrusel.setAdapter(textAdapter);
    }
}
