package com.joina.joinaonline.JoinaonlineTenants.Dashboard.Requests;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.joina.joinaonline.R;
import com.joina.joinaonline.model.Category;
import com.joina.joinaonline.viewModel.CategoryViewModel;

public class CategoriesRequestsActivity extends AppCompatActivity {

    TextInputEditText categoryName,categoryDescription;
    Button btnSaveCategory;
    CategoryViewModel categoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_requests);

        categoryName = findViewById(R.id.category_Name);
        categoryDescription = findViewById(R.id.category_Description);
        btnSaveCategory = findViewById(R.id.btnSaveCategory);

        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);

        btnSaveCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String category_name = categoryName.getText().toString();
                String category_description = categoryDescription.getText().toString();

                Category category = new Category(category_name,category_description);

                categoryViewModel.createCategory(category);
//
//                createCategoryErrorObserver();
                createCategoryObserver();

            }
        });

    }

//    private void createCategoryErrorObserver() {
//        categoryViewModel.getCreateCategoryResponse().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String response) {
//                if(response == null) {
//                    Toast.makeText(CategoriesRequestsActivity.this, "Failed", Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Toast.makeText(CategoriesRequestsActivity.this,"Success !" + response, Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }


    private void createCategoryObserver() {
        categoryViewModel.getErrorOnCreateCategory().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {
                if(response == null) {
                    Toast.makeText(CategoriesRequestsActivity.this, "Failed !", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(CategoriesRequestsActivity.this,"Error " + response, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}