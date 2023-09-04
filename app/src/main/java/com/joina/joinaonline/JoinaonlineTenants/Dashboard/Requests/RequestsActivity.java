package com.joina.joinaonline.JoinaonlineTenants.Dashboard.Requests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.R;

public class RequestsActivity extends AppCompatActivity {

    MaterialButton categoryRequest, subcategoryRequest, brandRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        categoryRequest = findViewById(R.id.category_requests);
        subcategoryRequest = findViewById(R.id.subcategory_requests);
        brandRequest = findViewById(R.id.brand_requests);

        categoryRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RequestsActivity.this,CategoriesRequestsActivity.class);
                startActivity(intent);
            }
        });

        subcategoryRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RequestsActivity.this,SubcategoriesRequestsActivity.class);
                startActivity(intent);
            }
        });

        brandRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RequestsActivity.this,BrandsRequestsActivity.class);
                startActivity(intent);
            }
        });

    }
}