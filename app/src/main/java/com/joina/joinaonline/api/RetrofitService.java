package com.joina.joinaonline.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitService {
//    public static String BASE_URL = "http://165.22.126.3:4100/api/v1/";
public static String BASE_URL = "http://192.168.0.101:8080/api/";
    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);

    }
}
