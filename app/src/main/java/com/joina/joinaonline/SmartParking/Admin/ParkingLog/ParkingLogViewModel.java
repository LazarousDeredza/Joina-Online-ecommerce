package com.joina.joinaonline.SmartParking.Admin.ParkingLog;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParkingLogViewModel extends AndroidViewModel {
//    private MutableLiveData<String> createCategotyResponse;
//    private MutableLiveData<String> errorOnCreateCategory;
    private MutableLiveData<ArrayList<ParkingLogModel>> parkingLogModelList;
    private MutableLiveData<String> errorOnresponse;


    public ParkingLogViewModel(@NonNull Application application) {
        super(application);
//        errorOnCreateCategory = new MutableLiveData<>();
//        createCategotyResponse = new MutableLiveData<>();
        errorOnresponse = new MutableLiveData<>();
        parkingLogModelList = new MutableLiveData<>();
    }


//    public MutableLiveData<String> getCreateCategotyResponse(){
//        return createCategotyResponse;
//    }
//    public MutableLiveData<String> getErrorOnCreateCategory(){
//        return errorOnCreateCategory;
//    }

    public MutableLiveData<ArrayList<ParkingLogModel>> getParkingLogModelList() {
        return parkingLogModelList;
    }
    public MutableLiveData<ArrayList<ParkingLogModel>> getPassLogLObserver(){
        return parkingLogModelList;
    }

//    public void createCategory(Category category){
//        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
//        Call<String> call = retrofitInterface.createCategory(category);
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if(response.code()==200) {
//                    createCategotyResponse.postValue(response.body());
//                }else {
//                    errorOnCreateCategory.postValue(response.message());
//                }
//            }

//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                errorOnCreateCategory.postValue(t.getMessage());
//            }
//        });
//    }
    public void  getParkingLogViewModel(){

        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<ArrayList<ParkingLogModel>> call = retrofitInterface.getParkingLogViewModel();
        call.enqueue(new Callback<ArrayList<ParkingLogModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ParkingLogModel>> call, Response<ArrayList<ParkingLogModel>> response) {
                if(response.code()==200) {
                    parkingLogModelList.postValue(response.body());

                }else {
                    errorOnresponse.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ParkingLogModel>> call, Throwable t) {
                errorOnresponse.postValue(t.getMessage());
            }
        });
   }
}
