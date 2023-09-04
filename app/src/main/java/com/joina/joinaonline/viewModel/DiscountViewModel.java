package com.joina.joinaonline.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;
import com.joina.joinaonline.model.Discount;
import com.joina.joinaonline.model.DiscountDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscountViewModel extends AndroidViewModel {
    private MutableLiveData<List<Discount>> discountResponseList;
    private MutableLiveData<String> discountResponse;
    private MutableLiveData<String> errorOnSave;
    private MutableLiveData<String> errorOnResponseList;

    public DiscountViewModel(@NonNull Application application) {
        super(application);
        discountResponseList = new MutableLiveData<>();
        errorOnResponseList = new MutableLiveData<>();
        errorOnSave = new MutableLiveData<>();
        discountResponse = new MutableLiveData<>();

    }

    public MutableLiveData<List<Discount>> getDiscountResponseList() {
        return discountResponseList;
    }

    public MutableLiveData<String> getErrorOnResponseList() {
        return errorOnResponseList;
    }

    public MutableLiveData<String> getErrorOnSave() {
        return errorOnSave;
    }

    public MutableLiveData<String> getDiscountResponse() {
        return discountResponse;
    }

    public void saveDiscount(DiscountDto discountDto){
        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<String> call = retrofitInterface.saveDiscount(discountDto);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.code()==200){
                    discountResponse.postValue(response.body());
                }else{

                    errorOnSave.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                errorOnSave.postValue(t.getMessage());
            }
        });
    }
    public void getVendorDiscount(Long id){
        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<List<Discount>> call = retrofitInterface.getVendorDiscount(id);
        call.enqueue(new Callback<List<Discount>>() {
            @Override
            public void onResponse(Call<List<Discount>> call, Response<List<Discount>> response) {
                if (response.code()==200){
                    discountResponseList.postValue(response.body());
                }else{

                    errorOnResponseList.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Discount>> call, Throwable t) {
                errorOnResponseList.postValue(t.getMessage());
            }
        });
    }
}
