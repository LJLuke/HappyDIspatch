package com.example.lijiang.happydispatch.model.mine.person;

import com.example.lijiang.happydispatch.entity.AddressManage;
import com.example.lijiang.happydispatch.ui.activity.mine.person.IAddressManageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiang on 2018/3/9.
 */

public class AddressManageModel implements IAddressManageModel{
    @Override
    public List<AddressManage> getAddressList() {
        List<AddressManage> list = new ArrayList<>();
        for (int i = 0;i < 10;i++){
            list.add(new AddressManage());
        }
        return list;
    }
}
