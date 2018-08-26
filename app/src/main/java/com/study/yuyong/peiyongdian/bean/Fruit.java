package com.study.yuyong.peiyongdian.bean;
/**
 * @date on 11:30 2018/7/31
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 定义水果实体类
 */
public class Fruit {
    private String name;
    private int imageId;
    public Fruit(String name,int imageId){
        this.imageId = imageId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
