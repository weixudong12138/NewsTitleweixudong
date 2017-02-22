package bwei.com.newtitleweixudong.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.base.MainActivity;
import bwei.com.newtitleweixudong.video.Adapter.MyVideoAdapter;
import bwei.com.newtitleweixudong.video.MyTitleVideoFragment;
import fm.jiecao.jcvideoplayer_lib.JCMediaManager;

/**
 * Created by Administrator on 2017/2/10.
 */

public class Fragmentvideo extends BaseFragment{
 private String []titlevideo={"热门视频","娱乐视频","搞笑视频","精品视频"};
    private String[]titlevideourl={"V9LG4B3A0", "V9LG4CHOR", "V9LG4E6VR", "00850FRB"};
    private MainActivity mainactivity;
    private TabLayout tl_fragmentvideo;
    private ViewPager vp_fragmentvideo_viewpager;
    private List<MyTitleVideoFragment> mlist;
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainactivity = (MainActivity) getActivity();
        initwidget();
        initdata();
        initHeader();
    }

    private void initdata() {
        mlist = new ArrayList<>();
        for (int i = 0; i <titlevideo.length ; i++) {
            MyTitleVideoFragment myTitleVideoFragment=new MyTitleVideoFragment();
            Bundle b=new Bundle();
            b.putString("titlevideourl",titlevideourl[i]);
            myTitleVideoFragment.setArguments(b);
            mlist.add(myTitleVideoFragment);

        }

    }

    @Override
    public void initwidget() {
        tl_fragmentvideo = (TabLayout) view.findViewById(R.id.tl_fragmentvideo_tablayout);
        vp_fragmentvideo_viewpager = (ViewPager) view.findViewById(R.id.vp_fragmentvideo_viewpager);

    }

    @Override
    public void initHeader() {

        MyVideoAdapter myvideoadapter=new MyVideoAdapter(mainactivity.getSupportFragmentManager(),mainactivity,titlevideo,mlist);
        vp_fragmentvideo_viewpager.setAdapter(myvideoadapter);
        tl_fragmentvideo.setTabMode(TabLayout.MODE_SCROLLABLE);
        tl_fragmentvideo.setupWithViewPager(vp_fragmentvideo_viewpager);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v) {

    }


}
