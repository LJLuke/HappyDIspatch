package com.example.lijiang.happydispatch.presenter.classify;

import android.nfc.NfcEvent;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.model.classify.ClassifyRightModel;
import com.example.lijiang.happydispatch.model.classify.IClassifyRightModel;
import com.example.lijiang.happydispatch.ui.fragment.classify.IClassifyFView;

/**
 * Created by lijiang on 2018/2/27.
 */

public class ClassifyPresenter extends BasePresenter<IClassifyFView>{

    private IClassifyRightModel mModel;
    public ClassifyPresenter(){
        mModel = new ClassifyRightModel();
    }

    public void getClassifyRightList(){
        getMvpView().getClassifyRightList(mModel.getClassifyRightList());
    }
}
