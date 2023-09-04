package com.joina.joinaonline.JoinaonlineAdmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.joina.joinaonline.R;
import com.joina.joinaonline.viewModel.CategoryViewModel;

import java.util.List;

public class JoinaOnlineAdminAddCategoryActivity extends AppCompatActivity {
    Toolbar toolbar;

    private EditText categoryName, categoryDescription;
    private Button btnSaveCategory;
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

//        btnSaveCategory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name = categoryName.getText().toString();
//                String description = categoryDescription.getText().toString();
//                CategoryResponse categoryResponse = new CategoryResponse(name , description);
//                categoryViewModel.createPost(categoryResponse);
//            }
//        });



//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent( JoinaOnlineAdminAddCategoryActivity.this, JoinaAdminCategoryRequestsActivity.class);
//                startActivity(intent);
//            }
//        });
//    }

        btnSaveCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = categoryName.getText().toString();
                String description = categoryDescription.getText().toString();
//                categoryViewModel.createPost(categoryResponse);
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
//                    //https://gorest.co.in/public-api/users/1383
//                    //{"code":201,"meta":null,"data":{"id":1383,"name":"TestPOST123","email":"TestPOST123@Yahoo.com","gender":"male","status":"active"}}
//
//                    Toast.makeText(JoinaOnlineAdminAddCategoryActivity.this, "Successfully added category " +category, Toast.LENGTH_LONG).show();
//
//                }
//            }
//        });
//    }
}
