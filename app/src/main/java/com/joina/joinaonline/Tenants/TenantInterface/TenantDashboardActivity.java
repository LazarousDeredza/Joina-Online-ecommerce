package com.joina.joinaonline.Tenants.TenantInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.joina.joinaonline.R;
import com.joina.joinaonline.Tenants.TenantAuthActivity;

public class TenantDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_dashboard);


    }

    public void back(View view) {
        Intent intent= new Intent(this, TenantAuthActivity.class);
        startActivity(intent);
    }
    public void tenantpropertyInformation(View view) {
        Intent intent= new Intent(this, TenantPropertyInformationActivity.class);
        startActivity(intent);
    }
    public void tenantRental(View view) {
        Intent intent= new Intent(this, TenantRentalActivity.class);
        startActivity(intent);
    }
    public void tenantMaintenance(View view) {
        Intent intent= new Intent(this, TenantMaintenanceActivity.class);
        startActivity(intent);
    }


}