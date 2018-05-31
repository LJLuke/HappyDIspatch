package com.example.lijiang.happydispatch.presenter.shopBus;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.entity.ShopBus;
import com.example.lijiang.happydispatch.model.shopBus.IShopBusModel;
import com.example.lijiang.happydispatch.model.shopBus.ShopBusModel;
import com.example.lijiang.happydispatch.ui.fragment.shopBus.IShopBusFView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/2/27.
 */

public class ShopBusFPresenter extends BasePresenter<IShopBusFView> {
    private IShopBusModel mModel;
    public ShopBusFPresenter(){
        mModel = new ShopBusModel();
    }
    public void getShopBusList(int uID){
        getMvpView().showLoadingDialog();
        mModel.getShopBus(uID, new Subscriber<List<ShopBus>>() {
            @Override
            public void onCompleted() {
                getMvpView().cancelLoadingDialog();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showErrorMsg("");
            }

            @Override
            public void onNext(List<ShopBus> list) {
                getMvpView().onGetShopBus(list);
            }
        });
    }
}
