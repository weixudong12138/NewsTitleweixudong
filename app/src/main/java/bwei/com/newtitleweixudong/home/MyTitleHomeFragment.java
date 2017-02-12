package bwei.com.newtitleweixudong.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.base.fragment.BaseFragment;

/**
 * Created by Administrator on 2017/2/12.
 */

public class MyTitleHomeFragment extends BaseFragment{


    private int flag=0;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.mytitlehomefragment,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initwidget();
        initHeader();
        initListener();


        flag = (int) getArguments().get("flag");


      TextView text_title= (TextView) view.findViewById(R.id.text_title);
       text_title.setText(flag+"");



    }

    @Override
    public void initwidget() {

    }

    @Override
    public void initHeader() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
