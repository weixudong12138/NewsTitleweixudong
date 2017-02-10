package bwei.com.newtitleweixudong.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bwei.com.newtitleweixudong.R;

/**
 * Created by Administrator on 2017/2/10.
 */

public class Fragmenthome extends BaseFragment{

    @Override
    public void initwidget() {

    }

    @Override
    public void initHeader() {

    }

    @Override
    public void initListener() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_home,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHeader();
        initwidget();
        initListener();

    }

    @Override
    public void onClick(View v) {

    }
}
