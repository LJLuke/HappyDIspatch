package com.example.lijiang.happydispatch.ui.activity.mine.person;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.AddressManage;

import java.util.List;

/**
 * Created by lijiang on 2018/3/9.
 */

public interface IAddressManageView extends IBaseView {
    void getAddressList(List<AddressManage> list);
}
