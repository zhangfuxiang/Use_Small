package com.example.app.mvp.retrofit;



import com.example.app.mvp.bean.User;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Fuxiang.Zhang on 2016/11/24.
 */

public class HttpMethods {
    public static final String BASE_URL="https://api.github.com";
    private static final int DEFAULT_TIMEOUT=5;
    private Retrofit retrofit;
    private GithubService mGithubService;
    private static final HttpMethods INSTANCE=new HttpMethods();
    private HttpMethods(){

        OkHttpClient.Builder httpClientBuilder=new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit=new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        mGithubService=retrofit.create(GithubService.class);
    }
    //获取单例
    public static HttpMethods getInstance(){
        return INSTANCE;
    }
    public void getUser(Subscriber<User> subscriber, String loginName){
        mGithubService.getUser(loginName)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
