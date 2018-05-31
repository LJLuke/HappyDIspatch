package com.example.lijiang.happydispatch.ui.activity.homePage.commodity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.recyclerview.CommentRvAdapter;
import com.example.lijiang.happydispatch.adapter.recyclerview.SortTabRvAdapter;
import com.example.lijiang.happydispatch.entity.Comment;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.presenter.homePage.commodity.CommentPresenter;
import com.example.lijiang.happydispatch.ui.diyView.LineItemDecoration;
import com.example.lijiang.happydispatch.util.NormalUtil;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity implements ICommentView,View.OnClickListener{

    private ImageView mBack;
    private RecyclerView mCommentRv;
    private CommentPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void cancelLoadingDialog() {

    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }

    private void initView(){
        mBack = findViewById(R.id.back);
        mCommentRv = findViewById(R.id.comment_rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mCommentRv.setLayoutManager(layoutManager);
        mPresenter = new CommentPresenter();
        mPresenter.attachView(this);
        mPresenter.getCommentList();
    }
    @Override
    public void getCommentList(List<Comment> list) {
        CommentRvAdapter adapter = new CommentRvAdapter(this, list, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {

            }
        });
        mCommentRv.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }
}
