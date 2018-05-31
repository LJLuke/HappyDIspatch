package com.example.lijiang.happydispatch.ui.fragment.shopBus;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.recyclerview.ShopBusRvAdapter;
import com.example.lijiang.happydispatch.base.BaseFragment;
import com.example.lijiang.happydispatch.entity.ShopBus;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.presenter.shopBus.ShopBusFPresenter;
import com.example.lijiang.happydispatch.sharePreferences.SpHelper;
import com.example.lijiang.happydispatch.ui.activity.login.LoginActivity;
import com.example.lijiang.happydispatch.ui.activity.shopBus.CloseAccountActivity;
import com.example.lijiang.happydispatch.ui.diyView.LineItemDecoration;
import com.example.lijiang.happydispatch.ui.diyView.SmoothCheckBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiang on 2018/2/27.
 */

public class ShopBusFragment extends BaseFragment implements IShopBusFView,View.OnClickListener{

    private ShopBusFPresenter mPresenter;
    private SpHelper mSpHelper;
    private ShopBusRvAdapter mShopBusRvAdapter;
    private List<ShopBus> mShopBusList = new ArrayList<>();
    private RecyclerView mShopBusRv;
    private SmoothCheckBox mCheckBox;

    private TextView mManageText;

    private TextView mCloseAccount;
    private TextView mTotalPrice;
    private TextView mTotalPriceText;

    private boolean isChecked = true;
    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void cancelLoadingDialog() {

    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_shop_bus;
    }

    @Override
    public void initView() {
        mPresenter = new ShopBusFPresenter();
        mPresenter.attachView(this);
        mSpHelper = new SpHelper(mActivity,"user");

        mShopBusRv = mView.findViewById(R.id.shop_bus_rv);
        LinearLayoutManager mShopBusMg = new LinearLayoutManager(mActivity);
        mShopBusRv.setLayoutManager(mShopBusMg);
        mShopBusRv.addItemDecoration(new LineItemDecoration());
        mShopBusRvAdapter = new ShopBusRvAdapter(mActivity, mShopBusList, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {

            }
        });
        mShopBusRv.setAdapter(mShopBusRvAdapter);

        mCheckBox = mView.findViewById(R.id.checkbox);
        mCheckBox.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox smoothCheckBox, boolean isChecked) {
                if (isChecked){
                    mShopBusRvAdapter.setCheckedBox(true);
                    mShopBusRvAdapter.notifyDataSetChanged();
                }else {
                    mShopBusRvAdapter.setCheckedBox(false);
                    mShopBusRvAdapter.notifyDataSetChanged();
                }
            }
        });
        mManageText = mView.findViewById(R.id.manage_text);
        mCloseAccount = mView.findViewById(R.id.close_account);
        mTotalPrice = mView.findViewById(R.id.total_price);
        mTotalPriceText = mView.findViewById(R.id.total_price_text);

        mManageText.setOnClickListener(this);
        mCloseAccount.setOnClickListener(this);
    }

    @Override
    public void initData() {
        mPresenter.getShopBusList(mSpHelper.getInt("userId"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.manage_text:
                if (isChecked){
                    mManageText.setBackground(getResources().getDrawable(R.drawable.shape_label));
                    mManageText.setTextColor(getResources().getColor(R.color.white));
                    mCloseAccount.setText("删除");
                    mTotalPrice.setVisibility(View.INVISIBLE);
                    mTotalPriceText.setVisibility(View.INVISIBLE);
                    isChecked = false;
                }else {
                    mManageText.setBackgroundResource(R.color.bgcolor);
                    mManageText.setTextColor(getResources().getColor(R.color.blue));
                    mCloseAccount.setText("结算");
                    mTotalPrice.setVisibility(View.VISIBLE);
                    mTotalPriceText.setVisibility(View.VISIBLE);
                    isChecked = true;
                }

                break;
            case R.id.close_account:
                startActivity(new Intent(mActivity, LoginActivity.class));
        }
    }

    @Override
    public void onGetShopBus(List<ShopBus> list) {
        mShopBusList.clear();
        mShopBusList.addAll(list);
        mShopBusRvAdapter.addList(mShopBusList);
    }

    @Override
    public void onDeleteShopBus(int status) {

    }
}
