package com.sg.xjec.e800.peiyongdian.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @date on 17:37 2018/8/28
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 使用枚举实现Retrofit的单例模式并介个Rxjava使用
 */
@SuppressWarnings("all")
public enum RetrofitUtil {
    RETROFIT;
    private Retrofit retrofit;
    RetrofitUtil(){
        //手动创建一个OkHttpClient并设置超时时间
        okhttp3.OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl("http://zp6bej.natappfree.cc/")//设置网络请求时的Url地址
                .addConverterFactory(GsonConverterFactory.create())//设置数据解析器
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                .build();
    }
    public Retrofit getRetrofit(){
        return retrofit;
    }
    public static void requestData(){

    }
}
