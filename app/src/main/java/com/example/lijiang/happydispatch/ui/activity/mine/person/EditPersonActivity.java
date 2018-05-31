package com.example.lijiang.happydispatch.ui.activity.mine.person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.network.RequestManager;
import com.example.lijiang.happydispatch.network.RetrofitService;
import com.example.lijiang.happydispatch.presenter.mine.person.EditPersonPresenter;
import com.example.lijiang.happydispatch.sharePreferences.SpHelper;
import com.example.lijiang.happydispatch.ui.activity.MainActivity;
import com.example.lijiang.happydispatch.util.NormalUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class EditPersonActivity extends AppCompatActivity implements View.OnClickListener,IEditPersonView{

    private EditPersonPresenter mPresenter;
    private SpHelper mUserHelper;
    private String mImagePath;

    private TextView mChangeImage;
    private CircleImageView mUserImage;

    private EditText mNikeName;
    private EditText mTrueName;
    private EditText mPhone;

    private Button mSaveMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);
        initView();
    }

    private void initView(){
        mPresenter = new EditPersonPresenter();
        mPresenter.attachView(this);
        mUserHelper = new SpHelper(this,"user");

        mChangeImage = findViewById(R.id.change_iamge);
        mChangeImage.setOnClickListener(this);

        mNikeName = findViewById(R.id.nick_name);
        mTrueName = findViewById(R.id.true_name);
        mPhone = findViewById(R.id.default_phone);
        mNikeName.setText(mUserHelper.getString("tName"));
        mTrueName.setText(mUserHelper.getString("name"));
        mPhone.setText(mUserHelper.getString("phone"));

        mUserImage = findViewById(R.id.user_image);
        mSaveMessage = findViewById(R.id.save_message);
        mSaveMessage.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    Glide.with(this).load(selectList.get(0).getPath()).into(mUserImage);
                    mImagePath = selectList.get(0).getCompressPath();
                    break;
            }
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.change_iamge:
                PictureSelector.create(EditPersonActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)
                        .isCamera(true)
                        .compress(true)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
                break;
            case R.id.save_message:
                if (mImagePath != null){
                    mPresenter.updateImage(mImagePath);
                }
                NormalUtil.toast(this,mUserHelper.getInt("userId")+"");
                mPresenter.updateMessage(mUserHelper.getInt("userId"),mTrueName.getText().toString(),
                        mNikeName.getText().toString(),mPhone.getText().toString());
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
    public void updateImage(int status) {
        if (status == 1){
            NormalUtil.toast(this,"保存成功");
        }else {
            NormalUtil.toast(this,"保存失败");
        }
    }

    @Override
    public void updateMessage(int status) {
        if (status == 1){
            mUserHelper.putValues(new SpHelper.ContentValue("phone",mPhone.getText().toString()));
            mUserHelper.putValues(new SpHelper.ContentValue("tName",mNikeName.getText().toString()));
            mUserHelper.putValues(new SpHelper.ContentValue("name",mTrueName.getText().toString()));
            Intent intent = new Intent();
            intent.putExtra("tName",mNikeName.getText().toString());
            setResult(1,intent);
            NormalUtil.toast(this,"保存成功");
        }else {
            NormalUtil.toast(this,"保存失败");
        }
    }
}
