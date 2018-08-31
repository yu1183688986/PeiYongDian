package com.sg.xjec.e800.peiyongdian.bean.gson;

import java.util.List;

/**
 * @date on 11:05 2018/8/28
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 历史某个时间段内的线路运行状态
 */
public class Line_History_Statistics {
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
        //发生异常的线路总数
        private int eptNum;
        //x坐标
        private List<String> Xaxes;
        //y坐标
        private List<Integer> value;

        public int getEptNum() {
            return eptNum;
        }

        public void setEptNum(int eptNum) {
            this.eptNum = eptNum;
        }

        public List<String> getXaxes() {
            return Xaxes;
        }

        public void setXaxes(List<String> xaxes) {
            Xaxes = xaxes;
        }

        public List<Integer> getValue() {
            return value;
        }

        public void setValue(List<Integer> value) {
            this.value = value;
        }
    }
}
