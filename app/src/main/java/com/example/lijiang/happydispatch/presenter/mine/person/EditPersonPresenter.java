package com.example.lijiang.happydispatch.presenter.mine.person;

import com.example.lijiang.happydispatch.base.BasePresenter;
import com.example.lijiang.happydispatch.model.mine.person.EditPersonModel;
import com.example.lijiang.happydispatch.model.mine.person.IEditPersonModel;
import com.example.lijiang.happydispatch.network.ApiWrapper;
import com.example.lijiang.happydispatch.ui.activity.mine.person.IEditPersonView;

import rx.Subscriber;

/**
 * Created by lijiang on 2018/3/14.
 */

public class EditPersonPresenter extends BasePresenter<IEditPersonView> {
    private IEditPersonModel mModel;

    public EditPersonPresenter(){
        mModel = new EditPersonModel();
    }

    public void updateImage(String path){
       // File file = new File(path);
    //    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
     //   MultipartBody.Part part = MultipartBody.Part.createFormData("myfiles", file.getName(), requestBody);
        mModel.updateImage(path, new Subscriber<ApiWrapper>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(ApiWrapper apiWrapper) {
                getMvpView().updateImage(apiWrapper.getStatus());
            }
        });
    }
    public void updateMessage(int id,String userName,String nickName,String phone){
        mModel.updateMessage(id, userName, nickName, phone, new Subscriber<ApiWrapper>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ApiWrapper apiWrapper) {
                getMvpView().updateMessage(apiWrapper.status);
            }
        });
    }
}
