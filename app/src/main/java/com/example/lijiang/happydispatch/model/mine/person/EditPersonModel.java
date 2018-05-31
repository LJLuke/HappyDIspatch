package com.example.lijiang.happydispatch.model.mine.person;

import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.network.ApiWrapper;
import com.example.lijiang.happydispatch.network.RequestManager;
import com.example.lijiang.happydispatch.network.RetrofitService;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lijiang on 2018/3/14.
 */

public class EditPersonModel implements IEditPersonModel{
    private RetrofitService mRetrofitService;


    @Override
    public void updateImage(String path, Subscriber<ApiWrapper> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        RequestBody body = RequestBody.create(
                MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW"),
                new File(path));
        mRetrofitService.updateImage(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void updateMessage(int id,String userName, String nickName, String phone, Subscriber<ApiWrapper> subscriber) {
        mRetrofitService = RequestManager.getInstance().getService();
        mRetrofitService.updateMessage(id,userName,nickName,phone)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getCommodity(int id, Subscriber<Commodity> subscriber) {

    }
}
