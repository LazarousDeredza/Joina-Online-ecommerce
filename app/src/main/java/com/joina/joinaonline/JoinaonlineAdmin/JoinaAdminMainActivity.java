package com.joina.joinaonline.JoinaonlineAdmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.JoinaonlineAdmin.CategoryRequests.JoinaAdminCategoryRequestsActivity;
import com.joina.joinaonline.JoinaonlineAdmin.Vendors.AddVendorsActivity;
import com.joina.joinaonline.R;

public class JoinaAdminMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joina_admin_main);

        MaterialButton category_requests = findViewById(R.id.category_requests_button);
        category_requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(JoinaAdminMainActivity.this, JoinaAdminCategoryRequestsActivity.class);
                startActivity(intent);
            }
        });

        MaterialButton rates_management = findViewById(R.id.manage_rates_button);
        rates_management.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinaAdminMainActivity.this, JoinaAdminRatesManagementActivity.class);
                startActivity(intent);
            }
        });

        MaterialButton shipping_management = findViewById(R.id.manage_shipping_button);
        shipping_management.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(JoinaAdminMainActivity.this, JoinaAdminDeliveryActivity.class);
                startActivity(intent);
            }
        });

        MaterialButton add_vendors = findViewById(R.id.addVendors_button);
        add_vendors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(JoinaAdminMainActivity.this, AddVendorsActivity.class);
                startActivity(intent);
            }
        });

        MaterialButton profiles_management = findViewById(R.id.manage_profiles_button);
        profiles_management.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(JoinaAdminMainActivity.this, JoinaAdminProfileManagementActivity.class);
                startActivity(intent);
            }
        });
    };
}