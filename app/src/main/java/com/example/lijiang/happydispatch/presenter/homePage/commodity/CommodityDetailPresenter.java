package com.example.lijiang.happydispatch.presenter.homePage.commodity;

import android.util.Log;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.base.IBasePresenter;
import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.model.homePage.commodity.CommodityDetailModel;
import com.example.lijiang.happydispatch.model.homePage.commodity.ICommodityDetailModel;
import com.example.lijiang.happydispatch.network.ApiWrapper;
import com.example.lijiang.happydispatch.ui.activity.homePage.commodity.IComDetailView;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/3/16.
 */

public class CommodityDetailPresenter extends BasePresenter<IComDetailView> {
    private ICommodityDetailModel mModel;
    public CommodityDetailPresenter(){
        mModel = new CommodityDetailModel();
    }
    public void getCommodityDetail(int id){
        mModel.getCommodityDetail(id, new Subscriber<Commodity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Commodity commodity) {
                getMvpView().onCommodityDetail(commodity);
            }

        });
    }
    public void addShopBus(int uID,int gID,int count){
        mModel.addShopBus(uID, gID, count, new Subscriber<ApiWrapper>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ApiWrapper apiWrapper) {
                getMvpView().onAddShopBus(apiWrapper.status);
            }
        });
    }
}
