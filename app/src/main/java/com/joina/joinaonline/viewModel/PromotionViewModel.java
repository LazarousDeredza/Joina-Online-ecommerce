package com.joina.joinaonline.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;
import com.joina.joinaonline.model.Discount;
import com.joina.joinaonline.model.DiscountDto;
import com.joina.joinaonline.model.Promotion;
import com.joina.joinaonline.model.PromotionDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PromotionViewModel extends AndroidViewModel {
    private MutableLiveData<String> promotionResponse;
    private MutableLiveData<List<Promotion>> promotionResponseList;
    private MutableLiveData<String> errorResponseOnSave;
    private MutableLiveData<String> errorResponseList;

    public PromotionViewModel(@NonNull Application application) {
        super(application);
        promotionResponse = new MutableLiveData<>();
        promotionResponseList = new MutableLiveData<>();
        errorResponseList = new MutableLiveData<>();
        errorResponseOnSave = new MutableLiveData<>();
    }

    public MutableLiveData<List<Promotion>> getPromotionResponseList() {
        return promotionResponseList;
    }

    public MutableLiveData<String> getErrorResponseList() {
        return errorResponseList;
    }

    public MutableLiveData<String> getErrorResponseOnSave() {
        return errorResponseOnSave;
    }

    public MutableLiveData<String> getPromotionResponse() {
        return promotionResponse;
    }

//    public void savePromotion(PromotionDto promotionDto){
//        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
//        Call<String> call = retrofitInterface.saveDiscount(promotionDto);
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if (response.code()==200){
//                    discountResponse.postValue(response.body());
//                }else{
//
//                    errorOnSave.postValue(response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                errorOnSave.postValue(t.getMessage());
//            }
//        });
//    }

    public void getVendorPromotion(Long id){
        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<List<Promotion>> call = retrofitInterface.getVendorPromotion(id);
        call.enqueue(new Callback<List<Promotion>>() {
            @Override
            public void onResponse(Call<List<Promotion>> call, Response<List<Promotion>> response) {
                if (response.code()==200){
                    promotionResponseList.postValue(response.body());
                }else{

                    errorResponseList.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Promotion>> call, Throwable t) {
                errorResponseList.postValue(t.getMessage());
            }
        });
    }

    }


