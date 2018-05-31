package com.example.lijiang.happydispatch.ui.activity.homePage.store;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.entity.StoreDetail;

import java.util.List;

/**
 * Created by lijiang on 2018/2/25.
 */

public interface IStoreDetailView extends IBaseView {
    void onGetStoreDetail(StoreDetail storeDetail);

}
