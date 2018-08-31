package com.sg.xjec.e800.peiyongdian.utils;
/**
 * @date on 17:52 2018/8/28
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 枚举类型的网络访问的url的path字符串
 */
@SuppressWarnings("all")
public class PathConstants {

    /********************************************************************
     ***************************** 配变path *****************************
     * ******************************************************************
     */

    /**
     * 配变实时状态path
     */
    public static final String  PEIBIAN_REALTIME_STATISTICS = "svc/realtime/statistics";
    /**
     * 配变实时列表path
     */
    public static final String  PEIBIAN_REALTIME_LISTS = "svc/realtime/list/{name}/{status}/{dSubName}/{fdrName}";
    /**
     * 配变实时运行信息
     */
    public static final String  PEIBIAN_REALTIME_RUN_INFO = "svc/realtime/info/{id}";
    /**
     * 单个配变今日负荷
     */
    public static final String  PEIBIAN_TODAY_LOAD = "svc/realtime/todayCurve/{id}/{type}";
    /**
     * 单个配变的负荷预测数据
     */
    public static final String  PEIBIAN_LOAD_FORECAST = "svc/realtime/forecastData/{id}";
    /**
     * 历史某个时间段配变运行状态统计
     */
    public static final String  PEIBIAN_HISTORY_STATISTICS = "svc/his/statistics/{startDay}/{endDay}";
    /**
     * 历史某个时间段内符合输入条件的配变列表
     */
    public static final String  PEIBIAN_HISTORY_LISTS = "svc/his/list/{name}/{status}/{dSubName}/{fdrName}/{startDay}/{endDay}";
    /**
     * 单个配变历史某个时间段内的运行信息
     */
    public static final String  PEIBIAN_HISTORY_RUN_INFO = "svc/his/info/{id}/{startDay}/{endDay}";
    /**
     * 单个配变的历史故障累计时间
     */
    public static final String  PEIBIAN_HISTORY_MALFUNCTION = "svc/his/statusLTCurve/{id}/{status}/{startDay}/{endDay}";
    /**
     * 单个配变的历史平均负荷
     */
    public static final String  PEIBIAN_HISTORY_AVERAGE_LOAD = "svc/his/avgLoadCurve/{id}/{startDay}/{endDay}";

    /********************************************************************
     ***************************** 线路path *****************************
     * ******************************************************************
     */

    /**
     * 线路实时状态统计
     */
    public static final String LINE_REALTIME_STATISTICS = "fdr/realtime/statistics";
    /**
     * 线路实时列表
     */
    public static final String LINE_REALTIME_LISTS = "fdr/realtime/list/{name}/{status}/{stationName}";
    /**
     * 单个线路实时运行信息
     */
    public static final String LINE_REALTIME_RUN_INFO = "fdr/realtime/info/{id}";
    /**
     * 单个线路的今日负荷曲线
     */
    public static final String LINE_TODAY_LOAD = "fdr/realtime/todayCurve/{id}/{type}";
    /**
     * 单条线路的负荷预测数据
     */
    public static final String LINE_LOAD_FORECAST = "fdr/realtime/forecastData/{id}";
    /**
     * 历史某个时间段内的线路运行状态统计
     */
    public static final String LINE_HISTORY_STATISTICS = "fdr/his/statistics/{startDay}/{endDay}";
    /**
     * 历史某个时间段内负荷输入条件的线路列表
     */
    public static final String LINE_HISTORY_LISTS = "fdr/his/list/{name}/{status}/{stationName}/{startDay}/{endDay}";
    /**
     * 单条线路历史某个时间段内的运行信息
     */
    public static final String LINE_HISTORY_RUN_INFO = "fdr/his/info/{id}/{startDay}/{endDay}";
    /**
     * 单条线路的历史故障累计时间
     */
    public static final String LINE_HISTORY_MALFUNCTION = "fdr/his/statusLTCurve/{id}/{status}/{startDay}/{endDay}";
    /**
     * 单条线路的历史平均负荷
     */
    public static final String LINE_HISTORY_AVERAGE_LOAD = "fdr/his/avgLoadCurve/{id}/{startDay}/{endDay}";

}
