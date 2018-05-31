package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.ClassifyLeft;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/2/27.
 */

public class ClassifyLeftRvAdapter extends BaseRvAdapter<ClassifyLeft> {
    private int mCheckedPosition;
    public ClassifyLeftRvAdapter(Context context, List<ClassifyLeft> list, RvClickListener listener) {
        super(context, list, listener);
    }

    public void setCheckedPosition(int checkedPosition){
        this.mCheckedPosition = checkedPosition;
        notifyDataSetChanged();
    }
    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_rv_classify_left;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new ClassifyLeftHolder(view,viewType,listener);
    }

    private class ClassifyLeftHolder extends BaseRvHolder<ClassifyLeft>{
        private TextView mClassifyName;
        private ImageView mClassifyImage;
        private View mView;
        public ClassifyLeftHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
            mClassifyName = itemView.findViewById(R.id.classify_name);
            mClassifyImage = itemView.findViewById(R.id.classify_iamge);
            mView = itemView;
        }

        @Override
        public void bindHolder(ClassifyLeft data, int position) {
            mClassifyName.setText(data.getTitle());
            if (position == mCheckedPosition){
                mClassifyName.setTextColor(Color.parseColor("#FD7D6F"));
                mClassifyImage.setImageResource(data.getCheckedImageSource());
                mView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }else {
                mClassifyName.setTextColor(Color.parseColor("#878787"));
                mClassifyImage.setImageResource(data.getImageSource());
                mView.setBackgroundColor(Color.parseColor("#F9FEFF"));
            }
        }
    }
}
