package com.joina.joinaonline.viewModel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;
import com.joina.joinaonline.model.Category;
import com.joina.joinaonline.model.ProductDto;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModel extends AndroidViewModel {
    private MutableLiveData<List<String>> mutableLiveDataProductImages;
    private MutableLiveData<List<ProductDto>> productList;
    private MutableLiveData<String> saveProductResponse;
    private MutableLiveData<String> errorOnSave;
//
//    private MutableLiveData<List<ProductDto>> productList;
    private MutableLiveData<String> errorOnProductResponse;

    private MutableLiveData<String> errorResponse;
    private MutableLiveData<String> errorOnProductresponse;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        mutableLiveDataProductImages = new MutableLiveData<>();
        errorResponse = new MutableLiveData<>();
        productList = new MutableLiveData<>();
        errorOnProductResponse = new MutableLiveData<>();
    }


    public MutableLiveData<List<String>> getProductImagesObserver(){
        return mutableLiveDataProductImages;
    }

    public MutableLiveData<String> getErrorOnSave() {
        return errorOnSave;
    }

    public MutableLiveData<String> getSaveProductResponse() {
        return saveProductResponse;
    }

    public MutableLiveData<String> getProductImagesErrorObserver(){
        return errorResponse;
    }

    public MutableLiveData<List<ProductDto>> getProductObserver(){

        Toast.makeText(getApplication().getApplicationContext(), "WINNIE ! This is a test toast!",Toast.LENGTH_SHORT).show();
        return productList;
    }

//    public MutableLiveData<List<String>> getErrorProductObserver() { return errorOnProductResponse; }

    public void uploadImages(MultipartBody.Part[] files){
        RetrofitInterface retroServiceInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<List<String>> call =   retroServiceInterface.uploadImage(files);
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String >> call, Response<List<String>> response) {

                if(response.code()==200) {
                    mutableLiveDataProductImages.postValue(response.body());

                } else {
                    errorResponse.postValue(response.errorBody().toString()+response.message()+response.code());
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
               errorResponse.postValue(t.getMessage());
            }
        });
    }

    public void saveProduct(ProductDto productDto){
        RetrofitInterface retroServiceInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<String> call =   retroServiceInterface.saveProduct(productDto);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.code()==200) {
                    saveProductResponse.postValue(response.body());

                } else {
                    errorOnSave.postValue(response.errorBody().toString()+response.message()+response.code());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                errorOnSave.postValue(t.getMessage());
            }
        });
    }

    public void getProducts() {
        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<List<ProductDto>> call = retrofitInterface.getProducts();
        call.enqueue(new Callback<List<ProductDto>>() {
            @Override
            public void onResponse(Call<List<ProductDto>> call, Response<List<ProductDto>> response) {
                if(response.code()==200) {
                    productList.postValue(response.body());
                }else {
                    errorOnProductResponse.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<ProductDto>> call, Throwable t) {
                errorOnProductResponse.postValue(t.getMessage());
            }
        });
    }

}
