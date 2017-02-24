package bwei.com.newtitleweixudong.base.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.base.MainActivity;
import bwei.com.newtitleweixudong.home.Adapter.MyHomeAdapter;
import bwei.com.newtitleweixudong.home.MyTitleHomeFragment;
import bwei.com.newtitleweixudong.home.itemactivity.Main2Activity;

/**
 * Created by Administrator on 2017/2/10.
 */

public class Fragmenthome extends BaseFragment {
    private String[] title = {"推荐", "热点", "北京", "阳光宽屏", "社会", "趣图", "问答", "魏旭东"};
    private String[] titlee = {"T1370583240249", "T1348654060988", "T1348648650048", "T1348649580692", "T1348649580692", "T1348648650048", "T1348654060988", "T1350383429665"};
    private TabLayout mtablayout;
    private ViewPager mviewpager;
    private List<MyTitleHomeFragment> list;
    private MainActivity mainActivity;
    private View view;
    private Button btn_fragmenthome_title;
    private ImageView iv_fragmenthome_add;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);

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
    public void initwidget() {
        btn_fragmenthome_title = (Button) view.findViewById(R.id.btn_fragmenthome_title);
        iv_fragmenthome_add = (ImageView) view.findViewById(R.id.iv_fragmenthome_add);

        mtablayout = (TabLayout) view.findViewById(R.id.tl_fragmenthome_tablayout);
        mviewpager = (ViewPager) view.findViewById(R.id.vp_fragment_viewpager);
        initdata();
        initview();
    }


    @Override
    public void initHeader() {
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void initListener() {
        btn_fragmenthome_title.setOnClickListener(this);
        iv_fragmenthome_add.setOnClickListener(this);

    }

    private void initdata() {
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            MyTitleHomeFragment mytitlehomefragment = new MyTitleHomeFragment();



            Bundle b = new Bundle();
            b.putString("titlee", titlee[i]);
            mytitlehomefragment.setArguments(b);

            list.add(mytitlehomefragment);
        }


    }

    private void initview() {
        MyHomeAdapter myhomeAdapter = new MyHomeAdapter(mainActivity.getSupportFragmentManager(), list, title, mainActivity);
        mtablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mtablayout.setupWithViewPager(mviewpager);
        mviewpager.setAdapter(myhomeAdapter);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_fragmenthome_add:
                Intent intent=new Intent(mainActivity, Main2Activity.class);
                startActivity(intent);
                break;

            case R.id.btn_fragmenthome_title:


                break;

        }


    }

}
