package com.example.lijiang.happydispatch.ui.activity.homePage.search;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.presenter.homePage.search.SearchPresenter;
import com.example.lijiang.happydispatch.ui.diyView.FlowLayout;
import com.example.lijiang.happydispatch.ui.fragment.homePage.search.ComSearchFragment;
import com.example.lijiang.happydispatch.util.NormalUtil;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener,ISearchView {

    private SearchView mSearchView;
    private ImageView mDeleteAll;
    private FlowLayout flowLayout;
    private SearchPresenter mPresenter;
    private List<String> mRecordList;
    private TextView mSearch;
    private ImageView mBack;

    private String mQueryText = new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        initData();

    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

    }

    private void initView(){
        mSearchView = findViewById(R.id.search_include).findViewById(R.id.search_view);
        flowLayout = findViewById(R.id.record_flowLayout);
        mDeleteAll = findViewById(R.id.delete_all);
        mSearch = findViewById(R.id.search_include).findViewById(R.id.search);
        mBack = findViewById(R.id.search_include).findViewById(R.id.back);
        mRecordList = new ArrayList<>();
        mPresenter = new SearchPresenter(this);
        mPresenter.attachView(this);
        mPresenter.getHistoricRecord();
    }
    private void initData(){
        mDeleteAll.setOnClickListener(this);
        mSearch.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mSearchView.setIconified(false);
        mSearchView.onActionViewExpanded();
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mQueryText = newText;
                return false;
            }
        });
    }
    private void setTextView(List<String> list){
        for (int i = 0;i < list.size();i++){
            final TextView textView = new TextView(this);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SearchActivity.this, CommoditySearchActivity.class);
                    intent.putExtra("key",textView.getText());
                    startActivity(intent);
                }
            });
            textView.setText(list.get(i));
            textView.setTextSize(15);
            textView.setBackgroundResource(R.drawable.shape_label);
            textView.setTextColor(Color.parseColor("#ffffff"));
            flowLayout.addView(textView);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.delete_all:
                flowLayout.removeAllViews();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.deleteRecord();
                    }
                }).start();

                break;
            case  R.id.search:
                if (!mQueryText.isEmpty()){
                    Intent intent = new Intent(SearchActivity.this, CommoditySearchActivity.class);
                    intent.putExtra("key",mQueryText);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mPresenter.saveRecord(mQueryText);
                        }
                    }).start();
                    startActivity(intent);
                }
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

    @Override
    public void getGuessLike(List<String> list) {

    }

    @Override
    public void getHistoricRecord(List<String> list) {
        setTextView(list);
    }

}
