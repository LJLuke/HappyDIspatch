package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/2/23.
 */

public class SortTabRvAdapter extends BaseRvAdapter<String>{

    public SortTabRvAdapter(Context context, List<String> list, RvClickListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_rv_sort_tab;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new SortTabHolder(view,viewType,listener);
    }
    private class SortTabHolder extends BaseRvHolder<String> {
        private TextView mSortText;
        public SortTabHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
            mSortText = itemView.findViewById(R.id.sort_select);
        }

        @Override
        public void bindHolder(String s, int position) {
            mSortText.setText(s);
        }
    }
}
