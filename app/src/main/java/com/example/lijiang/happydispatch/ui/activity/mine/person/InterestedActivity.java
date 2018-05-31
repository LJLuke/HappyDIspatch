package com.example.lijiang.happydispatch.ui.activity.mine.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.recyclerview.StoreCollectionRvAdapter;
import com.example.lijiang.happydispatch.adapter.recyclerview.StoreDetailRvAdapter;
import com.example.lijiang.happydispatch.adapter.recyclerview.StoreRvAdapter;
import com.example.lijiang.happydispatch.entity.Store;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.presenter.mine.person.InterestedPresenter;
import com.example.lijiang.happydispatch.sharePreferences.SpHelper;
import com.example.lijiang.happydispatch.ui.activity.homePage.store.StoreDetailActivity;
import com.example.lijiang.happydispatch.ui.diyView.LineItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class InterestedActivity extends AppCompatActivity implements IInterestedView,View.OnClickListener{

    private InterestedPresenter mPresenter;
    private SpHelper mSpHelper;

    private ImageView mBack;

    private RecyclerView mCollectionRv;
    private StoreCollectionRvAdapter mCollectionRvAdapter;
    private List<Store> mStoreList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested);
        initView();
    }

    private void initView(){
        mPresenter = new InterestedPresenter();
        mPresenter.attachView(this);
        mSpHelper = new SpHelper(this,"user");

        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mCollectionRv = findViewById(R.id.interested_store_rv);
        mCollectionRv.addItemDecoration(new LineItemDecoration());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mCollectionRv.setLayoutManager(layoutManager);
        mCollectionRvAdapter = new StoreCollectionRvAdapter(this, mStoreList, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {
                Intent intent = new Intent(InterestedActivity.this, StoreDetailActivity.class);
                intent.putExtra("sID",mStoreList.get(position).getSId());
                startActivity(intent);
            }
        });
        mCollectionRv.setAdapter(mCollectionRvAdapter);
        mPresenter.getCollection(mSpHelper.getInt("userId"));
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
    public void onGetCollection(List<Store> list) {
        mStoreList.clear();
        mStoreList.addAll(list);
        mCollectionRvAdapter.addList(mStoreList);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
