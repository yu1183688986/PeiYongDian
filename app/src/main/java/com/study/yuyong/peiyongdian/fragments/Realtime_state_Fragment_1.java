package com.study.yuyong.peiyongdian.fragments;
/**
 * @date on 16:40 2018/8/25
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 实时状态对应碎片
 */
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.study.yuyong.peiyongdian.R;
import com.study.yuyong.peiyongdian.adapter.MonitorFragmentAdapter;
import com.study.yuyong.peiyongdian.utils.MyApplication;
import com.study.yuyong.peiyongdian.utils.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

public class Realtime_state_Fragment_1 extends Fragment{
    private NoScrollViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> mFragments;
    private List<String> mTitles;
    private MonitorFragmentAdapter mAdapter;
    private Realtime_state_Fragment_1.ViewHolder holder;

    /**
     * 缓存title的id
     */
    class ViewHolder{
        TextView textView;
        public ViewHolder(View tabView){
            textView = tabView.findViewById(R.id.tv_tab_name_1);
        }
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.realtime_state_fragment_1, container, false);
        initView(view);
        return view;
    }



    private void initView(View view) {
        mViewPager = view.findViewById(R.id.monitor_show_1);
        mTabLayout = (TabLayout) view.findViewById(R.id.tl_monitor_navigation_1);
        //初始化导航标题,如果是title在json数据中,在初始化的时候可以使用异步任务加载的形式添加
        mTitles=new ArrayList<>();
        mTitles.add("线路状态监视");
        mTitles.add("配变状态监视");

        //初始化Fragment
        mFragments=new ArrayList<>();
        for (int i = 0; i <mTitles.size() ; i++) {
            if(i==0){
                mFragments.add(new Line_state_Monitor_Fragment());
            }else if(i==1){
                mFragments.add(new Historical_state_Fragment());
            }
        }
        //getSupportFragmentManager()是Activity嵌套fragment时使用
        //getChildFragmentManager()是Fragment嵌套Fragment时使用
        mAdapter=new MonitorFragmentAdapter(getChildFragmentManager(),mFragments,mTitles);
        mAdapter.notifyDataSetChanged();
        mViewPager.setAdapter(mAdapter);
        //设置Viewpager和Tablayout进行联动
        mTabLayout.setupWithViewPager(mViewPager);
//        //将标题设置可以左右摇动而不是移动
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        //设置预加载页数
        //      mViewPager.setOffscreenPageLimit(3);

        //设置Tab的样式
        for (int i = 0; i < mTitles.size(); i++) {
            //依次获取标签
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            //为每个标签设置布局
            tab.setCustomView(R.layout.tab_item_1);
            // View view1 = tab.getCustomView();
            holder = new ViewHolder(tab.getCustomView());
            //为标签填充数据
            holder.textView.setText(mTitles.get(i));
            //默认选择第一项
            if (i == 0){
                holder.textView.setSelected(true);
                holder.textView.setTextSize(20);
                //  holder.tvTabName_1.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
            }

        }

        //tab被选中的监听事件
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                holder = new ViewHolder(tab.getCustomView());
                holder.textView.setSelected(true);
                holder.textView.setTextSize(20);

                //让Viewpager跟随TabLayout的标签切换
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                holder = new ViewHolder(tab.getCustomView());
                holder.textView.setSelected(false);
                holder.textView.setTextSize(18);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
