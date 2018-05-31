package com.example.lijiang.happydispatch.adapter.recyclerview;

import android.content.Context;
import android.view.View;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseRvAdapter;
import com.example.lijiang.happydispatch.base.BaseRvHolder;
import com.example.lijiang.happydispatch.entity.Comment;
import com.example.lijiang.happydispatch.listener.RvClickListener;

import java.util.List;

/**
 * Created by lijiang on 2018/2/25.
 */

public class CommentRvAdapter extends BaseRvAdapter<Comment>{
    public CommentRvAdapter(Context context, List<Comment> list, RvClickListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_rv_comment;
    }

    @Override
    protected BaseRvHolder getHolder(View view, int viewType) {
        return new CommentHolder(view,viewType,listener);
    }

    private class CommentHolder extends BaseRvHolder<Comment>{
        public CommentHolder(View itemView, int type, RvClickListener listener) {
            super(itemView, type, listener);
        }

        @Override
        public void bindHolder(Comment comment, int position) {

        }
    }
}
