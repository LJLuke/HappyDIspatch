package com.example.lijiang.happydispatch.model.shopBus;

import com.example.lijiang.happydispatch.entity.ShopBus;
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
 * Created by lijiang on 2018/2/27.
 */

public class ShopBusModel implements IShopBusModel{
    private RetrofitService mRetrofitService;
    @Override
    public void getShopBus(int uID, Subscriber<List<ShopBus>> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.getShopBus(uID)
                .map(new Func1<ApiWrapper<List<ShopBus>>, List<ShopBus>>() {
                    @Override
                    public List<ShopBus> call(ApiWrapper<List<ShopBus>> listApiWrapper) {
                        return listApiWrapper.getData();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
