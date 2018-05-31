package com.example.lijiang.happydispatch.ui.activity.login;

import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.entity.User;
import com.example.lijiang.happydispatch.presenter.login.LoginPresenter;
import com.example.lijiang.happydispatch.sharePreferences.SpHelper;
import com.example.lijiang.happydispatch.ui.activity.MainActivity;
import com.example.lijiang.happydispatch.util.NormalUtil;
import com.github.zackratos.ultimatebar.UltimateBar;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginView{

    private Button mQuickLogin;
    private Button mPasswordLogin;
    private Button mLogin;

    private EditText mPhoneNumber;
    private EditText mPassword;

    private TextView mVerifyCode;

    private LoginPresenter mPresenter;

    private SpHelper mLoginHelper;
    private SpHelper mUserHelper;
    private boolean isFirstLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UltimateBar.newTransparentBuilder()
                .statusColor(Color.WHITE)        // 状态栏颜色
                .statusAlpha(50)               // 状态栏透明度
                .build(this)
                .apply();
        initView();
        //isFirstLogin();
        autoLogin();
    }

    private void initView(){
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);

        mQuickLogin = findViewById(R.id.login_quick);
        mPasswordLogin = findViewById(R.id.login_password);
        mLogin = findViewById(R.id.login);
        mPhoneNumber = findViewById(R.id.phone_number);
        mPassword = findViewById(R.id.password);
        mVerifyCode = findViewById(R.id.verify_code);

        mLogin.setOnClickListener(this);
        mQuickLogin.setOnClickListener(this);
        mPasswordLogin.setOnClickListener(this);
        mVerifyCode.setOnClickListener(this);

        mLoginHelper = new SpHelper(this, "login");
        mUserHelper = new SpHelper(this,"user");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_quick:
                mVerifyCode.setVisibility(View.VISIBLE);
                mPasswordLogin.setBackgroundResource(R.drawable.shape_label_gray);
                mQuickLogin.setBackgroundResource(R.drawable.shape_label);
                mPassword.setHint("请输入验证码");
                break;
            case R.id.login_password:
                mVerifyCode.setVisibility(View.INVISIBLE);
                mQuickLogin.setBackgroundResource(R.drawable.shape_label_gray);
                mPasswordLogin.setBackgroundResource(R.drawable.shape_label);
                mPassword.setHint("请输入密码");
                break;
            case R.id.login:
                String phoneNumber = mPhoneNumber.getText().toString();
                String password = mPassword.getText().toString();
                mPresenter.login(phoneNumber,password);
                break;
            case R.id.verify_code:
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
    public void login(User user) {
        if (user.getStatus() == 1){
            mLoginHelper.putValues(new SpHelper.ContentValue("phone",user.getO().getPhone()));
            mLoginHelper.putValues(new SpHelper.ContentValue("password",user.getO().getPassword()));
            mLoginHelper.putValues(new SpHelper.ContentValue("isFirst",false));
            mUserHelper.putValues(new SpHelper.ContentValue("userId",user.getO().getUserId()));
            mUserHelper.putValues(new SpHelper.ContentValue("phone",user.getO().getPhone()));
            mUserHelper.putValues(new SpHelper.ContentValue("tName",user.getO().getTName()));
            mUserHelper.putValues(new SpHelper.ContentValue("name",user.getO().getName()));
            NormalUtil.toast(this,user.getMessage());
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }else {
            NormalUtil.toast(this,user.getMessage());
        }
    }

    private void isFirstLogin(){
        boolean isFirst = mLoginHelper.getBoolean("isFirst");
        isFirstLogin = isFirst;
        if (isFirst){
            mLoginHelper.putValues(new SpHelper.ContentValue("isFirst",false));
        }
    }

    private void autoLogin(){
        if (!mLoginHelper.getBoolean("isFirst")){
            String phoneNumber = mLoginHelper.getString("phone");
            String password = mLoginHelper.getString("password");
            mPresenter.login(phoneNumber,password);
        }
    }
}
