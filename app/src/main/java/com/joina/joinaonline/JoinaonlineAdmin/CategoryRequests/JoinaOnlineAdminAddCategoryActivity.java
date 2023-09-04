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
import com.joina.joinaonline.model.Category;
import com.joina.joinaonline.viewModel.CategoryViewModel;

public class JoinaOnlineAdminAddCategoryActivity extends AppCompatActivity {
    Toolbar toolbar;


    TextInputEditText categoryName, categoryDescription;
    Button btnSaveCategory;
    private CategoryViewModel categoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joina_online_admin_add_category);

        categoryName = findViewById(R.id.category_Name);
        categoryDescription = findViewById(R.id.category_Description);
        btnSaveCategory = findViewById(R.id.btnSaveCategory);
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);

        toolbar=findViewById(R.id.toolbar);

        btnSaveCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = categoryName.getText().toString();
                String description = categoryDescription.getText().toString();

                Category category = new Category(name, description);

                categoryViewModel.createCategory(category);

                createCategoryObserver();
                errorCategoryObserver();


                        Intent intent = new Intent( JoinaOnlineAdminAddCategoryActivity.this, JoinaAdminCategoryRequestsActivity.class);
                        startActivity(intent);
            }
        });
    }

    private void createCategoryObserver(){
        categoryViewModel.getCreateCategotyResponse().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {

                if(response == null) {
                    Toast.makeText(JoinaOnlineAdminAddCategoryActivity.this, "Failed", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(JoinaOnlineAdminAddCategoryActivity.this, "Success " +response, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void errorCategoryObserver(){
        categoryViewModel.getErrorOnCreateCategory().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {

                if(response == null) {
                    Toast.makeText(JoinaOnlineAdminAddCategoryActivity.this, "Failed...", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(JoinaOnlineAdminAddCategoryActivity.this, "Error " +response, Toast.LENGTH_LONG).show();
                }
            }
        });

    }


//    private void initViewModel() {
//        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
//        categoryViewModel.ddCategoryMutableLiveData().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String category) {
//                if(category == null) {
//                    Toast.makeText(JoinaOnlineAdminAddCategoryActivity.this, "There are no categories", Toast.LENGTH_LONG).show();
//                } else {

//                    Toast.makeText(JoinaOnlineAdminAddCategoryActivity.this, "Successfully added category " +category, Toast.LENGTH_LONG).show();
//
//                }
//            }
//        });
//    }

}