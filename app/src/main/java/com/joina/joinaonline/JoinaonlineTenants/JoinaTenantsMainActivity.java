package com.joina.joinaonline.JoinaonlineTenants;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.joina.joinaonline.R;

public class JoinaTenantsMainActivity extends AppCompatActivity {

//    TextView dashboard, main_settings, orders, payment_settings, payments, payments_overview, products, storefront, collections_or_brands, add_product, add_collection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joina_tenants_main);



        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        NavController navController = Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);


//        dashboard = findViewById(R.id.dashboard_activity);

//        dashboard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(JoinaTenantsMainActivity.this, DashboardActivity.class);
//                startActivity(intent);
//            }
//        });

    }
}