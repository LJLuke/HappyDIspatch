package com.example.lijiang.happydispatch.presenter.homePage.search;

import android.content.Context;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.model.homePage.search.ComSearchFModel;
import com.example.lijiang.happydispatch.model.homePage.search.IComSearchFModel;
import com.example.lijiang.happydispatch.ui.fragment.homePage.search.IComSearchFView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/2/24.
 */

public class ComSearchFPresenter extends BasePresenter<IComSearchFView> {
    private Context mContext;
    private IComSearchFModel mIComSearchFModel;

    public ComSearchFPresenter(Context context){
        this.mContext = context;
        mIComSearchFModel = new ComSearchFModel();
    }

    @Override
    public void attachView(IComSearchFView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }
    public void getCommodityAll(String key){
        getMvpView().showLoadingDialog();
       mIComSearchFModel.getCommodityAll(key, new Subscriber<List<Commodity>>() {
           @Override
           public void onCompleted() {
               getMvpView().cancelLoadingDialog();
           }

           @Override
           public void onError(Throwable e) {
               getMvpView().showErrorMsg("");
           }

           @Override
           public void onNext(List<Commodity> list) {
               getMvpView().onGetCommodityAll(list);
           }
       });
    }
    public void getCommodityHot(String key){
        getMvpView().showLoadingDialog();
        mIComSearchFModel.getCommodityHot(key, new Subscriber<List<Commodity>>() {
            @Override
            public void onCompleted() {
                getMvpView().cancelLoadingDialog();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showErrorMsg("");
            }

            @Override
            public void onNext(List<Commodity> list) {
                getMvpView().onGetCommodityHot(list);
            }
        });
    }
    public void getCommodityDiscount(String key){
        getMvpView().showLoadingDialog();
        mIComSearchFModel.getCommodityDiscount(key, new Subscriber<List<Commodity>>() {
            @Override
            public void onCompleted() {
                getMvpView().cancelLoadingDialog();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showErrorMsg("");
            }

            @Override
            public void onNext(List<Commodity> list) {
                getMvpView().onGetCommodityDiscount(list);
            }
        });
    }
    public void getCommodityFilter(String tag,int low,int high){
        getMvpView().showLoadingDialog();
        mIComSearchFModel.getCommodityFilter(tag, low, high, new Subscriber<List<Commodity>>() {
            @Override
            public void onCompleted() {
                getMvpView().cancelLoadingDialog();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showErrorMsg("");
            }

            @Override
            public void onNext(List<Commodity> list) {
                getMvpView().onGetCommodityFilter(list);
            }
        });
    }
}
