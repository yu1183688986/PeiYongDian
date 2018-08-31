package com.sg.xjec.e800.peiyongdian.utils;

import android.graphics.Color;

/**
 * @date on 10:58 2018/8/26
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 图形的颜色数组工具类
 */
public class ColorsTemplate {

    public static final int[] Line_COLORS = {
            rgb("#f7941d"), rgb("#22c064"), rgb("#e0483e"),
           rgb("#1352e2"), rgb("#ff0000")
    };

    /**
     * Converts the given hex-color-string to rgb.
     *
     * @param hex
     * @return
     */
    public static int rgb(String hex) {
        int color = (int) Long.parseLong(hex.replace("#", ""), 16);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = (color >> 0) & 0xFF;
        return Color.rgb(r, g, b);
    }
}

