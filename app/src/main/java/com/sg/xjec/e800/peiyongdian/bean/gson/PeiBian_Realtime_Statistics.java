package com.sg.xjec.e800.peiyongdian.bean.gson;

/**
 * @date on 19:27 2018/8/27
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 配变实时状态统计Json数据实体类
 */
import java.util.List;

public class PeiBian_Realtime_Statistics {
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
        //x坐标
        private List<String> Xaxes;
        //y坐标
        private List<Integer> value;

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
