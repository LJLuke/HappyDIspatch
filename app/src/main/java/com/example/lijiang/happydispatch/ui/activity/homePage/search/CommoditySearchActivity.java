package com.example.lijiang.happydispatch.ui.activity.homePage.search;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.viewpager.ComSearchAdapter;
import com.example.lijiang.happydispatch.ui.fragment.homePage.search.ComSearchFragment;
import com.example.lijiang.happydispatch.ui.fragment.homePage.search.StoreSearchFragment;
import com.github.ikidou.fragmentBackHandler.BackHandlerHelper;
import com.xiasuhuei321.loadingdialog.manager.StyleManager;
import com.xiasuhuei321.loadingdialog.view.LoadingDialog;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CommoditySearchActivity extends AppCompatActivity implements View.OnClickListener,IComSearchView{

    private LinearLayout mSearchLayout;

    private ImageView mBack;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private ArrayList<String> tabList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();

    private ComSearchAdapter mComSearchAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_search);
        initView();
        initData();
    }

    private void initView() {
        mSearchLayout = findViewById(R.id.search_layout);
        mBack = findViewById(R.id.back);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewpager);

        mBack.setOnClickListener(this);
        mSearchLayout.setOnClickListener(this);
    }

    private void initData() {
        showLoadingDialog();
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        tabList.add("商品");
        tabList.add("店铺");
        ComSearchFragment commoditySearchFragment = new ComSearchFragment();
        StoreSearchFragment shopSearchFragment = new StoreSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",key);
        commoditySearchFragment.setArguments(bundle);
        shopSearchFragment.setArguments(bundle);
        mFragmentList.add(commoditySearchFragment);
        mFragmentList.add(shopSearchFragment);
        mComSearchAdapter = new ComSearchAdapter(getSupportFragmentManager(), tabList, mFragmentList);
        mViewPager.setAdapter(mComSearchAdapter);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabLayout,50,50);
            }
        });
    }

    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.search_layout:
                startActivity(new Intent(this,SearchActivity.class));
                break;

        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void cancelLoadingDialog() {

    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }
}
