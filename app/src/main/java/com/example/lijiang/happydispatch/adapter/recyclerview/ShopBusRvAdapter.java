package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.view.View;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.ShopBus;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.ui.diyView.SmoothCheckBox;

import java.util.List;

/**
 * Created by lijiang on 2018/2/27.
 */

public class ShopBusRvAdapter extends BaseRvAdapter<ShopBus> {
    private boolean isCheckedBox;
    public ShopBusRvAdapter(Context context, List<ShopBus> list, RvClickListener listener) {
        super(context, list, listener);
    }

    public void setCheckedBox(boolean isCheckedBox){
        this.isCheckedBox = isCheckedBox;
    }
    @Override
    protected int getLayoutId(int viewType) {
        return viewType == 0 ? R.layout.item_rv_shop_bus_store : R.layout.item_rv_shop_bus;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new ShopBusHolder(view,viewType,listener);
    }

    private class ShopBusHolder extends BaseRvHolder<ShopBus>{
        SmoothCheckBox mStoreCheckBox;
        SmoothCheckBox mSingleCheckBox;

        public ShopBusHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
            switch (type){
                case 0:
                    mStoreCheckBox = itemView.findViewById(R.id.store_check_box);
                    break;
                case 1:
                    mSingleCheckBox = itemView.findViewById(R.id.single_check_box);
                    break;
            }
        }

        @Override
        public void bindHolder(ShopBus shopBus, int position) {
            int viewType = ShopBusRvAdapter.this.getItemViewType(position);
//            if (isCheckedBox){
//                mSingleCheckBox.setChecked(true);
//                mStoreCheckBox.setChecked(true);
//            }else {
//                mStoreCheckBox.setChecked(false);
//                mSingleCheckBox.setChecked(false);
//            }

            switch (viewType){
                case 0:
                    mStoreCheckBox.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(SmoothCheckBox smoothCheckBox, boolean isChecked) {
                            if (isChecked){
                                mSingleCheckBox.setChecked(true);
                            }else {
                                mSingleCheckBox.setChecked(false);
                            }
                        }
                    });
                    break;
            }

        }
    }
}
