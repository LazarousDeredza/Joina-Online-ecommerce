package com.joina.joinaonline.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;
import com.joina.joinaonline.model.Brand;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandViewModel extends AndroidViewModel {
    private MutableLiveData<String> mutableLiveDataBrandImages,errorResponseImage;

    private MutableLiveData<String> errorResponse;

    private MutableLiveData<String>saveBrandsResponse;
    private MutableLiveData<String> errorOnSaveBrand;
    private MutableLiveData<List<Brand>> brandResponseList;


    public BrandViewModel(@NonNull Application application) {
        super(application);
        errorOnSaveBrand = new MutableLiveData<>();
        saveBrandsResponse = new MutableLiveData<>();
        mutableLiveDataBrandImages = new MutableLiveData<>();
        errorResponse = new MutableLiveData<>();
        brandResponseList = new MutableLiveData<>();
        errorResponseImage = new MutableLiveData<>();

    }

    public MutableLiveData<String> getSaveBrandsResponse() {
        return saveBrandsResponse;
    }

    public MutableLiveData<String> getErrorOnSaveBrand() {
        return errorOnSaveBrand;
    }

    public MutableLiveData<String> getErrorResponse() {
        return errorResponse;
    }

    public void saveBrands(Brand brand) {
        RetrofitInterface retroServiceInterface = RetrofitService.createService(RetrofitInterface.class);

        Call<String> call =   retroServiceInterface.saveBrands(brand);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.code()==200) {

                    saveBrandsResponse.postValue(response.body());
                }
                else {

                    errorOnSaveBrand.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                errorOnSaveBrand.postValue(t.getMessage());

            }
        });
    }

    public MutableLiveData<List<Brand>> getBrandResponseList(){
        return brandResponseList;
    }
    public void getBrands() {
        RetrofitInterface retroServiceInterface = RetrofitService.createService(RetrofitInterface.class);

        Call<List<Brand>> call =   retroServiceInterface.getBrands();
        call.enqueue(new Callback<List<Brand>>() {
            @Override
            public void onResponse(Call<List<Brand>> call, Response<List<Brand>> response) {

                if (response.code()==200) {

                    brandResponseList.postValue(response.body());
                }
                else {

                    errorResponse.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Brand>> call, Throwable t) {
                errorResponse.postValue(t.getMessage());

            }
        });
    }
    public MutableLiveData<String> getBrandImagesObserver(){
        return mutableLiveDataBrandImages;
    }

    public MutableLiveData<String> getBrandImagesErrorObserver(){
        return errorResponseImage;
    }

    public void uploadbrand(MultipartBody.Part file){
        RetrofitInterface retroServiceInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<String> call =   retroServiceInterface.uploadbrand(file);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.code()==200) {
                    mutableLiveDataBrandImages.postValue(response.body());

                } else {
                    errorResponseImage.postValue(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                errorResponseImage.postValue(t.getMessage());
            }
        });
    }
}
