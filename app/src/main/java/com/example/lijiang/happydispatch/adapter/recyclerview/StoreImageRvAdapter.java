package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.view.View;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.StoreImage;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/2/24.
 */

public class StoreImageRvAdapter extends BaseRvAdapter<StoreImage>{
    public StoreImageRvAdapter(Context context, List<StoreImage> list, RvClickListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_rv_shop_image;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new StoreImageHolder(view,viewType,listener);
    }

    private class StoreImageHolder extends BaseRvHolder<StoreImage>{

        public StoreImageHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
        }

        @Override
        public void bindHolder(StoreImage storeImage, int position) {

        }
    }
}
