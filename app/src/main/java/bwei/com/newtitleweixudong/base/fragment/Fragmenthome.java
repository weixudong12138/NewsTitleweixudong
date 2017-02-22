package bwei.com.newtitleweixudong.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.base.MainActivity;
import bwei.com.newtitleweixudong.home.Adapter.MyHomeAdapter;
import bwei.com.newtitleweixudong.home.MyTitleHomeFragment;

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

    }

    private void initdata() {
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            MyTitleHomeFragment mytitlehomefragment = new MyTitleHomeFragment();


//            Bundle b=new Bundle();
//            b.putInt("flag",i);
//            mytitlehomefragment.setArguments(b);

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
        //mviewpager.setOffscreenPageLimit(3);

//        mviewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                Log.e("myMessage","onPageSelected "+position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }


    @Override
    public void onClick(View v) {

    }

}
