package com.joina.joinaonline.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;
import com.joina.joinaonline.model.Category;
import com.joina.joinaonline.model.Vendor;

import java.util.Vector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VendorsModelView extends AndroidViewModel {

    private MutableLiveData<String> addVendors;
    private MutableLiveData<String> errorOnCreateAddVendors;

    public VendorsModelView(@NonNull Application application) {
        super(application);
        this.addVendors = addVendors;
        this.errorOnCreateAddVendors = errorOnCreateAddVendors;

    }

    public MutableLiveData<String> getCreateAddVendors(){
        return addVendors;
    }
    public MutableLiveData<String> getErrorOnCreateAddVendors(){
        return errorOnCreateAddVendors;
    }

    public void addVendor(Vendor vendors){
        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<String> call = retrofitInterface.addVendor(vendors);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.code()==200) {
                    addVendors.postValue(response.body());
                }else {
                    errorOnCreateAddVendors.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                errorOnCreateAddVendors.postValue(t.getMessage());
            }
        });


    }

}
