package com.study.yuyong.peiyongdian.fragments;
/**
 * @date on 21:03 2018/8/21
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 监控按钮对应的碎片
 */
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MonitorFragment extends Fragment {
    private NoScrollViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment>mFragments;
    private List<String> mTitles;
    private MonitorFragmentAdapter mAdapter;
    private ViewHolder holder;

    class ViewHolder{
        TextView tvTabName;
        TextView tvTabName_1;
        LinearLayout linearLayout;

        public ViewHolder(View tabView) {
            tvTabName = (TextView) tabView.findViewById(R.id.tv_tab_name);
            tvTabName_1 = tabView.findViewById(R.id.tv_tab_name_1);
            linearLayout = tabView.findViewById(R.id.tv_linear);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.monitor_fragment, container, false);
        initView(view);
        return view;
    }



    private void initView(View view) {
        mViewPager = view.findViewById(R.id.monitor_show);
        mTabLayout = (TabLayout) view.findViewById(R.id.tl_monitor_navigation);
        //初始化导航标题,如果是title在json数据中,在初始化的时候可以使用异步任务加载的形式添加
        mTitles=new ArrayList<>();
        mTitles.add("实时状态");
        mTitles.add("历史状态");
        //设置分割线
        LinearLayout linearLayout = (LinearLayout) mTabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(MyApplication.getContext(),
                R.drawable.divider)); //设置分割线的样式
        linearLayout.setDividerPadding(dip2px(5)); //设置分割线间隔长短

        //初始化Fragment
        mFragments=new ArrayList<>();
        for (int i = 0; i <mTitles.size() ; i++) {
            if(i==0){
                mFragments.add(new Realtime_state_Fragment_1());
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
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        //设置预加载页数
        //      mViewPager.setOffscreenPageLimit(3);

        //设置Tab的样式
        for (int i = 0; i < mTitles.size(); i++) {
            //依次获取标签
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            //为每个标签设置布局
            tab.setCustomView(R.layout.tab_item);
           // View view1 = tab.getCustomView();
            holder = new ViewHolder(tab.getCustomView());
            //为标签填充数据
            holder.tvTabName.setText(mTitles.get(i));
            holder.tvTabName_1.setText(mTitles.get(i));
            //默认选择第一项
            if (i == 0){
                holder.tvTabName.setSelected(true);
              //  holder.tvTabName_1.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
            }else {
                holder.linearLayout.setVisibility(View.GONE);
            }

        }
        //tab被选中的监听事件
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                holder = new ViewHolder(tab.getCustomView());
                holder.tvTabName.setSelected(true);
                holder.linearLayout.setVisibility(View.VISIBLE);
                //让Viewpager跟随TabLayout的标签切换
                //mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                holder = new ViewHolder(tab.getCustomView());
                holder.tvTabName.setSelected(false);
                holder.linearLayout.setVisibility(View.GONE);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
        /**
         * 像素单位转换
         */
        public int dip2px ( int dip){
            float density = getResources().getDisplayMetrics().density;
            return (int) (dip * density + 0.5);
        }
}
