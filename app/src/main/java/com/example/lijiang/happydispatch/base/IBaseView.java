package com.example.lijiang.happydispatch.base;

/**
 * Created by lijiang on 2018/2/12.
 */

public interface IBaseView {
    void showLoadingDialog();
    void cancelLoadingDialog();
    void showErrorMsg(String errorMsg);
}
