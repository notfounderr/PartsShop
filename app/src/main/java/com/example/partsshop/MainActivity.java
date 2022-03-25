package com.example.partsshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int countqua = 0;
    Spinner spinner;
    ArrayList spin;
    ArrayAdapter spinadp;
    HashMap price;
    String itemprice;
    double priceitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spin = new ArrayList();
        spin.add("CPU");
        spin.add("GPU");
        spin.add("HDD");
        spin.add("SSD");
        spin.add("RAM");
        spin.add("Motherboard");
        spin.add("PSU");

        spinadp =  new ArrayAdapter(this, android.R.layout.simple_spinner_item, spin);
        spinadp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadp);

        price = new HashMap();
        price.put("CPU", 300.0);
        price.put("GPU", 998.0);
        price.put("HDD", 210.0);
        price.put("SSD", 300.0);
        price.put("RAM", 110.0);
        price.put("Motherboard", 140.0);
        price.put("PSU", 170.0);



    }

    public void increaseQuantity(View view) {
        TextView countText = findViewById(R.id.countText);
        countqua++;

        countText.setText(Integer.toString(countqua));
        TextView priceText = findViewById(R.id.priceText);
        priceText.setText("" + countqua * priceitem);
    }

    public void minQuantity(View view) {
        TextView countText = findViewById(R.id.countText);

        if (countqua != 0) {
            countqua--;
            countText.setText(Integer.toString(countqua));
        }else countqua = 0;
        TextView priceText = findViewById(R.id.priceText);
        priceText.setText("" + countqua * priceitem);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        itemprice = spinner.getSelectedItem().toString();
        priceitem = (double)price.get(itemprice);
        TextView priceText = findViewById(R.id.priceText);
        priceText.setText("" + countqua * priceitem);

        ImageView itemImageView = findViewById(R.id.cpu);

        if (itemprice.equals("CPU")) {
            itemImageView.setImageResource(R.drawable.intelproc);
        } else if (itemprice.equals("GPU")) {
            itemImageView.setImageResource(R.drawable.gpu);
        }else if (itemprice.equals("HDD")) {
            itemImageView.setImageResource(R.drawable.hdd);
        }else if (itemprice.equals("SSD")){
            itemImageView.setImageResource(R.drawable.ssd);
        }else if (itemprice.equals("RAM")){
            itemImageView.setImageResource(R.drawable.ram);
        }else if (itemprice.equals("Motherboard")){
            itemImageView.setImageResource(R.drawable.mothboard);
        }else if (itemprice.equals("PSU")){
            itemImageView.setImageResource(R.drawable.psu);
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}