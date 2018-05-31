package com.example.lijiang.happydispatch.ui.fragment.mine;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.base.BaseFragment;
import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.sharePreferences.SpHelper;
import com.example.lijiang.happydispatch.ui.activity.mine.person.AddressManageActivity;
import com.example.lijiang.happydispatch.ui.activity.mine.person.EditPersonActivity;
import com.example.lijiang.happydispatch.ui.activity.mine.person.InterestedActivity;
import com.example.lijiang.happydispatch.ui.activity.mine.person.MyOrderFormActivity;
import com.example.lijiang.happydispatch.ui.activity.mine.setting.SettingActivity;
import com.example.lijiang.happydispatch.util.NormalUtil;

/**
 * Created by lijiang on 2018/3/8.
 */

public class MineFragment extends BaseFragment implements IMineFView,View.OnClickListener{

    private LinearLayout mCollectionLayout;
    private LinearLayout mEditPersonMessage;
    private RelativeLayout mMoreAddressLayout;
    private RelativeLayout mMyOrderFormLayout;

    private TextView mUserName;

    private ImageView mAddressMore;
    private ImageView mSetting;
    private ImageView mMessage;

    private SpHelper mUserHelper;

    @Override
    public int bindLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {
        mUserHelper = new SpHelper(mActivity,"user");

        mCollectionLayout = mView.findViewById(R.id.collection_layout);
        mCollectionLayout.setOnClickListener(this);
        mEditPersonMessage = mView.findViewById(R.id.edit_person_message_layout);
        mAddressMore = mView.findViewById(R.id.address_more);
        mMoreAddressLayout = mView.findViewById(R.id.more_address_layout);
        mMyOrderFormLayout = mView.findViewById(R.id.my_order_form_layout);
        mEditPersonMessage.setOnClickListener(this);
        mAddressMore.setOnClickListener(this);
        mMoreAddressLayout.setOnClickListener(this);
        mMyOrderFormLayout.setOnClickListener(this);

        mSetting = mView.findViewById(R.id.setting);
        mMessage = mView.findViewById(R.id.message);
        mSetting.setOnClickListener(this);
        mMessage.setOnClickListener(this);

        mUserName = mView.findViewById(R.id.user_name);
    }

    @Override
    public void initData() {
        mUserName.setText(mUserHelper.getString("tName"));
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == 1){
                if (data != null){
                    String tName = data.getStringExtra("tName");
                    mUserName.setText(tName);
                }
            }

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.edit_person_message_layout:
                startActivityForResult(new Intent(mActivity, EditPersonActivity.class),1);
                break;
            case R.id.address_more:
                startActivity(new Intent(mActivity, AddressManageActivity.class));
                break;
            case R.id.more_address_layout:
                startActivity(new Intent(mActivity, AddressManageActivity.class));
                break;
            case R.id.my_order_form_layout:
                startActivity(new Intent(mActivity, MyOrderFormActivity.class));
                break;
            case R.id.setting:
                startActivity(new Intent(mActivity, SettingActivity.class));
                break;
            case R.id.collection_layout:
                startActivity(new Intent(mActivity, InterestedActivity.class));
                break;
        }
    }
}
