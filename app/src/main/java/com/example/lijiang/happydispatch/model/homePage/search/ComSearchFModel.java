package com.example.lijiang.happydispatch.model.homePage.search;

import android.util.Log;

import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.network.ApiWrapper;
import com.example.lijiang.happydispatch.network.RequestManager;
import com.example.lijiang.happydispatch.network.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lijiang on 2018/2/24.
 */

public class ComSearchFModel implements IComSearchFModel {
    private RetrofitService mRetrofitService;
    @Override
    public void getCommodityAll(String key, Subscriber<List<Commodity>> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.getCommodityAll(key)
                .map(new Func1<ApiWrapper<List<Commodity>>, List<Commodity>>() {
                    @Override
                    public List<Commodity> call(ApiWrapper<List<Commodity>> listApiWrapper) {
                        Log.d("hhhh",listApiWrapper.getMessage()+listApiWrapper.getData().get(0).getIntroduce());
                        return listApiWrapper.getData();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getCommodityHot(String key, Subscriber<List<Commodity>> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.getCommodityHot(key)
                .map(new Func1<ApiWrapper<List<Commodity>>, List<Commodity>>() {
                    @Override
                    public List<Commodity> call(ApiWrapper<List<Commodity>> listApiWrapper) {
                        Log.d("hhhh",listApiWrapper.getMessage()+listApiWrapper.getData().get(0).getIntroduce());
                        return listApiWrapper.getData();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getCommodityDiscount(String key, Subscriber<List<Commodity>> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.getCommodityDiscount(key)
                .map(new Func1<ApiWrapper<List<Commodity>>, List<Commodity>>() {
                    @Override
                    public List<Commodity> call(ApiWrapper<List<Commodity>> listApiWrapper) {
                        Log.d("hhhh",listApiWrapper.getMessage()+listApiWrapper.getData().get(0).getIntroduce());
                        return listApiWrapper.getData();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getCommodityFilter(String tag, int low, int high, Subscriber<List<Commodity>> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.getCommodityFilter(tag,low,high)
                .map(new Func1<ApiWrapper<List<Commodity>>, List<Commodity>>() {
                    @Override
                    public List<Commodity> call(ApiWrapper<List<Commodity>> listApiWrapper) {
                        return listApiWrapper.getData();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
