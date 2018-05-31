package com.example.lijiang.happydispatch.model.homePage.commodity;

import android.util.Log;

import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.network.ApiWrapper;
import com.example.lijiang.happydispatch.network.RequestManager;
import com.example.lijiang.happydispatch.network.RetrofitService;

import okhttp3.RequestBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lijiang on 2018/3/16.
 */

public class CommodityDetailModel implements ICommodityDetailModel{
    private RetrofitService mRetrofitService;

    @Override
    public void getCommodityDetail(int id, Subscriber<Commodity> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.getCommodityDetail(id)
                .map(new Func1<ApiWrapper<Commodity>, Commodity>() {
                    @Override
                    public Commodity call(ApiWrapper<Commodity> commodityApiWrapper) {
                        Log.d("hahaha",commodityApiWrapper.getMessage());
                        return commodityApiWrapper.getData();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    @Override
    public void addShopBus(int uID, int gID, int count, Subscriber<ApiWrapper> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.addShopBus(uID, gID, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
