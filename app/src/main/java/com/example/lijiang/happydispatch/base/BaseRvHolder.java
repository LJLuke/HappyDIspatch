package com.example.lijiang.happydispatch.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lijiang.happydispatch.listener.RvClickListener;

/**
 * Created by lijiang on 2018/2/22.
 */

public abstract class BaseRvHolder<T> extends RecyclerView.ViewHolder {

    protected RvClickListener mListener;
    public BaseRvHolder(View itemView,int type,RvClickListener listener) {
        super(itemView);
        this.mListener = listener;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(view.getId(),getAdapterPosition());
            }
        });
    }
    public abstract void bindHolder(T t,int position);
}
