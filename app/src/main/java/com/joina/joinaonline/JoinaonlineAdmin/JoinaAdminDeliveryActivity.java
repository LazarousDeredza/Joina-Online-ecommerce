package com.joina.joinaonline.JoinaonlineAdmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.R;

public class JoinaAdminDeliveryActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_and_delivery);

//        toolbar=findViewById(R.id.toolbar);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(JoinaAdminDeliveryActivity.this, JoinaAdminMainActivity.class);
//                startActivity(intent);
//            }
//        });

        MaterialButton shipping_modes = findViewById(R.id.shipping_modes);
        shipping_modes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinaAdminDeliveryActivity.this, ShippingModesActivity.class);
                startActivity(intent);
            }
        });

        MaterialButton shipping_timings = findViewById(R.id.shipping_timeline);
        shipping_timings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinaAdminDeliveryActivity.this, ShippingTimelineActivity.class);
                startActivity(intent);
            }
        });

        MaterialButton delivery_charges = findViewById(R.id.delivery_charges);
        delivery_charges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinaAdminDeliveryActivity.this, DeliveryChargesActivity.class);
                startActivity(intent);
            }
        });

    }
}