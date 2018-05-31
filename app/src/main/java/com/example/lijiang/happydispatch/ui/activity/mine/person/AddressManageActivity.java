package com.example.lijiang.happydispatch.ui.activity.mine.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.recyclerview.AddressManageRvAdapter;
import com.example.lijiang.happydispatch.entity.AddressManage;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.presenter.mine.person.AddressManagePresenter;
import com.example.lijiang.happydispatch.ui.diyView.LineItemDecoration;
import com.example.lijiang.happydispatch.util.NormalUtil;

import java.util.ArrayList;
import java.util.List;

public class AddressManageActivity extends AppCompatActivity implements IAddressManageView,View.OnClickListener{

    private RecyclerView mAddressManageRv;
    private AddressManagePresenter mPresenter;
    private AddressManageRvAdapter adapter;
    private List<AddressManage> mManageList = new ArrayList<>();
    private Button mAddAddressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manage);
        initView();
    }

    private void initView(){
        mPresenter = new AddressManagePresenter();
        mPresenter.attachView(this);

        mAddressManageRv = findViewById(R.id.address_manage_rv);
        mAddressManageRv.addItemDecoration(new LineItemDecoration());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mAddressManageRv.setLayoutManager(linearLayoutManager);
        adapter = new AddressManageRvAdapter(this, mManageList, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {
                NormalUtil.toast(AddressManageActivity.this,"woaini"+id);
            }
        });
        adapter.setOnItemClickListener(new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {
                NormalUtil.toast(AddressManageActivity.this,"woaini"+id);
            }
        });
        mAddressManageRv.setAdapter(adapter);
        mPresenter.getAddressList();

        mAddAddressButton = findViewById(R.id.add_address_button);
        mAddAddressButton.setOnClickListener(this);
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
    public void getAddressList(List<AddressManage> list) {
        adapter.addList(list);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_address_button:
                startActivity(new Intent(AddressManageActivity.this,AddAddressActivity.class));
                break;

        }
    }
}
