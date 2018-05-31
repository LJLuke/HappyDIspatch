package com.example.lijiang.happydispatch.model.mine.person;

import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.network.ApiWrapper;


import rx.Subscriber;

/**
 * Created by lijiang on 2018/3/14.
 */

public interface IEditPersonModel {
    void updateImage(String path, Subscriber<ApiWrapper> subscriber);
    void updateMessage(int id,String userName,String nickName,String phone,Subscriber<ApiWrapper> subscriber);
    void getCommodity(int id, Subscriber<Commodity> subscriber);
}
