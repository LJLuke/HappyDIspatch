package com.example.lijiang.happydispatch.model.homePage.store;

import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.entity.Store;
import com.example.lijiang.happydispatch.entity.StoreDetail;

import java.util.List;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/2/25.
 */

public interface IStoreDetailModel {
    void getStoreDetail(int sID, Subscriber<StoreDetail> subscriber);
}
