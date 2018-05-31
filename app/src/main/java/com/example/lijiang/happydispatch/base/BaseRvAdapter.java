package com.example.lijiang.happydispatch.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/2/22.
 */

public abstract class BaseRvAdapter<T> extends RecyclerView.Adapter<BaseRvHolder> {

    protected List<T> list;
    protected Context context;
    protected RvClickListener listener;
    protected LayoutInflater mInflater;
    public BaseRvAdapter(Context context, List<T> list,RvClickListener listener){
        this.list = list;
        this.context = context;
        this.listener = listener;
        mInflater = LayoutInflater.from(context);
    }
    public void addList(List<T> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @Override
    public BaseRvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(getLayoutId(viewType),parent,false);
        return getHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(BaseRvHolder holder, int position) {
        holder.bindHolder(list.get(position),position);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    protected abstract int getLayoutId(int viewType);
    protected abstract BaseRvHolder getHolder(View view, int viewType);
}
