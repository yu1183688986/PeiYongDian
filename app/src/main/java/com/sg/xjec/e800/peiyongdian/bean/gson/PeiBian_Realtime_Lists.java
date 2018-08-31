package com.sg.xjec.e800.peiyongdian.bean.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @date on 15:26 2018/8/28
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 配变实时列表
 */
public class PeiBian_Realtime_Lists {
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
        private List<Svc> svcList;

        public List<Svc> getSvcList() {
            return svcList;
        }

        public void setSvcList(List<Svc> svcList) {
            this.svcList = svcList;
        }

        public class Svc{
            private String name;//配变名称
            private String status;//配变状态
            @SerializedName("dSubName")
            private String powerRoomName;//配变所属配电房
            @SerializedName("fdrName")
            private String lineName;//配变所属线路

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

            public String getPowerRoomName() {
                return powerRoomName;
            }

            public void setPowerRoomName(String powerRoomName) {
                this.powerRoomName = powerRoomName;
            }

            public String getLineName() {
                return lineName;
            }

            public void setLineName(String lineName) {
                this.lineName = lineName;
            }
        }
    }
}
