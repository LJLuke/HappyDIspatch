package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.view.View;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/2/26.
 */

public class GuessLikeRvAdapter extends BaseRvAdapter<Commodity> {
    public GuessLikeRvAdapter(Context context, List<Commodity> list, RvClickListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_rv_commodity;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new GuessLiekHolder(view,viewType,listener);
    }

    private class GuessLiekHolder extends BaseRvHolder<Commodity>{

        public GuessLiekHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
        }

        @Override
        public void bindHolder(Commodity commodity, int position) {

        }
    }
}
