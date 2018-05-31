package com.example.lijiang.happydispatch.presenter.mine.person;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.model.mine.person.AddressManageModel;
import com.example.lijiang.happydispatch.model.mine.person.IAddressManageModel;
import com.example.lijiang.happydispatch.ui.activity.mine.person.IAddressManageView;

/**
 * Created by lijiang on 2018/3/9.
 */

public class AddressManagePresenter extends BasePresenter<IAddressManageView>{
    private IAddressManageModel mModel;
    public AddressManagePresenter(){
        mModel = new AddressManageModel();
    }
    public void getAddressList(){
        getMvpView().getAddressList(mModel.getAddressList());
    }
}
