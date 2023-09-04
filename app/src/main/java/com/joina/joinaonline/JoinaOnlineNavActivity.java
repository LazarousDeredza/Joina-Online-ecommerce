package com.joina.joinaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.Joinaonline.JoinaOnlineHomeActivity;
import com.joina.joinaonline.JoinaonlineAdmin.JoinaAdminMainActivity;
import com.joina.joinaonline.JoinaonlineAdmin.ShowCategoriesActivity;
import com.joina.joinaonline.JoinaonlineTenants.JoinaTenantsMainActivity;

public class JoinaOnlineNavActivity extends AppCompatActivity {

    MaterialButton users,tenants, admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joina_online_nav);

        users=findViewById(R.id.users);
        tenants=findViewById(R.id.tenants);
        admin = findViewById(R.id.admin);

        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinaOnlineNavActivity.this, JoinaOnlineHomeActivity.class);
                startActivity(intent);
            }
        });

        tenants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinaOnlineNavActivity.this, JoinaTenantsMainActivity.class);
                startActivity(intent);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinaOnlineNavActivity.this, JoinaAdminMainActivity.class);
                startActivity(intent);
            }
        });

    }
}