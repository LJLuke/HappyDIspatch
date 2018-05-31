package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.entity.StoreDetail;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/2/25.
 */

public class StoreDetailRvAdapter extends BaseRvAdapter<StoreDetail.GoodsEntity>{
    public StoreDetailRvAdapter(Context context, List<StoreDetail.GoodsEntity> list, RvClickListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_rv_commodity;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new StoreDetailHolder(view,viewType,listener);
    }

    private class StoreDetailHolder extends BaseRvHolder<StoreDetail.GoodsEntity>{
        TextView mDescribe;
        TextView mPrice;
        TextView mNumber;
        TextView mAddress;
        public StoreDetailHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
            mDescribe = itemView.findViewById(R.id.com_description);
            mPrice = itemView.findViewById(R.id.com_price);
            mNumber = itemView.findViewById(R.id.com_number);
            mAddress = itemView.findViewById(R.id.com_distance);
        }

        @Override
        public void bindHolder(StoreDetail.GoodsEntity goodsEntity, int position) {
            mDescribe.setText(goodsEntity.getIntroduce());
            mPrice.setText(goodsEntity.getPrice()+"");
            mNumber.setText(goodsEntity.getBNumber()+"人付款");

        }
    }
}
