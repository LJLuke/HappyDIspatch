package com.example.lijiang.happydispatch.presenter.homePage.commodity;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.model.homePage.commodity.CommentModel;
import com.example.lijiang.happydispatch.model.homePage.commodity.ICommentModel;
import com.example.lijiang.happydispatch.ui.activity.homePage.commodity.ICommentView;

/**
 * Created by lijiang on 2018/2/25.
 */

public class CommentPresenter extends BasePresenter<ICommentView>{
    private ICommentModel mICommentModel;
    public CommentPresenter(){
        mICommentModel = new CommentModel();
    }

    public void getCommentList(){
        getMvpView().getCommentList(mICommentModel.getCommentList());
    }
}
