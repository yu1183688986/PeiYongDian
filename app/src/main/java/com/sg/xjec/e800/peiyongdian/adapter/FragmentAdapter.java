package com.sg.xjec.e800.peiyongdian.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {

    //数据源的集合
    List<Fragment> list = new ArrayList<Fragment>();

    public FragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list.clear();
        this.list.addAll(list);

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
