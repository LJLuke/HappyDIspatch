package com.example.lijiang.happydispatch.presenter.login;

import android.util.Log;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.entity.User;
import com.example.lijiang.happydispatch.model.login.ILoginModel;
import com.example.lijiang.happydispatch.model.login.LoginModel;
import com.example.lijiang.happydispatch.network.RequestManager;
import com.example.lijiang.happydispatch.network.RetrofitService;
import com.example.lijiang.happydispatch.ui.activity.login.ILoginView;

/**
 * Created by lijiang on 2018/3/12.
 */

public class LoginPresenter extends BasePresenter<ILoginView>{
    private ILoginModel mModel;
    public LoginPresenter(){
        mModel = new LoginModel();
    }

    public void login(String phoneNumber,String password){
        mModel.login(phoneNumber, password, new rx.Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(User user) {
                getMvpView().login(user);
            }
        });
    }
}
