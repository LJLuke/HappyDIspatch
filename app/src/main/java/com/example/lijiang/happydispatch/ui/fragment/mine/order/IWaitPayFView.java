package com.example.lijiang.happydispatch.ui.fragment.mine.order;

import android.support.v4.view.ViewPager;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.Order;
import com.example.lijiang.happydispatch.entity.ShopBus;

import java.util.List;

/**
 * Created by lijiang on 2018/3/11.
 */

public interface IWaitPayFView extends IBaseView {
    void getWaitPayList(List<Order> list);
}
