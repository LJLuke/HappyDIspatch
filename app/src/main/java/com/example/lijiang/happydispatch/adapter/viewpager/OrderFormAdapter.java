package com.example.lijiang.happydispatch.adapter.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lijiang on 2018/3/11.
 */

public class OrderFormAdapter extends FragmentPagerAdapter {
    private List<String> mList;
    private List<Fragment> mFragmentList;
    public OrderFormAdapter(FragmentManager fm,List<String> list, List<Fragment> mFragmentList) {
        super(fm);
        this.mList = list;
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }
}
