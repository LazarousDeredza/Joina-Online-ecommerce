package com.joina.joinaonline.Tenants.GuestUser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.joina.joinaonline.MainActivity;
import com.joina.joinaonline.R;


public class TenantsGuestApplicationFormActivity extends AppCompatActivity {
    Spinner line_Of_Business_Spinner;
    String [] lineOfBusiness ={"Technology","Wholesale", "Real Estate", "Hedge Fund"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenants_guest_application_form);

        line_Of_Business_Spinner = findViewById(R.id.lineOfBusinessSpinner);
        ArrayAdapter managerArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lineOfBusiness);
        managerArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        line_Of_Business_Spinner.setAdapter(managerArray);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

    }

    public void goToUpload(View view) {
        Intent intent= new Intent(this, TenantsGuestApplicationUploadActivity.class);
        startActivity(intent);
    }

    public void back(View view) {
//        Intent intent= new Intent(this, MainActivity.class);
        startActivity(new Intent(TenantsGuestApplicationFormActivity.this, MainActivity.class));
    }
}




