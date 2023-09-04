package com.joina.joinaonline.JoinaonlineAdmin.CategoryRequests;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.joina.joinaonline.R;
import com.joina.joinaonline.model.SubCategory;
import com.joina.joinaonline.viewModel.SubcategoryViewModel;

public class JoinaOnlineAdminAddSubcategoryActivity extends AppCompatActivity {
    Toolbar toolbar;

    TextInputEditText subCategoryName, subCategoryDescription;
    Button btnSaveSubcategory;
    private SubcategoryViewModel subCategoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joina_online_admin_add_subcategory);

        subCategoryName = findViewById(R.id.subcategory_Name);
        subCategoryDescription = findViewById(R.id.subcategory_Description);
        btnSaveSubcategory = findViewById(R.id.btnSaveSubcategory);
        subCategoryViewModel = ViewModelProviders.of(this).get(SubcategoryViewModel.class);

        btnSaveSubcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = subCategoryName.getText().toString();
                String description = subCategoryDescription.getText().toString();
                long categoryId = 2;
                SubCategory subCategory = new SubCategory(name, categoryId, description);

                
                 subCategoryViewModel.saveSubcategory(subCategory);

                createSubCategoryObserver();
                errorSubCategoryObserver();

            }
        });





        toolbar=findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinaOnlineAdminAddSubcategoryActivity.this, JoinaAdminCategoryRequestsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createSubCategoryObserver(){
        subCategoryViewModel.getSaveSubcategoryResponse().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {

                if(response == null) {
                    Toast.makeText(JoinaOnlineAdminAddSubcategoryActivity.this, "Failed", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(JoinaOnlineAdminAddSubcategoryActivity.this, "Success " +response, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void errorSubCategoryObserver(){
        subCategoryViewModel.getErrorOnSaveSubcategory().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {

                if(response == null) {
                    Toast.makeText(JoinaOnlineAdminAddSubcategoryActivity.this, "Failed.....", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(JoinaOnlineAdminAddSubcategoryActivity.this, "Error " +response, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}