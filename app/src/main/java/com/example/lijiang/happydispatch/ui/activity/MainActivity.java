package com.example.lijiang.happydispatch.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lijiang.happydispatch.R;
import com.example.lijiang.happydispatch.ui.fragment.classify.ClassifyFragment;
import com.example.lijiang.happydispatch.ui.fragment.homePage.HomePageFragment;
import com.example.lijiang.happydispatch.ui.fragment.mine.MineFragment;
import com.example.lijiang.happydispatch.ui.fragment.shopBus.ShopBusFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomBar mBottomBar;
    private FragmentTransaction mTransaction;
    private Fragment currentFragment = new Fragment();

    protected String[] needPermissions = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CAMERA
    };

    private static final int PERMISSON_REQUESTCODE = 0;
    private boolean isNeedCheck = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomBar = findViewById(R.id.bottom_be);
        mBottomBar.selectTabAtPosition(0);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                if (tabId == R.id.bottom_home_page){
                    switchFragment(new HomePageFragment()).commit();
                }else if (tabId == R.id.bottom_classify){
                    switchFragment(new ClassifyFragment()).commit();
                }else if (tabId == R.id.bottom_shop_bus){
                    switchFragment(new ShopBusFragment()).commit();
                }else if (tabId == R.id.bottom_me){
                    MineFragment mineFragment = new MineFragment();
                    switchFragment(new MineFragment()).commit();
                }
            }
        });
    }
    private FragmentTransaction switchFragment(Fragment targetFragment){
        mTransaction = getSupportFragmentManager().beginTransaction();
        if (!targetFragment.isAdded()){
            if (currentFragment != null){
                mTransaction.hide(currentFragment);
            }
            mTransaction.add(R.id.fragment_container,targetFragment,targetFragment.getClass().getName());
        }else {
            mTransaction.hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return mTransaction;
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(isNeedCheck){
            checkPermissions(needPermissions);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void checkPermissions(String... permissions) {
        List<String> needRequestPermissonList = findDeniedPermissions(permissions);
        if (null != needRequestPermissonList
                && needRequestPermissonList.size() > 0) {
            ActivityCompat.requestPermissions(this,
                    needRequestPermissonList.toArray(
                            new String[needRequestPermissonList.size()]),
                    PERMISSON_REQUESTCODE);
        }
    }
    private List<String> findDeniedPermissions(String[] permissions) {
        List<String> needRequestPermissonList = new ArrayList<String>();
        for (String perm : permissions) {
            if (ContextCompat.checkSelfPermission(this,
                    perm) != PackageManager.PERMISSION_GRANTED) {
                needRequestPermissonList.add(perm);
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this, perm)) {
                    needRequestPermissonList.add(perm);
                }
            }
        }
        return needRequestPermissonList;
    }
    private boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] paramArrayOfInt) {
        if (requestCode == PERMISSON_REQUESTCODE) {
            if (!verifyPermissions(paramArrayOfInt)) {
                //showMissingPermissionDialog();
                isNeedCheck = false;
            }
        }
    }
}
