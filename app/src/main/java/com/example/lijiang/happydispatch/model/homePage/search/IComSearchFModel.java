package com.example.lijiang.happydispatch.model.homePage.search;

import com.example.lijiang.happydispatch.entity.Commodity;

import java.util.List;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/2/24.
 */

public interface IComSearchFModel {
    void getCommodityAll(String key, Subscriber<List<Commodity>> subscriber);
    void getCommodityHot(String key, Subscriber<List<Commodity>> subscriber);
    void getCommodityDiscount(String key, Subscriber<List<Commodity>> subscriber);
    void getCommodityFilter(String tag,int low,int high,Subscriber<List<Commodity>> subscriber);
}
