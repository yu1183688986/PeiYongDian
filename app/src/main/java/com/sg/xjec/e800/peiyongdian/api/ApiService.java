package com.sg.xjec.e800.peiyongdian.api;

import com.sg.xjec.e800.peiyongdian.bean.gson.Line_History_Average_Load;
import com.sg.xjec.e800.peiyongdian.bean.gson.Line_History_Lists;
import com.sg.xjec.e800.peiyongdian.bean.gson.Line_History_Malfunction;
import com.sg.xjec.e800.peiyongdian.bean.gson.Line_History_Run_Info;
import com.sg.xjec.e800.peiyongdian.bean.gson.Line_History_Statistics;
import com.sg.xjec.e800.peiyongdian.bean.gson.Line_Load_Forecast;
import com.sg.xjec.e800.peiyongdian.bean.gson.Line_Realtime_Lists;
import com.sg.xjec.e800.peiyongdian.bean.gson.Line_Realtime_Run_Info;
import com.sg.xjec.e800.peiyongdian.bean.gson.Line_Realtime_Statistics;
import com.sg.xjec.e800.peiyongdian.bean.gson.Line_Today_Load;
import com.sg.xjec.e800.peiyongdian.bean.gson.PeiBian_History_Average_Load;
import com.sg.xjec.e800.peiyongdian.bean.gson.PeiBian_History_Lists;
import com.sg.xjec.e800.peiyongdian.bean.gson.PeiBian_History_Malfunction;
import com.sg.xjec.e800.peiyongdian.bean.gson.PeiBian_History_Run_Info;
import com.sg.xjec.e800.peiyongdian.bean.gson.PeiBian_History_Statistics;
import com.sg.xjec.e800.peiyongdian.bean.gson.PeiBian_Load_Forecast;
import com.sg.xjec.e800.peiyongdian.bean.gson.PeiBian_Realtime_Lists;
import com.sg.xjec.e800.peiyongdian.bean.gson.PeiBian_Realtime_Run_Info;
import com.sg.xjec.e800.peiyongdian.bean.gson.PeiBian_Realtime_Statistics;
import com.sg.xjec.e800.peiyongdian.bean.gson.PeiBian_Today_Load;
import com.sg.xjec.e800.peiyongdian.utils.PathConstants;


import java.util.Date;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @date on 9:23 2018/8/31
 * @author yuyong
 * @email yu1183688986@163.com
 * @description 网络请求服务接口
 */
@SuppressWarnings("all")
public interface ApiService {
    /*******************************************************
     * ============ *线路* 接收网络请求数据的方法 ============
     ******************************************************/
    /**
     * 线路实时状态
     * @return Observable<Line_Realtime_Statistics>
     */
    @GET(PathConstants.LINE_REALTIME_STATISTICS)
    Observable<Line_Realtime_Statistics> getLineRealtimeStatistics();

    /**
     * 线路实时列表
     * @param name 线路名称
     * @param status 线路状态
     * @param stationName 所属变电站名称
     * @return Observable<Line_Realtime_Lists>
     */
    @GET(PathConstants.LINE_REALTIME_LISTS)
    Observable<Line_Realtime_Lists> getLineRealtimeLists(@Path("name") String name
            ,@Path("status") String status,@Path("stationName") String stationName);

    /**
     * 获得单个线路实时运行信息
     * @param id 线路key
     * @return Observable<Line_Realtime_Run_Info>
     */
    @GET(PathConstants.LINE_HISTORY_RUN_INFO)
    Observable<Line_Realtime_Run_Info> getLineRealtimeRunInfo(@Path("id") int id);

    /**
     * 获得单个线路的今日负荷
     * @param id 线路key
     * @param type 遥测类型(1-A相电流,2-B相电流,3-C相电流)
     * @return Observable<Line_Today_Load>
     */
    @GET(PathConstants.LINE_TODAY_LOAD)
    Observable<Line_Today_Load> getLineTodayLoad(@Path("id") int id , @Path("type") int type);

    /**
     * 获得单条线路的负荷预测数据
     * @param id 线路key
     * @return Observable<Line_Load_Forecast>
     */
    @GET(PathConstants.LINE_LOAD_FORECAST)
    Observable<Line_Load_Forecast> getLineLoadForecast(@Path("id") int id);

    /**
     * 统计某个时间段内的线路运行状态
     * @param startDay 起始时间
     * @param endDay 终止时间
     * @return Observable<Line_History_Statistics>
     */
    @GET(PathConstants.LINE_HISTORY_STATISTICS)
    Observable<Line_History_Statistics> getLineHistoryStatistics(@Path("startDay") Date startDay ,
                                                                 @Path("endDay") Date endDay);

    /**
     * 获得某个时间段内符合输入条件的线路列表
     * @param name 线路名称
     * @param status 线路状态
     * @param stationName 所属变电站名称
     * @param startDay 起始时间
     * @param endDay 终止时间
     * @return Observable<Line_History_Lists>
     */
    @GET(PathConstants.LINE_HISTORY_LISTS)
    Observable<Line_History_Lists> getLineHistoryLists(@Path("name") String name, @Path("status") String status,
         @Path("stationName") String stationName, @Path("startDay") Date startDay, @Path("endDay") Date endDay);

    /**
     * 获得单条线路某个时间段内的运行信息
     * @param id 线路key
     * @param startDay 起始时间
     * @param endDay 终止时间
     * @return Observable<Line_History_Run_Info>
     */
    @GET(PathConstants.LINE_HISTORY_RUN_INFO)
    Observable<Line_History_Run_Info> getLineHistoryRunInfo(@Path("id") int id, @Path("startDay") Date startDay,
                                                            @Path("endDay") Date endDay);

    /**
     * 获得单条线路的历史故障累计时间
     * @param id 线路key
     * @param status 线路状态
     * @param startDay 起始时间
     * @param endDay 终止时间
     * @return Observable<Line_History_Malfunction>
     */
    @GET(PathConstants.LINE_HISTORY_MALFUNCTION)
    Observable<Line_History_Malfunction> getLineHistoryMalfunction(@Path("id") int id, @Path("status") String status,
                        @Path("startDay") Date startDay, @Path("endDay") Date endDay);

    /**
     * 获得单条线路的历史平均负荷曲线
     * @param id 线路key
     * @param startDay 起始时间
     * @param endDay 终止时间
     * @return Observable<Line_History_Average_Load>
     */
    @GET(PathConstants.LINE_HISTORY_AVERAGE_LOAD)
    Observable<Line_History_Average_Load> getLineHistoryAverageLoad(@Path("id") int id, @Path("startDay") Date startDay,
                                                                    @Path("endDay") Date endDay);

    /*******************************************************
     * ============ *配变* 接收网络请求数据的方法 ============
     ******************************************************/

    /**
     * 配变实时状态
     * @return Observable<PeiBian_Realtime_Statistics>
     */
    @GET(PathConstants.PEIBIAN_REALTIME_STATISTICS)
    Observable<PeiBian_Realtime_Statistics> getPeiBianRealtimeStatistics();

    /**
     * 获得配变实时列表
     * @param name 配变名称
     * @param status 配变状态
     * @param dSubName 所属配电房名称
     * @param fdrName 所属线路名称
     * @return Observable<PeiBian_Realtime_Lists>
     */
    @GET(PathConstants.PEIBIAN_REALTIME_LISTS)
    Observable<PeiBian_Realtime_Lists> getPeiBianRealtimeLists(@Path("name") String name,
         @Path("status") String status, @Path("dSubName") String dSubName, @Path("fdrName") String fdrName);

    /**
     * 获得单个配变实时运行信息
     * @param id 配变key
     * @return Observable<PeiBian_Realtime_Run_Info>
     */
    @GET(PathConstants.PEIBIAN_HISTORY_RUN_INFO)
    Observable<PeiBian_Realtime_Run_Info> getPeiBianRealtimeRunInfo(@Path("id") int id);

    /**
     * 获得单个配变的今日负荷
     * @param id 配变key
     * @param type 遥测类型(1-A相电流,2-B相电流,3-C相电流)
     * @return Observable<PeiBian_Today_Load>
     */
    @GET(PathConstants.PEIBIAN_TODAY_LOAD)
    Observable<PeiBian_Today_Load> getPeiBianTodayLoad(@Path("id") int id , @Path("type") int type);

    /**
     * 获得单个配变的负荷预测数据
     * @param id 配变key
     * @return Observable<PeiBian_Load_Forecast>
     */
    @GET(PathConstants.PEIBIAN_LOAD_FORECAST)
    Observable<PeiBian_Load_Forecast> getPeiBianLoadForecast(@Path("id") int id);

    /**
     * 统计某个时间段内的配变运行状态
     * @param startDay 起始时间
     * @param endDay 终止时间
     * @return Observable<PeiBian_History_Statistics>
     */
    @GET(PathConstants.PEIBIAN_HISTORY_STATISTICS)
    Observable<PeiBian_History_Statistics> getPeiBianHistoryStatistics(@Path("startDay") Date startDay ,
                                                                    @Path("endDay") Date endDay);

    /**
     * 获得某个时间段内符合输入条件的配变列表
     * @param name 配变名称
     * @param status 配变状态
     * @param dSubName 所属配电房名称
     * @param fdrName 所属线路名称
     * @param startDay 起始时间
     * @param endDay 终止时间
     * @return Observable<PeiBian_History_Lists>
     */
    @GET(PathConstants.PEIBIAN_HISTORY_LISTS)
    Observable<PeiBian_History_Lists> getPeiBianHistoryLists(@Path("name") String name, @Path("status") String status,
                                                @Path("dSubName") String dSubName, @Path("fdrName") String fdrName,
                                                @Path("startDay") Date startDay, @Path("endDay") Date endDay);

    /**
     * 获得单个配变某个时间段内的运行信息
     * @param id 配变key
     * @param startDay 起始时间
     * @param endDay 终止时间
     * @return Observable<PeiBian_History_Run_Info>
     */
    @GET(PathConstants.PEIBIAN_HISTORY_RUN_INFO)
    Observable<PeiBian_History_Run_Info> getPeiBianHistoryRunInfo(@Path("id") int id, @Path("startDay") Date startDay,
                                                               @Path("endDay") Date endDay);

    /**
     * 获得单个配变的历史故障累计时间
     * @param id 配变key
     * @param status 配变状态
     * @param startDay 起始时间
     * @param endDay 终止时间
     * @return Observable<PeiBian_History_Malfunction>
     */
    @GET(PathConstants.PEIBIAN_HISTORY_MALFUNCTION)
    Observable<PeiBian_History_Malfunction> getPeiBianHistoryMalfunction(@Path("id") int id, @Path("status") String status,
                                                         @Path("startDay") Date startDay, @Path("endDay") Date endDay);

    /**
     * 获得单个配变的历史平均负荷曲线
     * @param id 配变key
     * @param startDay 起始时间
     * @param endDay 终止时间
     * @return Observable<PeiBian_History_Average_Load>
     */
    @GET(PathConstants.PEIBIAN_HISTORY_AVERAGE_LOAD)
    Observable<PeiBian_History_Average_Load> getPeiBianHistoryAverageLoad(@Path("id") int id, @Path("startDay") Date startDay,
                                                                           @Path("endDay") Date endDay);
}
