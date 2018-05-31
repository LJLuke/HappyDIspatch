package com.example.lijiang.happydispatch.model.shopBus;

import com.example.lijiang.happydispatch.entity.ShopBus;

import java.util.List;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/2/27.
 */

public interface IShopBusModel {
    void getShopBus(int uID, Subscriber<List<ShopBus>> subscriber);
}
