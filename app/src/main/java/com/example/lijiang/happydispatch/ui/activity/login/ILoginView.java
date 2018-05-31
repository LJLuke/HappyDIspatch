package com.example.lijiang.happydispatch.ui.activity.login;

import com.example.lijiang.happydispatch.base.IBaseView;
import com.example.lijiang.happydispatch.entity.User;

/**
 * Created by lijiang on 2018/3/12.
 */

public interface ILoginView extends IBaseView{
    void login(User user);
}
