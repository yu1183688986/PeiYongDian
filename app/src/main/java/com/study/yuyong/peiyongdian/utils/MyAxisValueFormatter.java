package com.study.yuyong.peiyongdian.utils;
/**
 * @date on 18:51 2018/8/25
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 自定义横坐标数据格式化器
 */
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class MyAxisValueFormatter implements IAxisValueFormatter {

    private BarLineChartBase<?> chart;
    private List<String> list = new ArrayList<>();

    public MyAxisValueFormatter(BarLineChartBase<?> chart,String name) {
        this.chart = chart;
        if ("line".equals(name)){
            list.add("过载");
            list.add("重载");
            list.add("轻载");
            list.add("空载");
            list.add("正常");
        }else if ("peibian".equals(name)){
            list.add("过载");
            list.add("重载");
            list.add("不平衡");
            list.add("过电压");
            list.add("低电压");
        }
    }
    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        int index = (int)value;
        if (index < 1 || index > list.size()){
            return "";
        }else {
            return list.get(((int) value-1) % (list.size()));
        }
    }
}
