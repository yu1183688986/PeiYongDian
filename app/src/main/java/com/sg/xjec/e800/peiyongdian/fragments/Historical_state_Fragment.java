package com.sg.xjec.e800.peiyongdian.fragments;
/**
 * @date on 16:40 2018/8/25
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 历史状态对应碎片
 */
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.sg.xjec.e800.peiyongdian.R;

import java.util.ArrayList;

import static com.github.mikephil.charting.components.YAxis.YAxisLabelPosition.INSIDE_CHART;

public class Historical_state_Fragment extends Fragment {
    private LineChart mChart;

    private int[] mColors = new int[]{
            Color.parseColor("#5abdfc"),    //蓝色
            Color.parseColor("#eb73f6")    //紫色
    };

    protected String[] mMonths = new String[]{
            "1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.historical_state_fragment,container,false);
        mChart = (LineChart) view.findViewById(R.id.chart);
        initChartView();

        /**-------------这里的数据不重要，主要用随机数的方式生成点坐标-------------**/
        //设置模拟数据
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        for (int i = 0; i < 12; i++) {
            yVals.add(new Entry(i, (float) (Math.random() * 10000f)));
        }

        ArrayList<Entry> yVals2 = new ArrayList<Entry>();
        for (int i = 0; i < 12; i++) {
            yVals2.add(new Entry(i, (float) (Math.random() * 10000f)));
        }

        addDataSet(yVals, "一居");
        addDataSet(yVals2, "两居");
        /**--------------------------**/

        //图标的下边的指示块  图例
        Legend l = mChart.getLegend();
        l.setForm(Legend.LegendForm.LINE);
        l.setXEntrySpace(40);
        return view;
    }


    private void initChartView() {
        mChart.setDrawGridBackground(false);
        mChart.setDescription(null);    //右下角说明文字
        mChart.setDrawBorders(true);    //四周是不是有边框
        mChart.setBorderWidth(0.5f);
        mChart.setBorderColor(Color.parseColor("#b3b3b3"));    //边框颜色，默认黑色？
//        mChart.setVisibleXRangeMaximum(4);

        // enable touch gestures
        mChart.setTouchEnabled(true);
        // if disabled, scaling can be done on x- and y-axis separately
        //禁止x轴y轴同时进行缩放
        mChart.setPinchZoom(false);
        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        //控制轴上的坐标绘制在什么地方 上边下边左边右边
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);    //x轴是在上边显示还是显示在下边
        xAxis.enableGridDashedLine(10f, 10f, 0f);    //背景用虚线表格来绘制  给整成虚线
        xAxis.setAxisMinimum(0f);//设置轴的最小值。这样设置将不会根据提供的数据自动计算。
        xAxis.setGranularityEnabled(true);    //粒度
        xAxis.setGranularity(1f);    //缩放的时候有用，比如放大的时候，我不想把横轴的月份再细分

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mMonths[(int) value % mMonths.length];
            }
        });
//        xAxis.setAxisLineWidth(0f);    //设置坐标轴那条线的宽度
        xAxis.setDrawAxisLine(false);    //是否显示坐标轴那条轴
        xAxis.setDrawLabels(true);    //是不是显示轴上的刻度
        xAxis.setLabelCount(mMonths.length);    //强制有多少个刻度
        xAxis.setTextColor(Color.parseColor("#b3b3b3"));


        //隐藏左侧坐标轴显示右侧坐标轴，并对右侧的轴进行配置
        mChart.getAxisLeft().setEnabled(false);
        YAxis leftAxis = mChart.getAxisRight();
        leftAxis.setEnabled(true);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setAxisMinimum(0);
        leftAxis.setDrawAxisLine(false);
        //坐标轴绘制在图表的内侧
        leftAxis.setPosition(INSIDE_CHART);
        leftAxis.setTextColor(Color.parseColor("#b3b3b3"));
        //确实没看懂这个是干嘛用的，默认是10f
        //这个玩意好像有坐标轴enable的时候是不可用的
        leftAxis.setSpaceBottom(10f);

        //一个chart中包含一个Data对象，一个Data对象包含多个DataSet对象，
        // 每个DataSet是对应一条线上的所有点(相对于折线图来说)
        mChart.setData(new LineData());

    }


    /**
     * Description: 根据数据集合，动态构建DataSet，来绘制界面
     */
    private void addDataSet(ArrayList<Entry> entryList, String dataSetName) {

        LineData data = mChart.getData();

        if (data != null) {
            int count = data.getDataSetCount();

            LineDataSet set = new LineDataSet(entryList, dataSetName);
            set.setLineWidth(1.5f);
            set.setCircleRadius(3.5f);

            int color = mColors[count % mColors.length];

            set.setColor(color);
            set.setCircleColor(color);
            set.setHighLightColor(color);
            set.setValueTextSize(10f);
            set.setDrawValues(false);    //节点不显示具体数值
            set.setValueTextColor(color);
            set.enableDashedHighlightLine(10f, 5f, 0f);    //选中某个点的时候高亮显示只是线
            set.setDrawFilled(true);     //填充折线图折线和坐标轴之间
            set.setFillColor(color);    //填充可以设置渐变填充一个Drawable，或者仅仅填充颜色
            set.setAxisDependency(YAxis.AxisDependency.RIGHT);    //如果使用的是右坐标轴必须设置这行

//            set.setDrawVerticalHighlightIndicator(false);//取消纵向辅助线
            set.setDrawHorizontalHighlightIndicator(false);//取消横向辅助线

            data.addDataSet(set);
            data.notifyDataChanged();
            mChart.notifyDataSetChanged();
            //这行代码必须放到这里，这里设置的是图表这个视窗能显示，x坐标轴，从最大值到最小值之间
            //多少段，好像这个库没有办法设置x轴中的间隔的大小
            mChart.setVisibleXRangeMaximum(6);
            mChart.invalidate();
        }
    }

}
