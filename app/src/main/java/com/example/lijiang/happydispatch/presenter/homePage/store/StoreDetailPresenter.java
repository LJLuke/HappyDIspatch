package com.example.lijiang.happydispatch.presenter.homePage.store;

import android.util.Log;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.entity.StoreDetail;
import com.example.lijiang.happydispatch.model.homePage.store.IStoreDetailModel;
import com.example.lijiang.happydispatch.model.homePage.store.StoreDetailModel;
import com.example.lijiang.happydispatch.ui.activity.homePage.store.IStoreDetailView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/2/25.
 */

public class StoreDetailPresenter extends BasePresenter<IStoreDetailView> {
    private IStoreDetailModel mIStoreDetailModel;
    public StoreDetailPresenter(){
        mIStoreDetailModel = new StoreDetailModel();
    }
    public void getStoreDetail(int sID){
        getMvpView().showLoadingDialog();
        mIStoreDetailModel.getStoreDetail(sID, new Subscriber<StoreDetail>() {
            @Override
            public void onCompleted() {
                getMvpView().cancelLoadingDialog();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showErrorMsg("");
            }

            @Override
            public void onNext(StoreDetail storeDetail) {
                getMvpView().onGetStoreDetail(storeDetail);
            }
        });
    }
}
