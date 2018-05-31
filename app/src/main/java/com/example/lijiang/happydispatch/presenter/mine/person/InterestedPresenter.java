package com.example.lijiang.happydispatch.presenter.mine.person;

import com.example.lijiang.happydispatch.base.BaseFragment;
import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.entity.Store;
import com.example.lijiang.happydispatch.model.mine.person.IInterestedModel;
import com.example.lijiang.happydispatch.model.mine.person.InterestedModel;
import com.example.lijiang.happydispatch.ui.activity.mine.person.IInterestedView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/3/25.
 */

public class InterestedPresenter extends BasePresenter<IInterestedView>{
    private IInterestedModel mModel;
    public InterestedPresenter(){
        mModel = new InterestedModel();
    }
    public void getCollection(int uID){
        getMvpView().showLoadingDialog();
        mModel.getCollection(uID, new Subscriber<List<Store>>() {
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
                getMvpView().onGetCollection(list);
            }
        });
    }
}
