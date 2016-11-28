package com.example.app.mvp.mvp.model;



import com.example.app.mvp.bean.User;

import rx.Subscriber;

/**
 * Created by Fuxiang.Zhang on 2016/11/24.
 */

public interface BaseModel {
    void getUser(Subscriber<User> subscriber, String loginName);

}
