package com.joina.joinaonline.SmartParking.Admin.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.joina.joinaonline.SmartParking.Admin.Models.TagManagementModel;
import com.joina.joinaonline.SmartParking.Admin.ParkingLog.ParkingLogModel;
import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TagManagementViewModel extends AndroidViewModel {
    //    private MutableLiveData<String> createCategotyResponse;
//    private MutableLiveData<String> errorOnCreateCategory;

    private MutableLiveData<ArrayList<TagManagementModel>> tagManagementModelArrayList;
    private MutableLiveData<String> errorOnresponse;

    public TagManagementViewModel(@NonNull Application application) {
        super(application);
//        errorOnCreateCategory = new MutableLiveData<>();
//        createCategotyResponse = new MutableLiveData<>();
        errorOnresponse = new MutableLiveData<>();
        tagManagementModelArrayList = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<TagManagementModel>> getTagManagementModelList() {
        return tagManagementModelArrayList;
    }
    public MutableLiveData<ArrayList<TagManagementModel>> getTagManagementObserver(){
        return tagManagementModelArrayList;
    }

    public void  getTagManagementViewModel(){

        RetrofitInterface retrofitInterface = RetrofitService.createService(RetrofitInterface.class);
        Call<ArrayList<TagManagementModel>> call = retrofitInterface.getTagManagementViewModel();
        call.enqueue(new Callback<ArrayList<TagManagementModel>>() {
            @Override
            public void onResponse(Call<ArrayList<TagManagementModel>> call, Response<ArrayList<TagManagementModel>> response) {
                if(response.code()==200) {
                    tagManagementModelArrayList.postValue(response.body());

                }else {
                    errorOnresponse.postValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<TagManagementModel>> call, Throwable t) {
                errorOnresponse.postValue(t.getMessage());
            }
        });
    }
}
