package com.sg.xjec.e800.peiyongdian.utils;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

/**
 * @date on 12:44 2018/8/26
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 控制柱状图定点显示值的数据格式器
 */
public class MyValueFormatter implements IValueFormatter {

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        int i = (int)value;
        return i+"台";
    }
}
