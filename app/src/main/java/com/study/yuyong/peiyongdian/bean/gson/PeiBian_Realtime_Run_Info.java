package com.study.yuyong.peiyongdian.bean.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @date on 15:48 2018/8/28
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 单个配变实时运行信息
 */
public class PeiBian_Realtime_Run_Info {
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
        @SerializedName("apc")
        private double A_Phase_Current;//A相电流
        @SerializedName("bpc")
        private double B_Phase_Current;//B相电流
        @SerializedName("cpc")
        private double C_Phase_Current;//C相电流
        @SerializedName("apv")
        private double A_Phase_Voltage;//A相电压
        @SerializedName("bpv")
        private double B_Phase_Voltage;//A相电流
        @SerializedName("cpv")
        private double C_Phase_Voltage;//A相电流
        @SerializedName("np")
        private double Active_power;//有功功率
        @SerializedName("nq")
        private double Reactive_power;//无功功率
        //----------------------------------------------
        @SerializedName("apc")
        private double Load_factor;//负载率

        public double getA_Phase_Current() {
            return A_Phase_Current;
        }

        public void setA_Phase_Current(double a_Phase_Current) {
            A_Phase_Current = a_Phase_Current;
        }

        public double getB_Phase_Current() {
            return B_Phase_Current;
        }

        public void setB_Phase_Current(double b_Phase_Current) {
            B_Phase_Current = b_Phase_Current;
        }

        public double getC_Phase_Current() {
            return C_Phase_Current;
        }

        public void setC_Phase_Current(double c_Phase_Current) {
            C_Phase_Current = c_Phase_Current;
        }

        public double getA_Phase_Voltage() {
            return A_Phase_Voltage;
        }

        public void setA_Phase_Voltage(double a_Phase_Voltage) {
            A_Phase_Voltage = a_Phase_Voltage;
        }

        public double getB_Phase_Voltage() {
            return B_Phase_Voltage;
        }

        public void setB_Phase_Voltage(double b_Phase_Voltage) {
            B_Phase_Voltage = b_Phase_Voltage;
        }

        public double getC_Phase_Voltage() {
            return C_Phase_Voltage;
        }

        public void setC_Phase_Voltage(double c_Phase_Voltage) {
            C_Phase_Voltage = c_Phase_Voltage;
        }

        public double getActive_power() {
            return Active_power;
        }

        public void setActive_power(double active_power) {
            Active_power = active_power;
        }

        public double getReactive_power() {
            return Reactive_power;
        }

        public void setReactive_power(double reactive_power) {
            Reactive_power = reactive_power;
        }

        public double getLoad_factor() {
            return Load_factor;
        }

        public void setLoad_factor(double load_factor) {
            Load_factor = load_factor;
        }
    }
}
