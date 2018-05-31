package com.example.lijiang.happydispatch.ui.fragment.mine.order;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.recyclerview.OrderRvAdapter;
import com.example.lijiang.happydispatch.adapter.recyclerview.ShopBusRvAdapter;
import com.example.lijiang.happydispatch.adapter.viewpager.OrderFormAdapter;
import com.example.lijiang.happydispatch.base.BaseFragment;
import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.Order;
import com.example.lijiang.happydispatch.entity.ShopBus;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/3/11.
 */

public class WaitPayFragment extends BaseFragment implements IWaitPayFView{

    private OrderRvAdapter adapter;

    @Override
    public int bindLayout() {
        return R.layout.fragment_wait_pay;
    }

    @Override
    public void initView() {
        RecyclerView recyclerView = mView.findViewById(R.id.wait_pay_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new OrderRvAdapter(mActivity, null, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {

            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initData() {

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

    @Override
    public void getWaitPayList(List<Order> list) {
        adapter.addList(list);
    }
}
