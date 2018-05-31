package com.example.lijiang.happydispatch.ui.activity.mine.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.sharePreferences.SpHelper;
import com.example.lijiang.happydispatch.ui.activity.MainActivity;
import com.example.lijiang.happydispatch.ui.activity.login.LoginActivity;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mLoginOut;
    private SpHelper mSpHelper;
    private SpHelper mUserHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mSpHelper = new SpHelper(this,"login");
        mUserHelper = new SpHelper(this,"user");
        mLoginOut = findViewById(R.id.login_out);
        mLoginOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_out:
                mSpHelper.clear();
                mUserHelper.clear();
                startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                finish();
                break;
        }
    }
}
