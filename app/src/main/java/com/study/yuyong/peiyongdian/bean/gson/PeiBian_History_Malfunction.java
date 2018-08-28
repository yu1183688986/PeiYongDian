package com.study.yuyong.peiyongdian.bean.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @date on 16:24 2018/8/28
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 配变历史故障累计时间
 */
public class PeiBian_History_Malfunction {
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

    //X轴的单位是天，共有endDay-startDay天，每个点值代表某天的status状态的持续时间
    private class Data{
        @SerializedName("valueArray")
        private List<String> value;

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}
