package com.study.yuyong.peiyongdian.fragments;

import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.study.yuyong.peiyongdian.R;

import java.util.ArrayList;

public class Realtime_state_Fragment extends Fragment {
    private BarChart mBarChart;
    private BarChart mBarChart1;
    private BarChart mBarChart2;

    private String[] color = {"#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD", "#C4FF8E", "#FFF88D", "#FFD38C", "#8CEBFF", "#FF8F9D", "#6BF3AD"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.realtime_state_fragment,container,false);

        // 创建多张图表
        mBarChart = (BarChart) view.findViewById(R.id.spreadBarChart);
        mBarChart1 = (BarChart) view.findViewById(R.id.spreadBarChart1);
        mBarChart2 = (BarChart) view.findViewById(R.id.spreadBarChart2);

        showBarChart(mBarChart, getBarData(10, 99), true);
        showBarChart(mBarChart1, getBarData(20, 199), true);
        showBarChart(mBarChart2, getBarData(20, 199), false);
        return view;
    }


    /**
     * 这个方法是初始化数据的
     *
     * @param count X 轴的个数
     * @param range Y 轴的数据
     */
    public BarData getBarData(int count, float range) {
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            xValues.add("" + (i + 1) + "");// 设置每个柱壮图的文字描述
        }

        ArrayList<BarEntry> yValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float value = (float) (Math.random() * range/*100以内的随机数*/) + 3;
            yValues.add(new BarEntry(value, i));
        }
        // y轴的数据集合
        BarDataSet barDataSet = new BarDataSet(yValues, "测试图");
        ArrayList<Integer> colors = new ArrayList<>();
        for (int i = 0; i < count; i++) {
//            colors.add(Color.parseColor("#75bfe2"));
            colors.add(Color.parseColor(color[i]));
        }
        barDataSet.setColors(colors);
        // 设置栏阴影颜色
        barDataSet.setBarShadowColor(Color.parseColor("#01000000"));
        ArrayList<IBarDataSet> barDataSets = new ArrayList<>();
        barDataSets.add(barDataSet);
        barDataSet.setValueTextColor(Color.parseColor("#FF8F9D"));
        // 绘制值
        barDataSet.setDrawValues(true);
        BarData barData = new BarData(barDataSets);
        return barData;
    }

    /**
     * @param barChart  控件
     * @param barData   数据
     * @param isSlither 用来控制是否可以滑动
     */
    public void showBarChart(BarChart barChart, BarData barData, boolean isSlither) {

        //设置值显示在柱状图的上边或者下边
        barChart.setDrawValueAboveBar(true);
        //设置绘制网格背景
        barChart.setDrawGridBackground(true);
        //设置双击缩放功能
        barChart.setDoubleTapToZoomEnabled(false);
        //设置规模Y启用
        barChart.setScaleYEnabled(false);
        //设置规模X启用
        barChart.setScaleXEnabled(false);
        //启用设置阻力
        barChart.setScaleEnabled(true);
        //设置每个拖动启用的高亮显示
        barChart.setHighlightPerDragEnabled(false);
        // 设置硬件加速功能
        barChart.setHardwareAccelerationEnabled(true);
        // 设置绘制标记视图
        barChart.setDrawMarkerViews(true);
        // 设置启用日志
        barChart.setLogEnabled(true);
        // 设置拖动减速功能
        barChart.setDragDecelerationEnabled(true);
        // 数据描述
        barChart.setDescription(new Description());
        barChart.setContentDescription("gogogogo");
        // 如果没有数据的时候，会显示这个，类似ListView的EmptyView
        barChart.setNoDataText("O__O …");
        // 是否显示表格颜色
        barChart.setDrawGridBackground(false);


        /**
         * 下面这几个属性你们可以试试 挺有意思的
         * */
        // 设置是否可以触摸
        barChart.setTouchEnabled(isSlither);
        // 是否可以拖拽
        barChart.setDragEnabled(isSlither);//放大可拖拽
        // 是否可以缩放
        barChart.setScaleEnabled(false);
        // 集双指缩放
        barChart.setPinchZoom(false);


        // 设置背景
        barChart.setBackgroundColor(Color.parseColor("#01000000"));
        // 如果打开，背景矩形将出现在已经画好的绘图区域的后边。
        barChart.setDrawGridBackground(false);
        // 集拉杆阴影
        barChart.setDrawBarShadow(false);
        // 图例
        barChart.getLegend().setEnabled(false);
        // 设置数据
        barChart.setData(barData);
        // 隐藏右边的坐标轴 (就是右边的0 - 100 - 200 - 300 ... 和图表中横线)
        barChart.getAxisRight().setEnabled(false);
        // 隐藏左边的左边轴 (同上)
        // 网格背景颜色
        barChart.setGridBackgroundColor(Color.parseColor("#00000000"));
        // 是否显示表格颜色
        barChart.setDrawGridBackground(false);
        // 设置边框颜色
        barChart.setBorderColor(Color.parseColor("#00000000"));
        // 拉杆阴影
        barChart.setDrawBarShadow(false);
        // 打开或关闭绘制的图表边框。（环绕图表的线）
        barChart.setDrawBorders(false);
        Legend mLegend = barChart.getLegend(); // 设置比例图标示
        // 设置窗体样式
        mLegend.setForm(Legend.LegendForm.CIRCLE);
        // 字体
        mLegend.setFormSize(4f);
        // 字体颜色
        mLegend.setTextColor(Color.parseColor("#00000000"));
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setSpaceMax(2);
//        xAxis.setTextColor(0x000000); // 设置轴标签的颜色。
//        xAxis.setTextSize(18); // 设置轴标签的文字大小。
//        xAxis.setTypeface( ) ;// 设置轴标签的 Typeface。
//        xAxis.setGridColor( int color); /// 设置该轴的网格线颜色。
//        xAxis.setGridLineWidth( float width);// 设置该轴网格线的宽度。
//        xAxis.setAxisLineColor( int color); // 设置轴线的轴的颜色。
//        xAxis.setAxisLineWidth( float width);// 设置该轴轴行的宽度。
//        barChart.animateY(1000); // 立即执行的动画,Y轴

        if (isSlither) {
            //当为true时,放大图
            // 为了使 柱状图成为可滑动的,将水平方向 放大 2.5倍
            barChart.invalidate();
            Matrix mMatrix = new Matrix();
            mMatrix.postScale(2f, 1f);
            barChart.getViewPortHandler().refresh(mMatrix, barChart, false);
            barChart.animateY(1000);
        } else {
            //当为false时 不对图进行操作
            barChart.animateY(1000);
        }


    }

}
