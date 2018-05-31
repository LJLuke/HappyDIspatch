package com.example.lijiang.happydispatch.ui.fragment.shopBus;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.ShopBus;

import java.util.List;

/**
 * Created by lijiang on 2018/2/27.
 */

public interface IShopBusFView extends IBaseView {
    void onGetShopBus(List<ShopBus> list);
    void onDeleteShopBus(int status);
}
