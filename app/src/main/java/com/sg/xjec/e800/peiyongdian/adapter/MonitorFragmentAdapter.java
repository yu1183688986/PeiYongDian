package com.sg.xjec.e800.peiyongdian.adapter;
/**
 * @date on 10:27 2018/8/24
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe Tablayout+viewpaper联动时使用的adapter
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MonitorFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public MonitorFragmentAdapter(FragmentManager fm, List<Fragment> framents, List<String> titles) {
        super(fm);
        mFragments = framents;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
