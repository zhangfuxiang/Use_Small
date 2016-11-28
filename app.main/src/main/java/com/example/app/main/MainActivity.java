package com.example.app.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.wequick.small.Small;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_home, R.id.btn_mvp, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
                Small.openUri("home", this);
                break;
            case R.id.btn_mvp:
                Small.openUri("mvp", this);
                break;
            case R.id.btn_next:
                Small.openUri("test", this);
                break;
        }
    }
}
