package com.example.lijiang.happydispatch.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lijiang on 2018/3/8.
 */

public class RequestManager {
    public static final String BASE_URL = "http://lkkbit.6655.la:36861/";
    private static final int TIMEOUT = 10;
    private Retrofit mRetrofit;
    private RetrofitService mService;
    private static RequestManager sRequestManager;

    private RequestManager(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mService = mRetrofit.create(RetrofitService.class);



    }
    public static RequestManager getInstance(){
        if (sRequestManager == null){
            synchronized (RequestManager.class){
                if (sRequestManager == null){
                    sRequestManager = new RequestManager();
                }
            }
        }
        return sRequestManager;
    }
    public RetrofitService getService(){
        return mService;
    }
}
