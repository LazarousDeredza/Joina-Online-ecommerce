package com.joina.joinaonline.Systems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.joina.joinaonline.R;
import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.viewModel.CategoryViewModel;

import java.util.List;

public class SystemsHomeActivity extends AppCompatActivity {

    TextView slogan;

    RetrofitInterface retrofitInterface;
    CategoryViewModel categoryViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systems_home);

        slogan = findViewById(R.id.slogan);
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
//        categoryViewModel.getCategories();




    }

//    private void getCategories(){
//
//        categoryViewModel.categoryResponseMutableLiveData().observe(this, new Observer<List<CategoryResponse>>() {
//            @Override
//            public void onChanged(List<CategoryResponse> categoryResponses) {
//                if(categoryResponses == null) {
//                    Toast.makeText(SystemsHomeActivity.this, "failed to upload", Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Toast.makeText(SystemsHomeActivity.this, categoryResponses.get(0).getName(), Toast.LENGTH_LONG).show();
//                }
//            }
//        });
}



//    java.lang.NullPointerException: Attempt to invoke interface method 'int java.util.List.size()' on a null object reference
//        at com.joina.joinaonline.Systems.SystemsHomeActivity$1.onResponse(SystemsHomeActivity.java:38)


