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
import com.joina.joinaonline.model.SubCategory;
import com.joina.joinaonline.viewModel.SubcategoryViewModel;

public class SubcategoriesRequestsActivity extends AppCompatActivity {

    TextInputEditText subcategoryName, subcategoryDescription;
    Button btnSendRequests;
    private SubcategoryViewModel subcategoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategories_requests);

        subcategoryName = findViewById(R.id.subcategory_name);
        subcategoryDescription = findViewById(R.id.subcategory_description);
        btnSendRequests = findViewById(R.id.btnSendRequest);

        subcategoryViewModel = ViewModelProviders.of(this).get(SubcategoryViewModel.class);

        btnSendRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subcategory_name = subcategoryName.getText().toString();
                String subcategory_description = subcategoryDescription.getText().toString();
                long categoryId = 1;

                SubCategory subcategory = new SubCategory(subcategory_name,categoryId,subcategory_description);

                subcategoryViewModel.saveSubcategory(subcategory);

                saveSubcategoryErrorObserver();
                saveSubcategoryObserver();

            }
        });

    }

    private void saveSubcategoryObserver() {
        subcategoryViewModel.getSaveSubcategoryResponse().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {
                if(response == null) {
                    Toast.makeText(SubcategoriesRequestsActivity.this, "Failed", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(SubcategoriesRequestsActivity.this,"Success !" + response, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void saveSubcategoryErrorObserver() {
        subcategoryViewModel.getErrorOnSaveSubcategory().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {
                if(response == null) {
                    Toast.makeText(SubcategoriesRequestsActivity.this, "failed eee", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(SubcategoriesRequestsActivity.this,"Error eee" + response, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}