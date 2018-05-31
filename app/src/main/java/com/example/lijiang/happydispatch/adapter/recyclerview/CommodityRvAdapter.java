package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/2/24.
 */

public class CommodityRvAdapter extends BaseRvAdapter<Commodity> {

    public CommodityRvAdapter(Context context, List<Commodity> list, RvClickListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_rv_commodity;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new CommdityHolder(view,viewType,listener);
    }

    private class CommdityHolder extends BaseRvHolder<Commodity> {
        private ImageView mComImage;
        private TextView mComDescription;
        private TextView mComPrice;
        private TextView mComNumber;
        private TextView mComDistance;

        public CommdityHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
            mComImage = itemView.findViewById(R.id.com_image);
            mComDescription = itemView.findViewById(R.id.com_description);
            mComPrice = itemView.findViewById(R.id.com_price);
            mComNumber = itemView.findViewById(R.id.com_number);
            mComDistance = itemView.findViewById(R.id.com_description);
        }

        @Override
        public void bindHolder(Commodity commodity, int position) {
            mComDescription.setText(commodity.getIntroduce());
            mComPrice.setText(commodity.getPrice()+"");
            mComNumber.setText(commodity.getBNumber()+"");
        }
    }
}
