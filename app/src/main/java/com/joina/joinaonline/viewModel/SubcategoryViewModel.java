package com.joina.joinaonline.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;
import com.joina.joinaonline.model.SubCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubcategoryViewModel extends AndroidViewModel {

    private MutableLiveData<String> saveSubcategoryResponse;
    private MutableLiveData<String> errorOnSaveSubcategory;
    private MutableLiveData<List<SubCategory>> subCategoryResponseList;
    private MutableLiveData<String> errorResponse;

    public SubcategoryViewModel(@NonNull Application application) {
        super(application);
        errorOnSaveSubcategory = new MutableLiveData<>();
        saveSubcategoryResponse = new MutableLiveData<>();
        errorResponse = new MutableLiveData<>();
        subCategoryResponseList =new MutableLiveData<>();
    }

    public MutableLiveData<String> getSaveSubcategoryResponse() {
        return saveSubcategoryResponse;
    }

    public MutableLiveData<String> getErrorOnSaveSubcategory() {
        return errorOnSaveSubcategory;
    }

    public MutableLiveData<List<SubCategory>> getSubCategoryResponseList() {
        return subCategoryResponseList;
    }

    public MutableLiveData<String> getErrorResponse() {
        return errorResponse;
    }

    public void saveSubcategory(SubCategory subcategory) {
        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<String> call = retrofitInterface.saveSubcategory(subcategory);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.code() ==200) {
                    saveSubcategoryResponse.postValue(response.body());
                }
                else {
                    errorOnSaveSubcategory.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                errorOnSaveSubcategory.postValue(t.getMessage());
            }
        });

        }

        public void getSubCategories(){
            RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
            Call<List<SubCategory>> call = retrofitInterface.getSubCategories();
            call.enqueue(new Callback<List<SubCategory>>() {
                @Override
                public void onResponse(Call<List<SubCategory>> call, Response<List<SubCategory>> response) {
                    if (response.code() ==200) {
                        subCategoryResponseList.postValue(response.body());
                    }
                    else {
                        errorResponse.postValue(response.message());
                    }
                }

                @Override
                public void onFailure(Call<List<SubCategory>> call, Throwable t) {
                    errorResponse.postValue(t.getMessage());
                }
            });
        }
    }



//    public void saveSubcategory(Brand brand) {
//        RetrofitInterface retroServiceInterface = RetrofitService.createService(RetrofitInterface.class);
//
//        Call<String> call =   retroServiceInterface.saveBrands(brand);
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//
//                if (response.code()==200) {
//
//                    saveSubcategoryResponse.postValue(response.body());
//                }
//                else {
//
//                    errorOnSaveSubcategory.postValue(response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                errorOnSaveSubcategory.postValue(t.getMessage());
//
//            }
//        });
//}}
