package com.joina.joinaonline.Tenants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.joina.joinaonline.Tenants.GuestUser.TenantsGuestApplicationFormActivity;
import com.joina.joinaonline.Tenants.PropertyManager.PropertyManagerDashboardActivity;
import com.joina.joinaonline.Tenants.GuestUser.TenantsGuestApplicationFormActivity;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.MainActivity;
import com.joina.joinaonline.R;
import com.joina.joinaonline.Tenants.PropertyManager.PropertyManagerDashboardActivity;
import com.joina.joinaonline.Tenants.TenantInterface.TenantDashboardActivity;


public class TenantAuthActivity extends AppCompatActivity {
    MaterialButton guestUsers,tenants, admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_auth);
        guestUsers=findViewById(R.id.guestUsers);
        tenants=findViewById(R.id.tenants);
        admin = findViewById(R.id.admin);

        guestUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TenantAuthActivity.this, TenantsGuestApplicationFormActivity.class);
                startActivity(intent);
            }
        });

        tenants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TenantAuthActivity.this, TenantDashboardActivity.class);
                startActivity(intent);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TenantAuthActivity.this, PropertyManagerDashboardActivity.class);
                startActivity(intent);
            }
        });
    }
    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}





