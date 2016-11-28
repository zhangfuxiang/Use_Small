package com.example.app.mvp.mvp.presenter;

import android.text.TextUtils;


import com.example.app.mvp.bean.User;
import com.example.app.mvp.mvp.model.MainModel;
import com.example.app.mvp.mvp.view.Baseview;

import rx.Subscriber;

/**
 * Created by Fuxiang.Zhang on 2016/11/24.
 */

public class MainPresenter implements BasePresenter {
    private Baseview mMainView;
    private MainModel mMainModel;
    public MainPresenter(){
        mMainModel=new MainModel();
    }

    @Override
    public void attachView(Baseview view) {
        mMainView=view;
    }

    @Override
    public void detachView() {
        mMainView=null;
    }

    @Override
    public void searchUser(String loginName) {
        if(TextUtils.isEmpty(loginName.trim())){
            mMainView.showErrorMessage("请输入合法登录名");
            return;
        }
        if (mMainModel!=null){
            mMainModel.getUser(new Subscriber<User>() {
                @Override
                public void onStart() {
                    //先显示对话框
                    mMainView.showProgressDialog();
                }
                @Override
                public void onCompleted() {
                    //请求结束，对话框消失
                    mMainView.hideProgressDialog();
                }

                @Override
                public void onError(Throwable e) {
                    mMainView.showErrorMessage("搜索失败");
                    mMainView.hideProgressDialog();
                }

                @Override
                public void onNext(User user) {
                    mMainView.showText(user);
                }
            },loginName);
        }

    }
}
