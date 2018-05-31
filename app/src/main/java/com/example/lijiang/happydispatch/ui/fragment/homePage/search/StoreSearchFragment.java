package com.example.lijiang.happydispatch.ui.fragment.homePage.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.recyclerview.ShopBusRvAdapter;
import com.example.lijiang.happydispatch.adapter.recyclerview.StoreRvAdapter;
import com.example.lijiang.happydispatch.base.BaseFragment;
import com.example.lijiang.happydispatch.entity.Store;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.presenter.homePage.search.StoreSearchFPresenter;
import com.example.lijiang.happydispatch.ui.activity.homePage.store.StoreDetailActivity;
import com.example.lijiang.happydispatch.util.NormalUtil;
import com.xiasuhuei321.loadingdialog.manager.StyleManager;
import com.xiasuhuei321.loadingdialog.view.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiang on 2018/2/24.
 */

public class StoreSearchFragment extends BaseFragment implements IStoreSearchFView,View.OnClickListener {

    private List<Store> mStoreList = new ArrayList<>();
    private String mSearchKey;

    private LoadingDialog mLoadingDialog;
    private RecyclerView mShopRv;
    private StoreRvAdapter mStoreRvAdapter;

    private StoreSearchFPresenter mPresenter;

    private TextView mDistanceText;
    private TextView mHeatText;


    @Override
    public void showLoadingDialog() {
        mLoadingDialog = new LoadingDialog(mActivity);
        mLoadingDialog.setInterceptBack(true)
                .show();
    }

    @Override
    public void cancelLoadingDialog() {
        mLoadingDialog.close();
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        mLoadingDialog.close();
        NormalUtil.toast(mActivity,"加载失败");
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_shop_search;
    }

    @Override
    public void initView() {
        StyleManager s = new StyleManager();
        s.Anim(false).repeatTime(0).contentSize(-1).intercept(true);
        LoadingDialog.initStyle(s);

        mShopRv = mView.findViewById(R.id.shop_rv);

        mDistanceText = mView.findViewById(R.id.distance);
        mHeatText = mView.findViewById(R.id.heat);

        mDistanceText.setOnClickListener(this);
        mHeatText.setOnClickListener(this);

        mPresenter = new StoreSearchFPresenter();
        mPresenter.attachView(this);

    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        mSearchKey = bundle.getString("key");
        LinearLayoutManager mShopManager = new LinearLayoutManager(mActivity);
        mShopRv.setLayoutManager(mShopManager);
        mStoreRvAdapter = new StoreRvAdapter(mActivity, mStoreList, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {
                Intent intent = new Intent(mActivity,StoreDetailActivity.class);
                intent.putExtra("sID",mStoreList.get(position).getSId());
                startActivity(intent);
            }
        });
        mShopRv.setAdapter(mStoreRvAdapter);
        mPresenter.getStoreDistance(0,0);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.distance:
                mDistanceText.setTextColor(getResources().getColor(R.color.blue));
                mHeatText.setTextColor(getResources().getColor(R.color.gray));
                mPresenter.getStoreDistance(0,0);
                break;
            case R.id.heat:
                mDistanceText.setTextColor(getResources().getColor(R.color.gray));
                mHeatText.setTextColor(getResources().getColor(R.color.blue));
                mPresenter.getStoreHot("",0,0);
                break;
        }
    }

    @Override
    public void onGetStoreHot(List<Store> list) {
        mStoreList.clear();
        mStoreList.addAll(list);
        mStoreRvAdapter.addList(mStoreList);
    }

    @Override
    public void onGetStoreDistance(List<Store> list) {
        mStoreList.clear();
        mStoreList.addAll(list);
        mStoreRvAdapter.addList(mStoreList);
    }
}
