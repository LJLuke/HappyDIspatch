package com.example.lijiang.happydispatch.model.homePage.search;

import android.util.Log;

import com.example.lijiang.happydispatch.entity.Store;
import com.example.lijiang.happydispatch.network.ApiWrapper;
import com.example.lijiang.happydispatch.network.RequestManager;
import com.example.lijiang.happydispatch.network.RetrofitService;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lijiang on 2018/2/24.
 */

public class StoreSearchFModel implements IStoreSearchFModel {
    private RetrofitService mRetrofitService;
    @Override
    public void getStoreHot(String key, int distance1, int distance2, Subscriber<List<Store>> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.getStoreHot(key,distance1,distance2)
                .map(new Func1<ApiWrapper<List<Store>>, List<Store>>() {
                    @Override
                    public List<Store> call(ApiWrapper<List<Store>> listApiWrapper) {
                        Log.d("distance",listApiWrapper.getData().size()+"hhh");
                        return listApiWrapper.getData();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getStoreDistance(int distance1, int distance2, Subscriber<List<Store>> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.getStoreDistance(distance1,distance2)
                .map(new Func1<ApiWrapper<List<Store>>, List<Store>>() {
                    @Override
                    public List<Store> call(ApiWrapper<List<Store>> listApiWrapper) {
                        return listApiWrapper.getData();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
