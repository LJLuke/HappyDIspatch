package com.example.lijiang.happydispatch.presenter.homePage.search;

import android.content.Context;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.model.homePage.search.ISearchModel;
import com.example.lijiang.happydispatch.model.homePage.search.SearchModel;
import com.example.lijiang.happydispatch.ui.activity.homePage.search.ISearchView;

/**
 * Created by lijiang on 2018/2/18.
 */

public class SearchPresenter extends BasePresenter<ISearchView> {
    private Context mContext;
    private ISearchModel mSearchModel;

    public SearchPresenter(Context context){
        this.mContext = context;
        mSearchModel = new SearchModel(context);
    }
    @Override
    public void attachView(ISearchView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void getHistoricRecord(){
        getMvpView().getHistoricRecord(mSearchModel.getHistoricRecord());
    }

    public void saveRecord(String name){
        mSearchModel.saveRecord(name);
    }
    public void deleteRecord(){
        mSearchModel.deleteRecord();
    }
}
