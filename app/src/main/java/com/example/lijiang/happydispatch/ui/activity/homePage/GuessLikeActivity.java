package com.example.lijiang.happydispatch.ui.activity.homePage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.recyclerview.GuessLikeRvAdapter;
import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.presenter.homePage.GuessLikePresenter;
import com.example.lijiang.happydispatch.ui.diyView.LoadingDialog;

import java.util.List;

public class GuessLikeActivity extends AppCompatActivity implements View.OnClickListener,IGuessLikeView{

    private GuessLikePresenter mPresenter;

    private RecyclerView mGuessLikeRv;

    private ImageView mBack;

    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_like);
        initView();
        initData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                mLoadingDialog.show();
                break;

        }
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

    @Override
    public void getGuessLikeList(List<Commodity> list) {
        GuessLikeRvAdapter adapter = new GuessLikeRvAdapter(this, list, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {

            }
        });
        mGuessLikeRv.setAdapter(adapter);
    }

    private void initView(){
        mPresenter = new GuessLikePresenter();
        mPresenter.attachView(this);

        mGuessLikeRv = findViewById(R.id.guess_like_rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mGuessLikeRv.setLayoutManager(manager);

        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(this);

        mLoadingDialog = new LoadingDialog(this);
    }

    private void initData(){
        mPresenter.getGuessLikeList();
    }
}
