package com.example.lijiang.happydispatch.ui.activity.homePage.store;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.adapter.recyclerview.SortTabRvAdapter;
import com.example.lijiang.happydispatch.adapter.recyclerview.StoreDetailRvAdapter;
import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.entity.StoreDetail;
import com.example.lijiang.happydispatch.listener.RvClickListener;
import com.example.lijiang.happydispatch.presenter.homePage.store.StoreDetailPresenter;
import com.example.lijiang.happydispatch.ui.activity.homePage.commodity.CommentActivity;
import com.example.lijiang.happydispatch.ui.activity.homePage.commodity.CommodityDetailActivity;
import com.example.lijiang.happydispatch.ui.diyView.LineItemDecoration;
import com.example.lijiang.happydispatch.ui.diyView.MyPopuWindow;
import com.example.lijiang.happydispatch.util.NormalUtil;
import com.xiasuhuei321.loadingdialog.manager.StyleManager;
import com.xiasuhuei321.loadingdialog.view.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoreDetailActivity extends AppCompatActivity implements View.OnClickListener,IStoreDetailView {

    private LoadingDialog mLoadingDialog;

    private StoreDetailPresenter mPresenter;
    private RecyclerView mStoreDetailRv;
    private StoreDetailRvAdapter mStoreDetailRvAdapter;

    private TextView mStoreName;
    private CircleImageView mStoreImage;
    private TextView mStoreAddress;
    private TextView mCollection;

    private TextView mSortText;
    private ImageView mSortImage;
    private TextView mPreferentialText;
    private ImageView mPreferentialImage;

    private LinearLayout mCommodityLayout;
    private LinearLayout mPreferentialLayout;
    private LinearLayout mFilterLayout;

    private MyPopuWindow mSortPopupWindow;
    private PopupWindow mFilterPopuWindow;
    private View mSortPopWindowView;
    private View mFilterPopuWindowView;

    private RecyclerView mSortTabRv;

    private ImageView mBack;
    private List<String> mSortList = new ArrayList<>();
    private List<StoreDetail.GoodsEntity> mGoodsEntityList = new ArrayList<>();

    private int sID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);
        StyleManager s = new StyleManager();
        s.Anim(false).repeatTime(0).contentSize(-1).intercept(true);
        LoadingDialog.initStyle(s);
        initView();
    }

    private void initView(){
        mPresenter = new StoreDetailPresenter();
        mPresenter.attachView(this);

        Intent intent = getIntent();
        sID = intent.getIntExtra("sID",0);

        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mStoreName = findViewById(R.id.store_name);
        mStoreImage = findViewById(R.id.store_image);
        mStoreAddress = findViewById(R.id.store_address);
        mCollection = findViewById(R.id.collection);
        mCollection.setOnClickListener(this);

        mCommodityLayout = findViewById(R.id.commodity_layout);
        mCommodityLayout.setOnClickListener(this);

        mPreferentialLayout = findViewById(R.id.preferential_layout);
        mPreferentialLayout.setOnClickListener(this);

        mFilterLayout = findViewById(R.id.filter_layout);
        mFilterLayout.setOnClickListener(this);





        mSortPopWindowView = getLayoutInflater().inflate(R.layout.popwindow_sort,null);
        mFilterPopuWindowView = getLayoutInflater().inflate(R.layout.popu_window_filter,null);
        mSortPopupWindow = new MyPopuWindow(this);
        mFilterPopuWindow = new PopupWindow(this);

        mSortPopupWindow.setContentView(mSortPopWindowView);
        mSortPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        mSortPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mSortPopupWindow.setHeight(NormalUtil.getScreenHeight(this));
        mSortPopupWindow.setOutsideTouchable(true);
        mSortPopupWindow.setFocusable(true);
        mSortPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setChecked(false,null,null);

            }
        });

        mFilterPopuWindow.setContentView(mFilterPopuWindowView);
        mFilterPopuWindow.setWidth(NormalUtil.getScreenWidth(this) * 2/3);
        mFilterPopuWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        mFilterPopuWindow.setOutsideTouchable(true);
        mFilterPopuWindow.setFocusable(true);

        mSortTabRv = mSortPopWindowView.findViewById(R.id.sort_tab_rv);
        LinearLayoutManager mSortManager = new LinearLayoutManager(this);
        mSortTabRv.addItemDecoration(new LineItemDecoration());
        mSortTabRv.setLayoutManager(mSortManager);

        mSortText = findViewById(R.id.commodity_layout).findViewById(R.id.tab_name);
        mSortImage = findViewById(R.id.commodity_layout).findViewById(R.id.tab_icon);

        mPreferentialText = findViewById(R.id.preferential_layout).findViewById(R.id.tab_name);
        mPreferentialImage = findViewById(R.id.preferential_layout).findViewById(R.id.tab_icon);

        mSortText.setText("全部商品");
        mPreferentialText.setText("优惠");

        mStoreDetailRv = findViewById(R.id.store_detail_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mStoreDetailRv.setLayoutManager(linearLayoutManager);
        mStoreDetailRv.addItemDecoration(new LineItemDecoration());
        mStoreDetailRvAdapter = new StoreDetailRvAdapter(this, mGoodsEntityList, new RvClickListener() {
            @Override
            public void onItemClick(int id, int position) {
                Intent intent = new Intent(StoreDetailActivity.this, CommodityDetailActivity.class);
                intent.putExtra("gID",mGoodsEntityList.get(position).getGId());
                startActivity(intent);
            }
        });
        mStoreDetailRv.setAdapter(mStoreDetailRvAdapter);
        mPresenter.getStoreDetail(sID);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.commodity_layout:
                setChecked(true,mSortText,mSortImage);
                int [] location = new int[2];
                mCommodityLayout.getLocationOnScreen(location);
                mSortPopupWindow.showAsDropDown(mCommodityLayout);
                mSortList.clear();
                mSortList.add("全部商品");
                mSortList.add("按距离排序");
                mSortList.add("按热度排序");
                SortTabRvAdapter mSortAdapter = new SortTabRvAdapter(this, mSortList, new RvClickListener() {
                    @Override
                    public void onItemClick(int id, int position) {
                        mSortText.setText(mSortList.get(position));
                        mSortPopupWindow.dismiss();
                    }
                });
                mSortTabRv.setAdapter(mSortAdapter);
                break;
            case R.id.preferential_layout:
                mSortList.clear();
                setChecked(true,mPreferentialText,mPreferentialImage);
                mSortPopupWindow.showAsDropDown(mPreferentialLayout);
                mSortList.add("按热度排序");
                mSortList.add("按距离排序");
                mSortList.add("按优惠力度排序");
                SortTabRvAdapter mPreAdapter = new SortTabRvAdapter(this, mSortList, new RvClickListener() {
                    @Override
                    public void onItemClick(int id, int position) {
                        mPreferentialText.setText(mSortList.get(position));
                        mSortPopupWindow.dismiss();
                    }
                });
                mSortTabRv.setAdapter(mPreAdapter);
                break;
            case R.id.filter_layout:
                mFilterPopuWindow.showAtLocation(mFilterPopuWindowView, Gravity.END,0,0);
                break;
            case R.id.collection:

        }
    }

    @Override
    public void showLoadingDialog() {
        mLoadingDialog = new LoadingDialog(this);
        mLoadingDialog.setInterceptBack(true)
                .show();
    }

    @Override
    public void cancelLoadingDialog() {
        mLoadingDialog.close();
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        mLoadingDialog.close();
        NormalUtil.toast(this,"加载失败");
    }

    private void setChecked(boolean isChecked,TextView textView,ImageView imageView){
        if (isChecked){
            textView.setTextColor(Color.parseColor("#3FCFE4"));
            imageView.setImageResource(R.drawable.more_up_blue);
        }else {
            mSortText.setTextColor(Color.parseColor("#878787"));
            mPreferentialText.setTextColor(Color.parseColor("#878787"));
            mSortImage.setImageResource(R.drawable.more_down_gray);
            mPreferentialImage.setImageResource(R.drawable.more_down_gray);
        }
    }

    @Override
    public void onGetStoreDetail(StoreDetail storeDetail) {
        mStoreName.setText(storeDetail.getSName());
        mStoreAddress.setText(storeDetail.getAddress());


        Log.d("hhhhsiz",storeDetail.getGoods().size()+"");
        mGoodsEntityList.clear();
        mGoodsEntityList.addAll(storeDetail.getGoods());
        mStoreDetailRvAdapter.addList(mGoodsEntityList);
    }
}
