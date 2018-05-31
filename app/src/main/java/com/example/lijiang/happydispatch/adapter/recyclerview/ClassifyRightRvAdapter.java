package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.ClassifyRight;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/2/27.
 */

public class ClassifyRightRvAdapter extends BaseRvAdapter<ClassifyRight> {

    public ClassifyRightRvAdapter(Context context, List<ClassifyRight> list, RvClickListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return viewType == 0 ? R.layout.item_classify_title : R.layout.item_rv_classify_right;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).isTitle() ? 0 : 1;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new ClassifyRightHolder(view,viewType,listener);
    }

    private class ClassifyRightHolder extends BaseRvHolder<ClassifyRight>{

        TextView mTitle;

        public ClassifyRightHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
            switch (type){
                case 0:
                    mTitle = itemView.findViewById(R.id.tv_title);
                    break;

            }
        }

        @Override
        public void bindHolder(ClassifyRight classifyRight, int position) {
            int viewType = ClassifyRightRvAdapter.this.getItemViewType(position);
            switch (viewType){
                case 0:
                    mTitle.setText(list.get(position).getTitleName());
                    break;
            }
        }
    }
}
