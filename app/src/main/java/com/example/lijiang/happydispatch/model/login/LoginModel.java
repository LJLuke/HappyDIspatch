package com.example.lijiang.happydispatch.model.login;

import com.example.lijiang.happydispatch.entity.User;
import com.example.lijiang.happydispatch.network.RequestManager;
import com.example.lijiang.happydispatch.network.RetrofitService;

import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by lijiang on 2018/3/12.
 */

public class LoginModel implements ILoginModel{
    private RetrofitService mRetrofitService;

    @Override
    public void login(String phoneNumber, String password, Subscriber<User> userSubscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.login(phoneNumber,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userSubscriber);
    }
}
