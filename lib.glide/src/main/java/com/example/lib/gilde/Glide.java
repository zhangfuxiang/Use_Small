package com.example.lib.gilde;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by fuxiang.zhang on 2016/12/7.
 */

public class Glide {
    public static void with(Context context, String url, ImageView imageView){
        com.bumptech.glide.Glide.with(context).load(url).into(imageView);
    }
}
