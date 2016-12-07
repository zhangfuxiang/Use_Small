package com.example.app.image_load;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.lib.gilde.Glide;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    public String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Glide.with(this,url,imageView);
    }

    private void init() {
        imageView= (ImageView) findViewById(R.id.img_view);
        url="https://raw.githubusercontent.com/zhangfuxiang/storage/master/image/2.jpg";
    }
}
