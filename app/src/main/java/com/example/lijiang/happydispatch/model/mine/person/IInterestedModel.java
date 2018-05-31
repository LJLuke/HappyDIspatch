package com.example.lijiang.happydispatch.model.mine.person;

import com.example.lijiang.happydispatch.entity.Store;

import java.util.List;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/3/25.
 */

public interface IInterestedModel {
    void getCollection(int uID, Subscriber<List<Store>> subscriber);
}
