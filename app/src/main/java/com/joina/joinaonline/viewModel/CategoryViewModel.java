package com.joina.joinaonline.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;
import com.joina.joinaonline.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  CategoryViewModel extends AndroidViewModel {


    private MutableLiveData<String> createCategotyResponse;
    private MutableLiveData<List<Category>> categoryResponseList;
    private MutableLiveData<String> errorOnresponse;
    private MutableLiveData<String> errorOnCreateCategory;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        errorOnCreateCategory = new MutableLiveData<>();
        createCategotyResponse = new MutableLiveData<>();
        errorOnresponse = new MutableLiveData<>();
        categoryResponseList = new MutableLiveData<>();
    }


    public MutableLiveData<String> getCreateCategotyResponse(){
        return createCategotyResponse;
    }
    public MutableLiveData<String> getErrorOnCreateCategory(){
        return errorOnCreateCategory;
    }

    public MutableLiveData<List<Category>> getCategoryResponseList() {
        return categoryResponseList;
    }
    public MutableLiveData<List<Category>> getCategoryObserver(){
        return categoryResponseList;
    }


    public void createCategory(Category category){
        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<String> call = retrofitInterface.createCategory(category);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.code()==200) {
                    createCategotyResponse.postValue(response.body());
                }else {
                    errorOnCreateCategory.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                errorOnCreateCategory.postValue(t.getMessage());
            }
        });


    }

    public void  getCategories(){
        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<List<Category>> call = retrofitInterface.getCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if(response.code()==200) {
                    categoryResponseList.postValue(response.body());
                }else {
                    errorOnresponse.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                errorOnresponse.postValue(t.getMessage());
            }
        });
    }

}



