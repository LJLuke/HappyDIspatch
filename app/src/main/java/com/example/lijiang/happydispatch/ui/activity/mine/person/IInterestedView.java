package com.example.lijiang.happydispatch.ui.activity.mine.person;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.Store;

import java.util.List;

/**
 * Created by lijiang on 2018/3/25.
 */

public interface IInterestedView extends IBaseView{
    void onGetCollection(List<Store> list);
}
