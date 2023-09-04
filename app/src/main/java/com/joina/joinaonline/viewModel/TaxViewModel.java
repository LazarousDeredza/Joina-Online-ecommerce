package com.joina.joinaonline.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;
import com.joina.joinaonline.model.Tax;
import com.joina.joinaonline.model.TaxDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TaxViewModel extends AndroidViewModel {

    private MutableLiveData<String> saveTaxResponse;
    private MutableLiveData<String> errorOnSaveTax;
    private MutableLiveData<String> errorResponseTax;
    private MutableLiveData<List<Tax>> taxResponseList;
    private MutableLiveData<List<Tax>> taxVendorResponseList;

    public TaxViewModel(@NonNull Application application) {
        super(application);
        saveTaxResponse = new MutableLiveData<>();
        errorOnSaveTax = new MutableLiveData<>();
        errorResponseTax = new MutableLiveData<>();
        taxResponseList = new MutableLiveData<>();
        taxVendorResponseList = new MutableLiveData<>();
    }
    public MutableLiveData<String> getSaveTaxResponse(){
        return  saveTaxResponse;
    }
    public MutableLiveData<String> getErrorOnSaveTax(){
        return errorOnSaveTax;
    }
    public MutableLiveData<String> getErrorResponseTax(){
        return errorResponseTax;
    }
    public MutableLiveData<List<Tax>> getTaxResponseList(){
        return taxResponseList;
    }
    public MutableLiveData<List<Tax>> getTaxVendroResponseList(){
        return taxVendorResponseList;
    }



    public  void saveTax(TaxDto taxDto){
        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<String> call = retrofitInterface.saveTax(taxDto);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
               if (response.code()==200){
                saveTaxResponse.postValue(response.body());
               }else{

                   errorOnSaveTax.postValue(response.message());
               }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                errorOnSaveTax.postValue(t.getMessage());
            }
        });
    }


    public  void getTaxes(){
        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<List<Tax>> call = retrofitInterface.getTaxes();
        call.enqueue(new Callback<List<Tax>>() {
            @Override
            public void onResponse(Call<List<Tax>> call, Response<List<Tax>> response) {
                if (response.code()==200){
                    taxResponseList.postValue(response.body());
                }else{

                    errorOnSaveTax.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Tax>> call, Throwable t) {
                errorOnSaveTax.postValue(t.getMessage());
            }
        });
    }

    public  void getVendorTaxes(Long id){
        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<List<Tax>> call = retrofitInterface.getVendorTaxes(id);
        call.enqueue(new Callback<List<Tax>>() {
            @Override
            public void onResponse(Call<List<Tax>> call, Response<List<Tax>> response) {
                if (response.code()==200){
                    taxVendorResponseList.postValue(response.body());
                }else{

                    errorResponseTax.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Tax>> call, Throwable t) {
                errorResponseTax.postValue(t.getMessage());
            }
        });
    }
}
