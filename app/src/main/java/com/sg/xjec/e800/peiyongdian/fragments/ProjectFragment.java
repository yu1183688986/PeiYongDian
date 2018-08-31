package com.sg.xjec.e800.peiyongdian.fragments;
/**
 * @date on 21:09 2018/8/21
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 项目按钮对应的碎片
 */
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sg.xjec.e800.peiyongdian.R;

public class ProjectFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.project_fragment,container,false);
        return view;
    }
}
