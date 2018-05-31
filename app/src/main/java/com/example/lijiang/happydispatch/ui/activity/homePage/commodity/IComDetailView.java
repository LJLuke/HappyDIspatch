package com.example.lijiang.happydispatch.ui.activity.homePage.commodity;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.Commodity;

/**
 * Created by lijiang on 2018/2/25.
 */

public interface IComDetailView extends IBaseView {
    void onCommodityDetail(Commodity commodity);
    void onAddShopBus(int status);
}
