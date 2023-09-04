package com.joina.joinaonline.Tenants.PropertyManager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.joina.joinaonline.R;
import com.joina.joinaonline.Tenants.PropertyManager.PropertyManagement.PropertyManagerPropertyManagementActivity;
import com.joina.joinaonline.Tenants.TenantAuthActivity;

import com.joina.joinaonline.Tenants.PropertyManager.PropertyManagement.PropertyManagerPropertyManagementActivity;
public class PropertyManagerDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_manager_dashboard);
    }

    public void back(View view) {
        Intent intent= new Intent(this, TenantAuthActivity.class);
        startActivity(intent);
    }

    public void pmPropertyManagement(View view) {
        Intent intent= new Intent(this, PropertyManagerPropertyManagementActivity.class);
        startActivity(intent);
    }

    public void pmTenantManagement(View view) {
        Intent intent= new Intent(this, PropertyManagerTenantManagementActivity.class);
        startActivity(intent);
    }

    public void pmMaintananceManagement(View view) {
        Intent intent= new Intent(this, PropertyManagerMaintananceManagementActivity.class);
        startActivity(intent);
    }

    public void pmLeaseManagement(View view) {
        Intent intent= new Intent(this, PropertyManagerLeaseManagementActivity.class);
        startActivity(intent);
    }
}