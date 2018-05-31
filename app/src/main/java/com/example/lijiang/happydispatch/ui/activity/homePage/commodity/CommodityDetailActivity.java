package com.example.lijiang.happydispatch.ui.activity.homePage.commodity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.entity.Commodity;
import com.example.lijiang.happydispatch.presenter.homePage.commodity.CommodityDetailPresenter;
import com.example.lijiang.happydispatch.sharePreferences.SpHelper;
import com.example.lijiang.happydispatch.util.NormalUtil;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommodityDetailActivity extends AppCompatActivity implements IComDetailView,View.OnClickListener{

    private SpHelper mSpHelper;
    private CommodityDetailPresenter mPresenter;

    private CircleImageView mBack;
    private RatingBar mRatingBar;
    private LinearLayout mCommentLayout;
    private LinearLayout mShopBusLayout;

    private TextView mComName;
    private TextView mComDescription;
    private TextView mPrice;
    private TextView mLowerPrice;
    private TextView mCommentNumber;

    private int gID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_detail);
        initView();
    }

    private void initView(){
        mPresenter = new CommodityDetailPresenter();
        mPresenter.attachView(this);
        mSpHelper = new SpHelper(this,"user");

        Intent intent  = getIntent();
        gID = intent.getIntExtra("gID",0);

        mRatingBar = findViewById(R.id.rating_bar);
        mCommentLayout = findViewById(R.id.comment_layout);
        mShopBusLayout = findViewById(R.id.shop_bus_layout);
        mShopBusLayout.setOnClickListener(this);

        mComName = findViewById(R.id.com_name);
        mComDescription = findViewById(R.id.com_description);
        mPrice = findViewById(R.id.com_price);
        mLowerPrice = findViewById(R.id.low_price);
        mCommentNumber = findViewById(R.id.comment_number);

        mBack = findViewById(R.id.circle_back);
        mCommentLayout.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mRatingBar.setRating(3);

        mPresenter.getCommodityDetail(gID);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.comment_layout:
                startActivity(new Intent(this,CommentActivity.class));
                break;
            case R.id.shop_bus_layout:
                mPresenter.addShopBus(mSpHelper.getInt("userId"),gID,1);
                break;
            case R.id.circle_back:
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
    public void onCommodityDetail(Commodity commodity) {
        mComName.setText(commodity.getGName());
        mComDescription.setText(commodity.getIntroduce());
        mPrice.setText(commodity.getPrice()+"");
        mLowerPrice.setText(commodity.getLowPrice()+"");
        mCommentNumber.setText("查看全部"+commodity.getCNumber()+"条评论");
    }

    @Override
    public void onAddShopBus(int status) {
        if (status == 1){
            NormalUtil.toast(this,"添加成功");
        }else {
            NormalUtil.toast(this,"添加失败");
        }
    }
}
