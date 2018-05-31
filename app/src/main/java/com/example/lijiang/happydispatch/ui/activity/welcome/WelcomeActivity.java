package com.example.lijiang.happydispatch.ui.activity.welcome;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.sharePreferences.SpHelper;
import com.example.lijiang.happydispatch.ui.activity.MainActivity;
import com.example.lijiang.happydispatch.ui.activity.login.LoginActivity;

public class WelcomeActivity extends AppCompatActivity {

    private SpHelper mSpHelper;

    private Boolean isFirst;

    private Handler sHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                    finish();
                    break;
                case 2:
                    startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                    finish();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
    }

    private void initView(){
        mSpHelper = new SpHelper(this,"login");
        isFirst = mSpHelper.getBoolean("isFirst");
        if (!isFirst){
            sHandler.sendEmptyMessageDelayed(1,3000);
        }else {
            sHandler.sendEmptyMessageDelayed(2,3000);
        }
    }
}
