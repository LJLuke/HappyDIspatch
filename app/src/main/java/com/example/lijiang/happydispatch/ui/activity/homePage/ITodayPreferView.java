package com.example.lijiang.happydispatch.ui.activity.homePage;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.Commodity;

import java.util.List;

/**
 * Created by lijiang on 2018/2/26.
 */

public interface ITodayPreferView extends IBaseView {
    void getTodayPreferList(List<Commodity> list);
}
