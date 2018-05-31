package com.example.lijiang.happydispatch.presenter.homePage.search;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.entity.Store;
import com.example.lijiang.happydispatch.model.homePage.search.IStoreSearchFModel;
import com.example.lijiang.happydispatch.model.homePage.search.StoreSearchFModel;
import com.example.lijiang.happydispatch.ui.fragment.homePage.search.IStoreSearchFView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/2/24.
 */

public class StoreSearchFPresenter extends BasePresenter<IStoreSearchFView> {
    private IStoreSearchFModel mModle;
    public StoreSearchFPresenter(){
        mModle = new StoreSearchFModel();
    }
    public void getStoreHot(String key,int distance1,int distance2){
        getMvpView().showLoadingDialog();
        mModle.getStoreHot(key, distance1, distance2, new Subscriber<List<Store>>() {
            @Override
            public void onCompleted() {
                getMvpView().cancelLoadingDialog();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showErrorMsg("");
            }

            @Override
            public void onNext(List<Store> list) {
                getMvpView().onGetStoreHot(list);
            }
        });
    }
    public void getStoreDistance(int distance1,int distance2){
        getMvpView().showLoadingDialog();
        mModle.getStoreDistance(distance1, distance2, new Subscriber<List<Store>>() {
            @Override
            public void onCompleted() {
                getMvpView().cancelLoadingDialog();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showErrorMsg("");
            }

            @Override
            public void onNext(List<Store> list) {
                getMvpView().onGetStoreDistance(list);
            }
        });
    }
}
