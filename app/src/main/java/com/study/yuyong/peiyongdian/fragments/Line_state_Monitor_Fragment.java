package com.study.yuyong.peiyongdian.fragments;
/**
 * @date on 16:39 2018/8/25
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 线路状态监视对应碎片
 */

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.study.yuyong.peiyongdian.R;
import com.study.yuyong.peiyongdian.utils.DayAxisValueFormatter;
import com.study.yuyong.peiyongdian.utils.MyApplication;
import com.study.yuyong.peiyongdian.utils.MyAxisValueFormatter;
import com.study.yuyong.peiyongdian.utils.MyValueFormatter;
import com.study.yuyong.peiyongdian.utils.XYMarkerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line_state_Monitor_Fragment extends Fragment implements OnChartValueSelectedListener{

    private SwipeRefreshLayout swipeRefresh;
    private BarChart mBarChart;

    //记录数据中的最大值动态调整y轴
    private int Max_value;
    private YAxis leftAxis,rightAxis;
    //数据集合
    ArrayList<BarEntry> yVals1;
    private ViewHolder holder;

    class ViewHolder{
        TextView guozai;
        TextView chongzai;
        TextView bupingheng;
        TextView guodianya;
        TextView qiandianya;
        List<TextView> state = new ArrayList<>();
        public ViewHolder(View view){
            guozai = view.findViewById(R.id.guozai_num);
            state.add(guozai);
            chongzai = view.findViewById(R.id.chongzai_num);
            state.add(chongzai);
            bupingheng = view.findViewById(R.id.bupingheng_num);
            state.add(bupingheng);
            guodianya = view.findViewById(R.id.guodianya_num);
            state.add(guodianya);
            qiandianya = view.findViewById(R.id.qiandianya_num);
            state.add(qiandianya);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.line_state_monitor_fragment,container,false);

        mBarChart = view.findViewById(R.id.mBarChart);
        holder = new ViewHolder(view);
        initView();
        //开启刷新功能
        swipeRefresh = view.findViewById(R.id.swipe_refresh_1);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //模拟服务器请求数据
                final List<Integer> list = new ArrayList();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (yVals1 != null){
                            yVals1.clear();
                        }
                        Random random = new Random();
                        Max_value = 100;
                        for (int i=1; i<6;i++){
                            int value = random.nextInt(100);
                            list.add(value);
                            yVals1.add(new BarEntry(i,value));
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mBarChart.setMaxVisibleValueCount(Max_value);
                                leftAxis.setAxisMaximum(Max_value);
                                rightAxis.setAxisMaximum(Max_value);
                                setData(yVals1);
                                mBarChart.setNoDataText("正在加载数据...");
                                mBarChart.animateXY(1000, 1000);
                                mBarChart.invalidate();
                                swipeRefresh.setRefreshing(false);
                                for (int i=0;i<list.size();i++){
                                    holder.state.get(i).setText(String.valueOf(list.get(i)));
                                }
                            }
                        });
                    }
                }).start();
            }
        });
        return view;
    }

    //初始化条形图设置
    private void initView(){
        //设置表格上的点，被点击的时候，的回调函数
        mBarChart.setOnChartValueSelectedListener(this);
        //绘制当前展示的内容顶部阴影
        mBarChart.setDrawBarShadow(true);
        //绘制的图形都在bar的顶部
        mBarChart.setDrawValueAboveBar(true);
        mBarChart.getDescription().setEnabled(false);
        /*Description description = new Description();
        description.setText("状态");
        description.setTextColor(Color.RED);
        description.setTextSize(10);
        mBarChart.setDescription(description);*/
        //设置边框
        mBarChart.setBorderWidth(1f);
        mBarChart.setDragEnabled(true);
        mBarChart.setScaleEnabled(true);
        // y方向最大值--------------在线获取数据时要传值
        mBarChart.setMaxVisibleValueCount(60);
        mBarChart.fitScreen();
        mBarChart.setNoDataText("正在加载数据...");
        // 双指缩放
        mBarChart.setPinchZoom(true);
        //是否显示表格颜色---绘制中心内容区域背景色
        mBarChart.setDrawGridBackground(false);
        //显示xy轴动画
        mBarChart.animateXY(2000, 2000);
        paintXY();
    }

    /**
     * 绘制x和y轴，可以绘制一条也可以绘制两条
     */

    private void paintXY(){
        IAxisValueFormatter xAxisFormatter = new MyAxisValueFormatter(mBarChart);
        XAxis xAxis = mBarChart.getXAxis();
        //设置x轴的数据格式器
        xAxis.setValueFormatter(xAxisFormatter);
        //x轴显示的位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //是否绘制竖直分割线
        xAxis.setDrawGridLines(false);
        // 底部label的分割间隙,只有1天的时间间隔
        xAxis.setGranularity(1f);
        //对应的当前绘制在底部的label数
        xAxis.setLabelCount(5);
        xAxis.setTextSize(14);
        //x轴最大最小值
        xAxis.setAxisMaximum(6);
        xAxis.setAxisMinimum(0f);
        //设置标签居中显示
        xAxis.setCenterAxisLabels(false);

        //设置悬浮显示高亮
        XYMarkerView mv = new XYMarkerView(MyApplication.getContext(), xAxisFormatter);
        mv.setChartView(mBarChart);
        mBarChart.setMarker(mv);

        leftAxis = mBarChart.getAxisLeft();
        leftAxis.setLabelCount(6, false);
        //不显示网格线
       // leftAxis.setDrawGridLines(false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        //这个替换setStartAtZero(true)
        leftAxis.setAxisMinimum(0f);
        leftAxis.setAxisMaximum(60);

        //设置右边y轴
        rightAxis = mBarChart.getAxisRight();
        //让右边轴不显示
        rightAxis.setEnabled(false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(8, false);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f);
        rightAxis.setAxisMaximum(60);

        // 设置图例，就是那个一组y的value的
        Legend legend = mBarChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        //样式
        legend.setForm(Legend.LegendForm.SQUARE);
        //字体
        legend.setFormSize(9f);
        //大小
        legend.setTextSize(11f);
        legend.setXEntrySpace(4f);



        //模拟数据
        yVals1 = new ArrayList<BarEntry>();
       // yVals1.add(new BarEntry(0, 0));
        yVals1.add(new BarEntry(1, 10));
        yVals1.add(new BarEntry(2, 20));
        yVals1.add(new BarEntry(3, 30));
        yVals1.add(new BarEntry(4, 40));
        yVals1.add(new BarEntry(5, 33));
        holder.guozai.setText("10");
        holder.chongzai.setText("20");
        holder.bupingheng.setText("30");
        holder.guodianya.setText("40");
        holder.qiandianya.setText("33");

        setData(yVals1);
    }

    /**
     * 设置数据
     * @param yVals1
     */
    private void setData(ArrayList yVals1) {
        float start = 1f;
        BarDataSet set1;
        if (mBarChart.getData() != null &&
                mBarChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mBarChart.getData().getDataSetByIndex(0);
            //set1.setDrawValues(true);
            set1.setValues(yVals1);
            mBarChart.getData().notifyDataChanged();
            mBarChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "线路状态监视");
            //设置有五种颜色
            set1.setColors(ColorTemplate.PASTEL_COLORS);
            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setValueFormatter(new MyValueFormatter());
            //设置条形宽度
            data.setBarWidth(0.5f);
            //设置数据
            mBarChart.setData(data);
        }
    }
    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
