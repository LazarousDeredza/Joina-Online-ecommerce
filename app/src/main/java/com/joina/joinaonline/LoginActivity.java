package com.joina.joinaonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.joina.joinaonline.JoinaonlineAdmin.JoinaAdminMainActivity;
import com.joina.joinaonline.JoinaonlineTenants.JoinaTenantsMainActivity;
import com.joina.joinaonline.SmartParking.SmartParkingActivity;
import com.joina.joinaonline.Tenants.TenantAuthActivity;
import com.joina.joinaonline.viewModel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    Button loginButton, TenantLoginButton;
    Button UserLoginButton;
    Button adminButton, tenants;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    // Static admin and tenant credentials
    private static final String ADMIN_USERNAME = "admin@joina.com";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String TENANT_USERNAME = "tenant@joina.com";
    private static final String TENANT_PASSWORD = "tenant123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        loginButton = findViewById(R.id.btnLogin);
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                startActivity(new Intent(LoginActivity.this, SmartParkingActivity.class));
//                finish();
//            }
//        });
//
//        TenantLoginButton = findViewById(R.id.tenantLogin);
//          TenantLoginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(LoginActivity.this, JoinaTenantsMainActivity.class));
//                finish();
//            }
//        });

        editTextUsername = findViewById(R.id.etEmail);
        editTextPassword = findViewById(R.id.etPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {

                    // Admin login successful
                    Toast.makeText(LoginActivity.this, "Admin login successful", Toast.LENGTH_SHORT).show();
                    // TODO: Proceed to admin activity


                startActivity(new Intent(LoginActivity.this, SmartParkingActivity.class));
                finish();
                } else if (username.equals(TENANT_USERNAME) && password.equals(TENANT_PASSWORD)) {

                    // Tenant login successful
                    Toast.makeText(LoginActivity.this, "Tenant login successful", Toast.LENGTH_SHORT).show();
                    // TODO: Proceed to tenant activity

                startActivity(new Intent(LoginActivity.this, JoinaTenantsMainActivity.class));
                finish();
                } else {
                    // Invalid credentials
                    Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
          
//        adminButton = findViewById(R.id.adminButton);
//        adminButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startActivity(new Intent(LoginActivity.this, JoinaAdminMainActivity.class));
//                finish();
//            }
//        });
//
//        tenants = findViewById(R.id.tenants);
//        tenants.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startActivity(new Intent(LoginActivity.this, TenantAuthActivity.class));
//                finish();
//            }
//        });


}