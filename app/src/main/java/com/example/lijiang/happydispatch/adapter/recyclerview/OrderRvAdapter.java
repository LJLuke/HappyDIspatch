package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.print.PageRange;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.Order;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/3/11.
 */

public class OrderRvAdapter extends BaseRvAdapter<Order> {
    public OrderRvAdapter(Context context, List list, RvClickListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_rv_order;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new OrderHolder(view,viewType,listener);
    }

    private class OrderHolder extends BaseRvHolder<Order>{

        public OrderHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
        }

        @Override
        public void bindHolder(Order order, int position) {

        }
    }
}
