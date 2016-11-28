package com.example.app.mvp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.mvp.bean.User;
import com.example.app.mvp.mvp.presenter.MainPresenter;
import com.example.app.mvp.mvp.view.Baseview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Baseview {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.ed_text)
    EditText edText;
    private ProgressDialog dialog;
    private MainPresenter mMainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        mMainPresenter=new MainPresenter();
        mMainPresenter.attachView(this);
    }

    private void initView() {
        dialog=new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("正在搜索中");
    }

    @OnClick(R.id.search_btn)
    public void onClick() {
        mMainPresenter.searchUser(edText.getText().toString());
    }

    @Override
    public void showProgressDialog() {
        dialog.show();
    }

    @Override
    public void hideProgressDialog() {
        dialog.dismiss();
    }

    @Override
    public void showText(User userbean) {
        String temp=getResources().getString(R.string.user_format);
        String str=String.format(temp,userbean.getLogin(),userbean.getName(),userbean.getFollowers(),userbean.getFollowing());
        String str1=userbean.getLogin()+"  "+userbean.getName();
        tv.setText(str);
    }

    @Override
    public void showErrorMessage(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMainPresenter!=null)
            mMainPresenter.detachView();
    }
}
