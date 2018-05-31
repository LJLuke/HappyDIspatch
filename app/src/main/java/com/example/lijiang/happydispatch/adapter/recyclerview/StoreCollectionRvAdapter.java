package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.Store;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/3/25.
 */

public class StoreCollectionRvAdapter extends BaseRvAdapter<Store> {
    public StoreCollectionRvAdapter(Context context, List<Store> list, RvClickListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_rv_interested_store_manage;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new StoreCollectionHolder(view,viewType,listener);
    }

    private class StoreCollectionHolder extends BaseRvHolder<Store>{
        TextView mStoreName;
        TextView mStoreAddress;
        public StoreCollectionHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
            mStoreName = itemView.findViewById(R.id.store_name);
            mStoreAddress = itemView.findViewById(R.id.store_address);
        }

        @Override
        public void bindHolder(Store store, int position) {
            mStoreName.setText(store.getSName());
            mStoreAddress.setText(store.getAddress());
        }
    }
}
