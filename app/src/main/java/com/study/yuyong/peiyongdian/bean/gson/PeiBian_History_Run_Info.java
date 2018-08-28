package com.study.yuyong.peiyongdian.bean.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @date on 16:03 2018/8/28
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 配电历史运行信息
 */
public class PeiBian_History_Run_Info {
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
        @SerializedName("ollst")
        private String guoZaiTimes; //过载累计时间
        @SerializedName("wllst")
        private String zhongZaiTimes;//重载累计时间
        @SerializedName("lllst")
        private String qingZaiTimes;//轻载累计时间
        @SerializedName("ellst")
        private String kongZaiTimes;//空载累计时间
        @SerializedName("unballst")
        private String buPingHengTimes;//不平衡累计时间
        @SerializedName("optlst")
        private String guoDianYaTimes;//过电压累计时间
        @SerializedName("lptlst")
        private String diDianYaTimes;//低电压累计时间
        @SerializedName("eptday")
        private int exceptionDays;//异常天数
        @SerializedName("avgc")
        private double averageCurrent;//平均电流
        @SerializedName("avgv")
        private double averageVoltage;//平均电压
        @SerializedName("avgc")
        private double averageLoadRate;//平均负载率

        public String getGuoZaiTimes() {
            return guoZaiTimes;
        }

        public void setGuoZaiTimes(String guoZaiTimes) {
            this.guoZaiTimes = guoZaiTimes;
        }

        public String getZhongZaiTimes() {
            return zhongZaiTimes;
        }

        public void setZhongZaiTimes(String zhongZaiTimes) {
            this.zhongZaiTimes = zhongZaiTimes;
        }

        public String getQingZaiTimes() {
            return qingZaiTimes;
        }

        public void setQingZaiTimes(String qingZaiTimes) {
            this.qingZaiTimes = qingZaiTimes;
        }

        public String getKongZaiTimes() {
            return kongZaiTimes;
        }

        public void setKongZaiTimes(String kongZaiTimes) {
            this.kongZaiTimes = kongZaiTimes;
        }

        public String getBuPingHengTimes() {
            return buPingHengTimes;
        }

        public void setBuPingHengTimes(String buPingHengTimes) {
            this.buPingHengTimes = buPingHengTimes;
        }

        public String getGuoDianYaTimes() {
            return guoDianYaTimes;
        }

        public void setGuoDianYaTimes(String guoDianYaTimes) {
            this.guoDianYaTimes = guoDianYaTimes;
        }

        public String getDiDianYaTimes() {
            return diDianYaTimes;
        }

        public void setDiDianYaTimes(String diDianYaTimes) {
            this.diDianYaTimes = diDianYaTimes;
        }

        public int getExceptionDays() {
            return exceptionDays;
        }

        public void setExceptionDays(int exceptionDays) {
            this.exceptionDays = exceptionDays;
        }

        public double getAverageCurrent() {
            return averageCurrent;
        }

        public void setAverageCurrent(double averageCurrent) {
            this.averageCurrent = averageCurrent;
        }

        public double getAverageVoltage() {
            return averageVoltage;
        }

        public void setAverageVoltage(double averageVoltage) {
            this.averageVoltage = averageVoltage;
        }

        public double getAverageLoadRate() {
            return averageLoadRate;
        }

        public void setAverageLoadRate(double averageLoadRate) {
            this.averageLoadRate = averageLoadRate;
        }
    }
}
