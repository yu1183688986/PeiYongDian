package com.study.yuyong.peiyongdian.fragments;
/**
 * @date on 21:08 2018/8/21
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 图表按钮对应的碎片
 */
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.study.yuyong.peiyongdian.R;

public class ChartFragment extends Fragment implements TabHost.OnTabChangeListener{
    private TabHost tabHost;
    private TabWidget widget;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chart_fragment,container,false);
        tabHost = view.findViewById(R.id.tabHost);
        tabHost.setup();
        widget = tabHost.getTabWidget();
       // widget.setStripEnabled(true);
        init();
        return view;
    }

    private void init(){
        tabHost.setOnTabChangedListener(this);
        TabHost.TabSpec realtime = tabHost.newTabSpec("tab1")
                .setIndicator("实时状态")
                .setContent(R.id.realtime_state);
        tabHost.addTab(realtime);

        /*TabHost.TabSpec page2 = tabHost.newTabSpec("tab2")
                .setIndicator("图B")
                .setContent(R.id.chart_two);
        tabHost.addTab(page2);*/

        TabHost.TabSpec historical = tabHost.newTabSpec("tab3")
                .setIndicator("历史状态")
                .setContent(R.id.historical_state);
        tabHost.addTab(historical);

        /**
         * 修改字体和颜色
         */
        changeTabBackGround();
    }

    //点击某一个选项卡切换该选项卡背景的方法
    private void changeTabBackGround(){
        //得到当前选中选项卡的索引
        int index = tabHost.getCurrentTab();
        //得到选项卡的数量
        int count = widget.getChildCount();
        //循环判断，只有点中的索引值改变背景颜色，其他的则恢复未选中的颜色
        for(int i=0;i<count;i++){
            View view = widget.getChildAt(i);
            view.setBackgroundResource(R.color.Black);
            TextView tx = (TextView) (tabHost.getTabWidget().getChildAt(i)).findViewById(android.R.id.title);
            //设置字体风格
            tx.setTypeface(Typeface.SERIF, 2);
            tx.setPadding(0, 10, 0, 0);
            if(index == i){
                //view.setBackgroundResource(R.drawable.table_host_item_color_state);
                tx.setTextColor(Color.WHITE);
                tx.setTextSize(24);
               // tx.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
            }else {
               // view.setBackgroundResource(R.drawable.table_host_item_color_state);
                tx.setTextColor(Color.WHITE);
                tx.setTextSize(20);
            }
        }
    }

    @Override
    public void onTabChanged(String s) {
        changeTabBackGround();
    }
}
