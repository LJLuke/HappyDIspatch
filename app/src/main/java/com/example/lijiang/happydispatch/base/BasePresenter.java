package com.example.lijiang.happydispatch.base;

/**
 * Created by lijiang on 2018/2/18.
 */

public class BasePresenter <T extends IBaseView> implements IBasePresenter<T> {
    private T mMvpView;
    @Override
    public void attachView(T mvpView) {
        this.mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        this.mMvpView = null;
    }

    public T getMvpView(){
        return mMvpView;
    }
}
