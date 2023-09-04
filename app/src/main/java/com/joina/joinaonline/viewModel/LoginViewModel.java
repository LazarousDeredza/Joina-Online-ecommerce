package com.joina.joinaonline.viewModel;

import android.app.Application;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.joina.joinaonline.Auth;
import com.joina.joinaonline.LoginActivity;
import com.joina.joinaonline.MainActivity;
import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;
import com.joina.joinaonline.model.Login;
import com.joina.joinaonline.model.Tokens;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {
    public LoginViewModel(@NonNull Application application) {
        super(application);
    }
//
//    MutableLiveData<Integer> mProgressMutableData = new MutableLiveData<>();
//    MutableLiveData<String> mLoginResultMutableData = new MutableLiveData<>();
//
//    Auth mAuth;
//
//    public LoginViewModel(@NonNull Application application) {
//        super(application);
//        mProgressMutableData.postValue(View.INVISIBLE);
//        mLoginResultMutableData.postValue("Not logged in");
//        mAuth = new Auth();
//    }
//
//    public void login(String email, String password){
//        mProgressMutableData.postValue(View.VISIBLE);
//        mLoginResultMutableData.postValue("Checking");
//        mAuth.loginRemote(new Login(email, password), new Auth.ILoginResponse() {
//            @Override
//            public void onResponse(Tokens loginResponse) {
//                mProgressMutableData.postValue(View.INVISIBLE);
//                mLoginResultMutableData.postValue("Login Success");
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                mProgressMutableData.postValue(View.INVISIBLE);
//                mLoginResultMutableData.postValue("Login failure: " + t.getLocalizedMessage());
//            }
//        });
//    }
//
//
//
//    public LiveData<String> getLoginResult(){
//        return mLoginResultMutableData;
//    }
//
//    public LiveData<Integer> getProgress(){
//        return mProgressMutableData;
//    }

//    private MutableLiveData<Tokens> tokensResponse;
//    private MutableLiveData<String> errorOnLogiginResponse;
//    public LoginViewModel(@NonNull Application application) {
//        super(application);
//        tokensResponse = new MutableLiveData<>();
//        errorOnLogiginResponse = new MutableLiveData<>();
//
//    }
//
//    public MutableLiveData<Tokens> getTokensResponse() {
//        return tokensResponse;
//    }
//
//    public MutableLiveData<String> getErrorOnLogiginResponse() {
//        return errorOnLogiginResponse;
//    }
//    public void login(String email , String password){
//        RetrofitInterface retroServiceInterface = RetrofitService.createService(RetrofitInterface.class);
//
//        Call<Tokens> call =   retroServiceInterface.login(login);
//        call.enqueue(new Callback<Tokens>() {
//            @Override
//            public void onResponse(Call<Tokens> call, Response<Tokens> response) {
//
//                if (response.code()==200) {
//
//                    tokensResponse.postValue(response.body());
//                }
//                else {
//
//                    errorOnLogiginResponse.postValue(response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Tokens> call, Throwable t) {
//                errorOnLogiginResponse.postValue(t.getMessage());
//
//            }
//        });
//    }
//
//

}
