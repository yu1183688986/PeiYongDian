package com.study.yuyong.peiyongdian.bean.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @date on 16:26 2018/8/28
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 单个配变的历史平均负荷
 */
public class PeiBian_History_Average_Load {
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
    //X轴的单位是天，共有endDay-startDay天，每个点值代表某天的平均负荷
    private class Data{
        @SerializedName("valueArray")
        private List<Double> value;

        public List<Double> getValue() {
            return value;
        }

        public void setValue(List<Double> value) {
            this.value = value;
        }
    }
}
