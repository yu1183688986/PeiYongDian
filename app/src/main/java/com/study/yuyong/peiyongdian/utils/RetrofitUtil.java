package com.study.yuyong.peiyongdian.utils;

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
        retrofit = new Retrofit.Builder()
                .baseUrl("")//设置网络请求时的Url地址
                .addConverterFactory(GsonConverterFactory.create())//设置数据解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                .build();
    }
    public Retrofit getRetrofit(){
        return retrofit;
    }
}
