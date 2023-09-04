package com.joina.joinaonline.JoinaonlineTenants.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.joina.joinaonline.JoinaonlineTenants.fragments.SettingsFragment;
import com.joina.joinaonline.R;

public class ShippingAndDeliveryActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_and_delivery);

        toolbar=findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShippingAndDeliveryActivity.this, SettingsFragment.class);
                startActivity(intent);
            }
        });
    }
}