package com.example.lijiang.happydispatch.ui.fragment.homePage.search;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.Commodity;

import java.util.List;

/**
 * Created by lijiang on 2018/2/22.
 */

public interface IComSearchFView extends IBaseView {
    void onGetCommodityAll(List<Commodity> list);
    void onGetCommodityHot(List<Commodity> list);
    void onGetCommodityDiscount(List<Commodity> list);
    void onGetCommodityFilter(List<Commodity> list);
}
