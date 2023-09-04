package com.joina.joinaonline;

import android.content.Intent;
import android.view.View;

import com.joina.joinaonline.api.RetrofitInterface;
import com.joina.joinaonline.api.RetrofitService;
import com.joina.joinaonline.model.Login;
import com.joina.joinaonline.model.Tokens;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Auth {

    public Auth() {
    }
//
//    public void loginRemote(Login login, ILoginResponse tokens){
//        RetrofitInterface retroServiceInterface = RetrofitService.createService(RetrofitInterface.class);
//        Call<Tokens> initiateLogin = retroServiceInterface.login(login);
//
//
//        initiateLogin.enqueue(new Callback<Tokens>() {
//            @Override
//            public void onResponse(Call<Tokens> call, Response<Tokens> response) {
//                if (response.isSuccessful()){
//                    tokens.onResponse(response.body());
////                    startActivity(new Intent(Auth.this, MainActivity.class));
////                    finish();
//
//                } else {
//                    tokens.onFailure(new Throwable(response.message()));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Tokens> call, Throwable t) {
//                tokens.onFailure(t);
//            }
//        });
//
//    }
//
//    public interface ILoginResponse {
//        void onResponse(Tokens tokens);
//        void onFailure(Throwable t);
//    }
}
