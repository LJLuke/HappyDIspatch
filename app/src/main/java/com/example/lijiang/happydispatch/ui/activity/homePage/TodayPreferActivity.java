package com.example.lijiang.happydispatch.ui.activity.homePage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.recyclerview.TodayPreferRvAdapter;
import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.presenter.homePage.TodayPreferPresenter;

import java.util.List;

public class TodayPreferActivity extends AppCompatActivity implements ITodayPreferView,View.OnClickListener{

    private RecyclerView mTodayPreferRv;
    private ImageView mBack;

    private TextView mDistanceText;
    private TextView mHeatText;
    private TextView mPreferText;

    private TodayPreferPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_prefer);
        initView();
        initData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.distance_text:

                break;
            case R.id.heat_text:
                break;
            case R.id.prefer_text:
                break;
            case R.id.back:
                finish();
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

    private void initView(){
        mPresenter = new TodayPreferPresenter();
        mPresenter.attachView(this);
        mTodayPreferRv = findViewById(R.id.prefer_rv);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mTodayPreferRv.setLayoutManager(manager);

        mDistanceText = findViewById(R.id.distance_text);
        mHeatText = findViewById(R.id.heat_text);
        mPreferText = findViewById(R.id.prefer_text);
        mBack = findViewById(R.id.back);

    }

    private void initData(){
        mPresenter.getTodayPreferList();
        mDistanceText.setOnClickListener(this);
        mHeatText.setOnClickListener(this);
        mPreferText.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    @Override
    public void getTodayPreferList(List<Commodity> list) {
        TodayPreferRvAdapter adapter = new TodayPreferRvAdapter(this, list, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {

            }
        });
        mTodayPreferRv.setAdapter(adapter);
    }
}
