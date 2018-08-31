package com.sg.xjec.e800.peiyongdian.bean.gson;

import java.util.List;
/**
 * @date on 11:13 2018/8/28
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 历史某个时间段内负荷输入条件的线路列表
 */
public class Line_History_Lists {
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
