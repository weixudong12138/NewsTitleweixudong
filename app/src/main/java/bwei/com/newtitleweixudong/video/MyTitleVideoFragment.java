package bwei.com.newtitleweixudong.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.base.MainActivity;
import bwei.com.newtitleweixudong.base.fragment.BaseFragment;
import bwei.com.newtitleweixudong.base.network.NetUrl;
import bwei.com.newtitleweixudong.base.network.XutilNet;
import bwei.com.newtitleweixudong.video.Adapter.MyVideolistAdapter;
import fm.jiecao.jcvideoplayer_lib.JCMediaManager;

/**
 * Created by Administrator on 2017/2/19.
 */

public class MyTitleVideoFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2,XutilNet.CallbackData<VideoBean>{
int page=10;
    private String url;
    private MainActivity mainactivity;
    private PullToRefreshListView lv_mytitlevideofragment_pulltorefresh;
    private MyVideolistAdapter myVideolistAdapter;
boolean isneadclear=false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mytitlevideofragment,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainactivity = (MainActivity) getActivity();
     String type=   getArguments().getString("titlevideourl");
      url=  NetUrl.getvideourl(type,page);
        initwidget();
        initHeader();
        initListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        XutilNet.getdata(this,VideoBean.class,url);
    }

    @Override
    public void initwidget() {
        lv_mytitlevideofragment_pulltorefresh = (PullToRefreshListView) mainactivity.findViewById(R.id.lv_mytitlevideofragment_pulltorefresh);
   lv_mytitlevideofragment_pulltorefresh.setMode(PullToRefreshBase.Mode.BOTH);
lv_mytitlevideofragment_pulltorefresh.setOnRefreshListener(this);
    }

    @Override
    public void initHeader() {
        myVideolistAdapter = new MyVideolistAdapter(mainactivity);
        lv_mytitlevideofragment_pulltorefresh.setAdapter(myVideolistAdapter);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
         page=10;
        isneadclear=true;
        XutilNet.getdata(this,VideoBean.class,url);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page+=10;
        isneadclear=false;
        XutilNet.getdata(this,VideoBean.class,url);
    }

    @Override
    public void success(List<VideoBean> t) {
        myVideolistAdapter.addData(t,isneadclear);
        myVideolistAdapter.notifyDataSetChanged();
        lv_mytitlevideofragment_pulltorefresh.onRefreshComplete();
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            JCMediaManager.instance().mediaPlayer.pause();

        }
        JCMediaManager.instance().mediaPlayer.start();

    }
}
