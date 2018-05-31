package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.Store;
import com.example.lijiang.happydispatch.entity.StoreImage;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.ui.diyView.MySnapHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijiang on 2018/2/24.
 */

public class StoreRvAdapter extends BaseRvAdapter<Store> {

    public StoreRvAdapter(Context context, List<Store> list, RvClickListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_rv_shop;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new StoreHolder(view,viewType,listener);
    }

    private class StoreHolder extends BaseRvHolder<Store>{

        TextView mStoreName;
        TextView mSellNumber;
        TextView mDistance;
        private LinearLayoutManager linearLayoutManager;
        private RecyclerView mRecyclerView;

        public StoreHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
            mStoreName = itemView.findViewById(R.id.store_name);
            mSellNumber = itemView.findViewById(R.id.sell_number);
            mDistance = itemView.findViewById(R.id.distance);

            mRecyclerView = itemView.findViewById(R.id.shop_image_rv);
            linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            MySnapHelper snapHelper = new MySnapHelper();
            snapHelper.attachToRecyclerView(mRecyclerView);
        }

        @Override
        public void bindHolder(Store store, int position) {
            mStoreName.setText(store.getSName());
            mSellNumber.setText("销量"+store.getBNumber());
            mDistance.setText("距离"+(int)store.getDistance()+"米");
            List<StoreImage> list1 = new ArrayList<>();
            for (int i = 0;i < 10;i++){
                list1.add(new StoreImage());
            }
            StoreImageRvAdapter mStoreImageAdapter = new StoreImageRvAdapter(context, list1, new RvClickListener() {
                @Override
                public void onItemClick(int id, int position) {

                }
            });
            mRecyclerView.setAdapter(mStoreImageAdapter);
        }
    }
}
