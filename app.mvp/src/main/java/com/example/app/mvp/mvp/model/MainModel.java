package com.example.app.mvp.mvp.model;



import com.example.app.mvp.bean.User;
import com.example.app.mvp.retrofit.HttpMethods;

import rx.Subscriber;

/**
 * Created by Fuxiang.Zhang on 2016/11/24.
 */

public class MainModel implements BaseModel {
    @Override
    public void getUser(Subscriber<User> subscriber, String loginName) {
        HttpMethods.getInstance().getUser(subscriber,loginName);
    }
}
