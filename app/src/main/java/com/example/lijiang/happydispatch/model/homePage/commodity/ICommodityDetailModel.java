package com.example.lijiang.happydispatch.model.homePage.commodity;

import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.network.ApiWrapper;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/3/16.
 */

public interface ICommodityDetailModel {
    void getCommodityDetail(int id, Subscriber<Commodity> subscriber);
    void addShopBus(int uID,int gID,int count,Subscriber<ApiWrapper> subscriber);
}
