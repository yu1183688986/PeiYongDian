package com.study.yuyong.peiyongdian.bean.gson;
/**
 * @date on 20:39 2018/8/27
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 线路实时列表的实体类
 */
import java.util.List;

public class Line_Realtime_Lists {
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

        private List<Fdr> fdrList;

        public List<Fdr> getFdrList() {
            return fdrList;
        }

        public void setFdrList(List<Fdr> fdrList) {
            this.fdrList = fdrList;
        }

        private class Fdr{
            //线路名称
            private String name;
            //线路状态
            private String status;
            //线路所属变电站名称
            private String stationName;
            //线路最大允许电流
            private int maxCurrent;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStationName() {
                return stationName;
            }

            public void setStationName(String stationName) {
                this.stationName = stationName;
            }

            public int getMaxCurrent() {
                return maxCurrent;
            }

            public void setMaxCurrent(int maxCurrent) {
                this.maxCurrent = maxCurrent;
            }
        }

    }
}
