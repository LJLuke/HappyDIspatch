package com.example.lijiang.happydispatch.model.login;

import com.example.lijiang.happydispatch.entity.User;

import rx.Subscriber;


/**
 * Created by lijiang on 2018/3/12.
 */

public interface ILoginModel {
    void login(String phoneNumber, String password, Subscriber<User> userSubscriber);
}
