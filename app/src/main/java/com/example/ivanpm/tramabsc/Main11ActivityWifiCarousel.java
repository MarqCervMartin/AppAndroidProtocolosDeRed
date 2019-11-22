package com.example.ivanpm.tramabsc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class Main11ActivityWifiCarousel extends AppCompatActivity {
    CarouselPicker carrusel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11_wifi_carousel);
        RecibeImprime();
    }
    private void RecibeImprime(){
        Bundle extras = getIntent().getExtras();
        String Control = extras.getString("Con2");
        String Duracion = extras.getString("DURA2");
        String MAC1 = extras.getString("M1");
        String MAC2 = extras.getString("M2");
        String MAC3 = extras.getString("M3");
        String Secuencia = extras.getString("SEC");
        String MAC4 = extras.getString("M4");
        String Datos = extras.getString("DAT2");
        String Crc = extras.getString("CRC2");

        carrusel = (CarouselPicker)findViewById(R.id.CarouselPicker);
        List<CarouselPicker.PickerItem> texto = new ArrayList<>();
        texto.add(new CarouselPicker.TextItem("\tControl de Trama\n"+Control.toUpperCase(),15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("\tDuración\n"+Duracion.toUpperCase(),15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("\tMAC 1\n"+MAC1,15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("\tMAC 2\n"+MAC2,15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("\tMAC 3\n"+MAC3,15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("\tSecuencia\n"+Secuencia.toUpperCase(),15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("\tMAC 4\n"+MAC4,15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("\tInformación\n"+Datos.toUpperCase(),15));
        texto.add(new CarouselPicker.TextItem("               ",15));
        texto.add(new CarouselPicker.TextItem("\tCRC\n"+Crc.toUpperCase(),15));
        CarouselPicker.CarouselViewAdapter textAdapter = new CarouselPicker.CarouselViewAdapter(this, texto, 0);
        carrusel.setAdapter(textAdapter);
    }
}
