package com.joina.joinaonline.Tenants.TenantInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.joina.joinaonline.R;


public class TenantMaintenanceActivity extends AppCompatActivity {
    Spinner level_Of_Urgency;
    String [] levelsOfUrgency ={"Critical","Medium", "Minor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_maintenance);
        level_Of_Urgency = findViewById(R.id.levelOfUrgency);
        ArrayAdapter managerArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, levelsOfUrgency);
        managerArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        level_Of_Urgency.setAdapter(managerArray);
    }
    public void back(View view) {
        Intent intent= new Intent(this, TenantDashboardActivity.class);
        startActivity(intent);
    }
}