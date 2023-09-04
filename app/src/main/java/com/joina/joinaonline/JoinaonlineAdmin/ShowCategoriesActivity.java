package com.joina.joinaonline.JoinaonlineAdmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.joina.joinaonline.R;
import com.joina.joinaonline.viewModel.CategoryViewModel;

import java.util.List;

public class ShowCategoriesActivity extends AppCompatActivity {

    CategoryViewModel categoryViewModel;
    TextView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_categories);

        categoryViewModel =  ViewModelProviders.of(this).get(CategoryViewModel.class);
//        initViewModel();


//        Call<List<CategoryResponse>> call = APIClient.getmInstance().getAPInterface().getCategories();
//        call.enqueue(new Callback<List<CategoryResponse>>() {
//            @Override
//            public void onResponse(Call<List<CategoryResponse>> call, Response<List<CategoryResponse>> response) {
//               try {
//                   if(response.code()==200){
//                       String categoriesList = response.body().toString();
//                       Toast.makeText(ShowCategoriesActivity.this, "Successfully called categories "+ categoriesList, Toast.LENGTH_LONG).show();
//                       list.setText(categoriesList);
//                   }
//               }catch (Exception e){
//                   Toast.makeText(ShowCategoriesActivity.this , "api r asffsfasfAKF"+e.getMessage(), Toast.LENGTH_LONG).show();
//               }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<CategoryResponse>> call, Throwable t) {
//Toast.makeText(ShowCategoriesActivity.this , "api rAKF"+t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });


    }

//    private void initViewModel() {
//        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
//        categoryViewModel.categoryResponseMutableLiveData().observe(this, new Observer<List<CategoryResponse>>() {
//            @Override
//            public void onChanged(List<CategoryResponse> categoryResponse) {
//                if(categoryResponse == null) {
//                    Toast.makeText(ShowCategoriesActivity.this, "There are no categories", Toast.LENGTH_LONG).show();
//                } else {
//                    //https://gorest.co.in/public-api/users/1383
//                    //{"code":201,"meta":null,"data":{"id":1383,"name":"TestPOST123","email":"TestPOST123@Yahoo.com","gender":"male","status":"active"}}
//                    String categoriesList = categoryResponse.get(0).getDescription();
//                    Toast.makeText(ShowCategoriesActivity.this, "Successfully called categories "+ categoriesList, Toast.LENGTH_LONG).show();
//                    list.setText(categoriesList);
//                }
//            }
//        });
//    }

}