package com.example.lijiang.happydispatch.model.homePage.search;

import com.example.lijiang.happydispatch.entity.Store;

import java.util.List;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/2/24.
 */

public interface IStoreSearchFModel {
    void getStoreHot(String key, int distance1, int distance2, Subscriber<List<Store>> subscriber);
    void getStoreDistance(int distance1, int distance2, Subscriber<List<Store>> subscriber);

}
