package com.joina.joinaonline.JoinaonlineAdmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.joina.joinaonline.R;

public class ShippingTimelineActivity extends AppCompatActivity {

    Spinner spinner1,spinner2;
    String[] timeframe = {"Minutes","Hours","Days","Weeks"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_timeline);

        spinner1 = findViewById(R.id.timeframe_spinner);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,timeframe);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),timeframe[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2 = findViewById(R.id.timeframe_spinner1);

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,timeframe);
        arrayAdapter2.setDropDownViewResource(pub.devrel.easypermissions.R.layout.support_simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),timeframe[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}