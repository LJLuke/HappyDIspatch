package com.example.lijiang.happydispatch.ui.activity.mine.person;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.viewpager.OrderFormAdapter;
import com.example.lijiang.happydispatch.ui.fragment.mine.order.DealDoneFragment;
import com.example.lijiang.happydispatch.ui.fragment.mine.order.WaitCommentFragment;
import com.example.lijiang.happydispatch.ui.fragment.mine.order.WaitPayFragment;
import com.example.lijiang.happydispatch.ui.fragment.mine.order.WaitRefundFragment;
import com.example.lijiang.happydispatch.ui.fragment.mine.order.WaitTakeGoodsFragment;

import java.util.ArrayList;
import java.util.List;

public class MyOrderFormActivity extends AppCompatActivity {

    private ArrayList<String> mTabList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_form);
        initView();
    }
    private void initView(){
        TabLayout tabLayout = findViewById(R.id.order_form_tab_layout);
        ViewPager viewPager = findViewById(R.id.order_form_viewpager);
        String[] mTabArry = {"待支付","待收货","待评价","待退款","已完成"};
        Fragment[] mFragmentArry = {new WaitPayFragment(),new WaitTakeGoodsFragment(),new WaitCommentFragment(),
                                    new WaitRefundFragment(),new DealDoneFragment()};
        for (int i = 0;i < 5;i++){
            mTabList.add(mTabArry[i]);
            mFragmentList.add(mFragmentArry[i]);
        }
        OrderFormAdapter orderFormAdapter = new OrderFormAdapter(getSupportFragmentManager(),mTabList,mFragmentList);
        viewPager.setAdapter(orderFormAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
    }
}
