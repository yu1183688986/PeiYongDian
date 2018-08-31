package com.sg.xjec.e800.peiyongdian.utils;
/**
 * @date on  2018/8/22
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 自己的活动父类，方便获取context
 */
import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
