package com.example.lijiang.happydispatch.base;

/**
 * Created by lijiang on 2018/2/18.
 */

public interface IBasePresenter<V extends IBaseView> {
    void attachView(V mvpView);
    void detachView();
}
