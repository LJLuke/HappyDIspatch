package com.example.lijiang.happydispatch.model.homePage.store;
import com.example.lijiang.happydispatch.entity.StoreDetail;
import com.example.lijiang.happydispatch.network.ApiWrapper;
import com.example.lijiang.happydispatch.network.RequestManager;
import com.example.lijiang.happydispatch.network.RetrofitService;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lijiang on 2018/2/25.
 */

public class StoreDetailModel implements IStoreDetailModel {
    private RetrofitService mRetrofitService;
    @Override
    public void getStoreDetail(int sID, Subscriber<StoreDetail> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.getStoreDetail(sID)
                .map(new Func1<ApiWrapper<StoreDetail>, StoreDetail>() {
                    @Override
                    public StoreDetail call(ApiWrapper<StoreDetail> storeDetailApiWrapper) {
                        return storeDetailApiWrapper.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
