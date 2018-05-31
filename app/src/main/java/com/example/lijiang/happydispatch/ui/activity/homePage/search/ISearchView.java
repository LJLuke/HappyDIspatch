package com.example.lijiang.happydispatch.ui.activity.homePage.search;

import com.example.lijiang.happydispatch.base.IBaseView;

import java.util.List;

/**
 * Created by lijiang on 2018/2/18.
 */

public interface ISearchView extends IBaseView{
    void getGuessLike(List<String> list);
    void getHistoricRecord(List<String> list);
}
