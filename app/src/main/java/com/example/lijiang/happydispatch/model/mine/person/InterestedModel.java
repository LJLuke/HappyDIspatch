package com.example.lijiang.happydispatch.model.mine.person;

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
 * Created by lijiang on 2018/3/25.
 */

public class InterestedModel implements IInterestedModel{
    private RetrofitService mRetrofitService;
    @Override
    public void getCollection(int uID, Subscriber<List<Store>> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.getCollection(uID)
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
