package com.study.yuyong.peiyongdian.bean.gson;
/**
 * @date on 10:38 2018/8/28
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 线路今日负荷曲线数据,每三十分钟一个点值，
 * 返回多少个点，跟当前时间有关，如下返回10个点，表示当前时间是05:00
 */
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Line_Today_Load {
    private Meta meta;
    private Data data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private class Meta{
        //本次接口调用是否成功，“0”表示成功
        private int code;
        //本次接口调用的描述信息“ok”表示成功
        private String msg;
        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

    }

    private class Data{
        //返回的数组数据数据
        @SerializedName("valueArray")
        private List<Double> value;

        public List<Double> getValueArray() {
            return value;
        }

        public void setValueArray(List<Double> value) {
            this.value = value;
        }
    }
}
