package com.example.lijiang.happydispatch.ui.fragment.homePage.search;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.recyclerview.CommodityRvAdapter;
import com.example.lijiang.happydispatch.adapter.recyclerview.SortTabRvAdapter;
import com.example.lijiang.happydispatch.adapter.viewpager.ComSearchAdapter;
import com.example.lijiang.happydispatch.base.BaseFragment;
import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.presenter.homePage.search.ComSearchFPresenter;
import com.example.lijiang.happydispatch.ui.activity.homePage.commodity.CommodityDetailActivity;
import com.example.lijiang.happydispatch.ui.activity.homePage.search.CommoditySearchActivity;
import com.example.lijiang.happydispatch.ui.activity.homePage.search.SearchActivity;
import com.example.lijiang.happydispatch.ui.diyView.FlowLayout;
import com.example.lijiang.happydispatch.ui.diyView.LineItemDecoration;
import com.example.lijiang.happydispatch.ui.diyView.MyPopuWindow;
import com.example.lijiang.happydispatch.util.NormalUtil;
import com.github.ikidou.fragmentBackHandler.FragmentBackHandler;
import com.xiasuhuei321.loadingdialog.manager.StyleManager;
import com.xiasuhuei321.loadingdialog.view.LoadingDialog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lijiang on 2018/2/22.
 */

public class ComSearchFragment extends BaseFragment implements IComSearchFView,View.OnClickListener{


    private String mSearchKey;
    private String mBrandText;

    private TextView mSortText;
    private ImageView mSortImage;

    private View mSortPopWindowView;

    private View mFilterPopuWindowView;

    private MyPopuWindow mSortPopupWindow;
    private PopupWindow mFilterPopuWindow;

    private LinearLayout mSortLayout;
    private TextView mPreferential;
    private LinearLayout mFilterLayout;

    private RecyclerView mSortTabRv;
    private RecyclerView mCommodityRv;
    private CommodityRvAdapter mCommodityRvAdapter;
    private View mDismissView;



    private FlowLayout mFlowLayout;

    private ComSearchFPresenter mPresenter;

    private List<String> mSortList = new ArrayList<>();
    private List<Commodity> mCommodityList = new ArrayList<>();
    private List<String> mBrandList = new ArrayList<>();

    private LoadingDialog mLoadingDialog;

    private EditText mLowPrice;
    private EditText mHighPrice;

    private Button mReset;
    private Button mComplete;
    @Override
    public void initView() {
        Bundle bundle = getArguments();
        mSearchKey = bundle.getString("key");

        StyleManager s = new StyleManager();
        s.Anim(false).repeatTime(0).contentSize(-1).intercept(true);
        LoadingDialog.initStyle(s);

        mPresenter = new ComSearchFPresenter(mActivity);
        mPresenter.attachView(this);

        mSortPopWindowView = getLayoutInflater().inflate(R.layout.popwindow_sort,null);
        mSortTabRv = mSortPopWindowView.findViewById(R.id.sort_tab_rv);
        mDismissView = mSortPopWindowView.findViewById(R.id.dismiss_view);
        mSortPopupWindow = new MyPopuWindow(mActivity);
        LinearLayoutManager mSortManager = new LinearLayoutManager(mActivity);
        mSortTabRv.addItemDecoration(new LineItemDecoration());
        mSortTabRv.setLayoutManager(mSortManager);

        mCommodityRv = mView.findViewById(R.id.commodity_rv);
        LinearLayoutManager mComRvManager = new LinearLayoutManager(mActivity);
        mCommodityRv.setLayoutManager(mComRvManager);
        mCommodityRv.addItemDecoration(new LineItemDecoration());
        mCommodityRvAdapter = new CommodityRvAdapter(mActivity, mCommodityList, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {
                Intent intent = new Intent(mActivity,CommodityDetailActivity.class);
                intent.putExtra("gID",mCommodityList.get(position).getGId());
                startActivity(intent);
            }
        });
        mCommodityRv.setAdapter(mCommodityRvAdapter);

        mFilterPopuWindowView = getLayoutInflater().inflate(R.layout.popu_window_filter,null);
        mFilterPopuWindow = new PopupWindow(mActivity);
        mFlowLayout = mFilterPopuWindowView.findViewById(R.id.grand_flow_layout);
        mLowPrice = mFilterPopuWindowView.findViewById(R.id.low_price);
        mHighPrice = mFilterPopuWindowView.findViewById(R.id.high_price);
        mReset = mFilterPopuWindowView.findViewById(R.id.reset);
        mComplete = mFilterPopuWindowView.findViewById(R.id.complete);

        mSortLayout = mView.findViewById(R.id.sort_tab);
        mPreferential = mView.findViewById(R.id.preferential);
        mFilterLayout = mView.findViewById(R.id.filter_layout);

        mSortText = mView.findViewById(R.id.sort_tab).findViewById(R.id.tab_name);
        mSortImage = mView.findViewById(R.id.sort_tab).findViewById(R.id.tab_icon);

        mPresenter.getCommodityAll(mSearchKey);
    }

    @Override
    public void initData() {
        mSortLayout.setOnClickListener(this);
        mPreferential.setOnClickListener(this);
        mFilterLayout.setOnClickListener(this);
        mDismissView.setOnClickListener(this);
        mReset.setOnClickListener(this);
        mComplete.setOnClickListener(this);

        mSortText.setText("综合排序");

        mSortPopupWindow.setContentView(mSortPopWindowView);
        mSortPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        mSortPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mSortPopupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        mSortPopupWindow.setOutsideTouchable(true);
        mSortPopupWindow.setFocusable(true);
        mSortPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setChecked(false,null,null);
            }
        });

        mFilterPopuWindow.setContentView(mFilterPopuWindowView);
        mFilterPopuWindow.setWidth(NormalUtil.getScreenWidth(mActivity) * 2/3);
        mFilterPopuWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        mFilterPopuWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        mFilterPopuWindow.setOutsideTouchable(true);
        mFilterPopuWindow.setFocusable(true);
    }

    @Override
    public void showLoadingDialog() {
        mLoadingDialog = new LoadingDialog(mActivity);
        mLoadingDialog.setSuccessText("加载成功")
                .setFailedText("加载失败")
                .setInterceptBack(true)
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
        return R.layout.fragment_commodity_search;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sort_tab:
                setChecked(true,mSortText,mSortImage);
                mSortPopupWindow.showAsDropDown(mSortLayout);
                mSortList.clear();
                mSortList.add("综合排序");
                mSortList.add("按距离排序");
                mSortList.add("按热度排序");
                SortTabRvAdapter mSortAdapter = new SortTabRvAdapter(mActivity, mSortList, new RvClickListener() {
                    @Override
                    public void onItemClick(int id, int position) {
                        if (position == 0){
                            mPresenter.getCommodityAll(mSearchKey);
                        }else if (position == 1){
                            mPresenter.getCommodityHot(mSearchKey);
                        }else {
                            mPresenter.getCommodityDiscount(mSearchKey);
                        }
                        mSortText.setText(mSortList.get(position));
                        mSortPopupWindow.dismiss();
                    }
                });
                mSortTabRv.setAdapter(mSortAdapter);
                break;
            case R.id.preferential:
                mPresenter.getCommodityDiscount(mSearchKey);
                break;
            case R.id.filter_layout:
                for (int i = 0;i < mCommodityList.size();i++){
                    mBrandList.add(mCommodityList.get(i).getTag());
                }
                mBrandList = new ArrayList<>(new HashSet<String>(mBrandList));
                setBrandList(mBrandList);
                mFilterPopuWindow.showAtLocation(mFilterPopuWindowView,Gravity.END,0,0);
                break;
            case R.id.dismiss_view:
                mSortPopupWindow.dismiss();
                break;
            case R.id.reset:
                break;
            case R.id.complete:
                mPresenter.getCommodityFilter(mBrandText,10,50);
                mFilterPopuWindow.dismiss();
                break;
        }
    }

    private void setChecked(boolean isChecked,TextView textView,ImageView imageView){
        if (isChecked){
            textView.setTextColor(Color.parseColor("#3FCFE4"));
            imageView.setImageResource(R.drawable.more_up_blue);
        }else {
            mSortText.setTextColor(Color.parseColor("#878787"));
            mSortImage.setImageResource(R.drawable.more_down_gray);
        }
    }

    private void setBrandList(List<String> list){
        for (int i = 0;i < list.size();i++){
            final TextView textView = new TextView(mActivity);
            textView.setText(list.get(i));
            textView.setTextSize(15);
            textView.setBackgroundResource(R.drawable.shape_label);
            textView.setTextColor(Color.parseColor("#ffffff"));
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mBrandText = textView.getText().toString();
                }
            });
            mFlowLayout.addView(textView);
        }
    }

    @Override
    public void onGetCommodityAll(List<Commodity> list) {
        if (list.size() != 0){
            mCommodityList.clear();
            mCommodityList.addAll(list);
            mCommodityRvAdapter.addList(mCommodityList);
        }
    }

    @Override
    public void onGetCommodityHot(List<Commodity> list) {
        if (list.size() != 0){
            mCommodityList.clear();
            mCommodityList.addAll(list);
            mCommodityRvAdapter.addList(mCommodityList);
        }
    }

    @Override
    public void onGetCommodityDiscount(List<Commodity> list) {
        if (list.size() != 0){
            mCommodityList.clear();
            mCommodityList.addAll(list);
            mCommodityRvAdapter.addList(mCommodityList);
        }
    }

    @Override
    public void onGetCommodityFilter(List<Commodity> list) {
        if (list.size() != 0){
            mCommodityList.clear();
            mCommodityList.addAll(list);
            mCommodityRvAdapter.addList(mCommodityList);
        }
    }

}
