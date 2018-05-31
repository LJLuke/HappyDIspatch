package com.example.lijiang.happydispatch.ui.fragment.homePage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseFragment;
import com.example.lijiang.happydispatch.ui.activity.homePage.GuessLikeActivity;
import com.example.lijiang.happydispatch.ui.activity.homePage.TodayPreferActivity;
import com.example.lijiang.happydispatch.ui.activity.homePage.search.SearchActivity;
import com.example.lijiang.happydispatch.ui.fragment.homePage.search.IHomePageFView;
import com.example.lijiang.happydispatch.util.NormalUtil;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;


/**
 * Created by lijiang on 2018/2/12.
 */

public class HomePageFragment extends BaseFragment implements IHomePageFView,View.OnClickListener,OnBannerListener {

    private Banner mBanner;
    private LinearLayout mLocationLayout;
    private LinearLayout mSearchLayout;

    private ImageView mQrCode;

    private ImageView mMoreLike;
    private ImageView mMorePreferential;

    private TextView mGuessLikeText;
    private TextView mMorePreText;


    private static final int REQUEST_CODE_PICK_CITY = 0;
    private static final int REQUEST_CODE = 1;
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
    public int bindLayout() {
        return R.layout.fragment_home_page;
    }

    @Override
    public void initView() {
        ZXingLibrary.initDisplayOpinion(mActivity);
        mLocationLayout = mView.findViewById(R.id.location_layout);
        mBanner = mView.findViewById(R.id.viewpager);
        mSearchLayout = mView.findViewById(R.id.search_layout);

        mQrCode = mView.findViewById(R.id.qr_code);

        mMoreLike = mView.findViewById(R.id.guess_like_layout).findViewById(R.id.more_commodity);
        mMorePreferential = mView.findViewById(R.id.today_preferential_layout).findViewById(R.id.more_commodity);

        mGuessLikeText = mView.findViewById(R.id.guess_like_layout).findViewById(R.id.group_name);
        mMorePreText = mView.findViewById(R.id.today_preferential_layout).findViewById(R.id.group_name);

        mGuessLikeText.setText("猜你喜欢");
        mMorePreText.setText("今日优惠");

    }

    @Override
    public void initData() {
        mLocationLayout.setOnClickListener(this);
        mSearchLayout.setOnClickListener(this);
        mQrCode.setOnClickListener(this);
        mMoreLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mActivity, GuessLikeActivity.class));
            }
        });
        mMorePreferential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mActivity, TodayPreferActivity.class));
            }
        });

        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.erweima);
        list.add(R.drawable.erweima);
        list.add(R.drawable.erweima);
        list.add(R.drawable.erweima);
        mBanner.setImages(list);
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBanner.setOnBannerListener(this);
        mBanner.start();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                Toast.makeText(mActivity,city,Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == REQUEST_CODE){
            if (data != null){
                Bundle bundle = data.getExtras();
                if (bundle == null){
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(mActivity, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(mActivity, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.location_layout:
                startActivityForResult(new Intent(mActivity, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;
            case R.id.search_layout:
                startActivity(new Intent(mActivity, SearchActivity.class));
                break;
            case R.id.qr_code:
                startActivityForResult(new Intent(mActivity, CaptureActivity.class),REQUEST_CODE);
                break;

        }
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(mActivity,"gjkldsg",Toast.LENGTH_SHORT).show();

    }

    public class GlideImageLoader extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
