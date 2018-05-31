package com.example.lijiang.happydispatch.presenter.homePage;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.model.homePage.ITodayPreferModel;
import com.example.lijiang.happydispatch.model.homePage.TodayPreferModel;
import com.example.lijiang.happydispatch.ui.activity.homePage.ITodayPreferView;

/**
 * Created by lijiang on 2018/2/26.
 */

public class TodayPreferPresenter extends BasePresenter<ITodayPreferView> {
    private ITodayPreferModel mITodayPreferModel;

    public TodayPreferPresenter(){
        mITodayPreferModel = new TodayPreferModel();
    }

    public void getTodayPreferList(){
        getMvpView().getTodayPreferList(mITodayPreferModel.getTodayPreferList());
    }
}
