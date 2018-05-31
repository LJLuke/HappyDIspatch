package com.example.lijiang.happydispatch.ui.fragment.homePage.search;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.Store;

import java.util.List;

/**
 * Created by lijiang on 2018/2/24.
 */

public interface IStoreSearchFView extends IBaseView{
    void onGetStoreHot(List<Store> list);
    void onGetStoreDistance(List<Store> list);
}
