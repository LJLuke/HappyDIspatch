package com.example.lijiang.happydispatch.presenter.homePage;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.model.homePage.GuessLikeModel;
import com.example.lijiang.happydispatch.model.homePage.IGuessLikeModel;
import com.example.lijiang.happydispatch.ui.activity.homePage.IGuessLikeView;

/**
 * Created by lijiang on 2018/2/26.
 */

public class GuessLikePresenter extends BasePresenter<IGuessLikeView> {
    private IGuessLikeModel mIGuessLikeModel;

    public GuessLikePresenter(){
        mIGuessLikeModel = new GuessLikeModel();
    }
    public void getGuessLikeList(){
        getMvpView().getGuessLikeList(mIGuessLikeModel.getGuessLikeList());
    }
}
