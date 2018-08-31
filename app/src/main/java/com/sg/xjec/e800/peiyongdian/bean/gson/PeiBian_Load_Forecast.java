package com.sg.xjec.e800.peiyongdian.bean.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @date on 15:56 2018/8/28
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 配变负荷预测
 */
public class PeiBian_Load_Forecast {
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

    public class Meta{
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

    public class Data{
        @SerializedName("valueArray")
        private List<Double> value;
        private double twoHourMaxC; //预测线路两个小时后最大运行负荷
        private String twoHourStatus;//预测线路两个小时后最大负荷时的状态
        private double todayMaxC;//预测线路今日最大运行负荷
        private String todayMaxCStatus;//预测今日最大运行负荷时的状态
        private String todayMaxCTime;//预测今日最大运行负荷发生时间

        public List<Double> getValue() {
            return value;
        }

        public void setValue(List<Double> value) {
            this.value = value;
        }

        public double getTwoHourMaxC() {
            return twoHourMaxC;
        }

        public void setTwoHourMaxC(double twoHourMaxC) {
            this.twoHourMaxC = twoHourMaxC;
        }

        public String getTwoHourStatus() {
            return twoHourStatus;
        }

        public void setTwoHourStatus(String twoHourStatus) {
            this.twoHourStatus = twoHourStatus;
        }

        public double getTodayMaxC() {
            return todayMaxC;
        }

        public void setTodayMaxC(double todayMaxC) {
            this.todayMaxC = todayMaxC;
        }

        public String getTodayMaxCStatus() {
            return todayMaxCStatus;
        }

        public void setTodayMaxCStatus(String todayMaxCStatus) {
            this.todayMaxCStatus = todayMaxCStatus;
        }

        public String getTodayMaxCTime() {
            return todayMaxCTime;
        }

        public void setTodayMaxCTime(String todayMaxCTime) {
            this.todayMaxCTime = todayMaxCTime;
        }
    }
}
