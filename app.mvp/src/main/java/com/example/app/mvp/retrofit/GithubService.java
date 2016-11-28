package com.example.app.mvp.retrofit;



import com.example.app.mvp.bean.User;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Fuxiang.Zhang on 2016/11/24.
 */

public interface GithubService {
    @GET("/users/{user}")
    Observable<User> getUser(@Path("user") String username);
}
