package com.example.lijiang.happydispatch.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * Created by lijiang on 2018/2/12.
 */

public abstract class BaseFragment extends Fragment implements IBaseFragment{
    protected View mView;
    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null){
            mView = inflater.inflate(bindLayout(),container,false);
        }
        initView();
        initData();
        return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
