package com.joina.joinaonline.Tenants.TenantInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.joina.joinaonline.R;

public class TenantPropertyInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_property_information);

    }
    public void back(View view) {
        Intent intent = new Intent(this, TenantDashboardActivity.class);
        startActivity(intent);
    }
}