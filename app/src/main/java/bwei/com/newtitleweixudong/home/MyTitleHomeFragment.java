package bwei.com.newtitleweixudong.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.base.MainActivity;
import bwei.com.newtitleweixudong.base.fragment.BaseFragment;
import bwei.com.newtitleweixudong.base.network.NetUrl;
import bwei.com.newtitleweixudong.base.network.XutilNet;
import bwei.com.newtitleweixudong.home.Adapter.MyListHomeAdapter;
import bwei.com.newtitleweixudong.home.Adapter.webviewActivity;

/**
 * Created by Administrator on 2017/2/12.
 */

public class MyTitleHomeFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2<ListView>, XutilNet.CallbackData<HomeBean>,AdapterView.OnItemClickListener{


    //    private int flag=0;
    private View view;
    private MainActivity mainActivity;
    private PullToRefreshListView lv_mytitlehomefragment_pulltorefresh;
    private int page = 0;
    private boolean isNeedClear = false;
    private MyListHomeAdapter myListHomeAdapter;
    private String url;
    public List<HomeBean>mlist=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.mytitlehomefragment, container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String type = getArguments().getString("titlee");
        url = NetUrl.getUrl(type, page);
        mainActivity = (MainActivity) getActivity();
        initwidget();
        initHeader();
        initListener();






    }

    @Override
    public void onResume() {
        super.onResume();
      //  myListHomeAdapter.notifyDataSetChanged();
        XutilNet.getdata(this
                , HomeBean.class, url);
    }




//请求数据


    @Override
    public void initwidget() {
        lv_mytitlehomefragment_pulltorefresh = (PullToRefreshListView) mainActivity.findViewById(R.id.lv_mytitlehomefragment_pulltorefresh);
        lv_mytitlehomefragment_pulltorefresh.setMode(PullToRefreshBase.Mode.BOTH);
        lv_mytitlehomefragment_pulltorefresh.setOnRefreshListener(this);
        lv_mytitlehomefragment_pulltorefresh.setOnItemClickListener(this);
    }

    @Override
    public void initHeader() {
        myListHomeAdapter = new MyListHomeAdapter(mainActivity);
        lv_mytitlehomefragment_pulltorefresh.setAdapter(myListHomeAdapter);
    }


    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {

        page = 0;
        isNeedClear = true;
        XutilNet.getdata(this
                , HomeBean.class, url);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page += 20;
        isNeedClear = false;
        XutilNet.getdata(this
                , HomeBean.class, url);

    }


    @Override
    public void success(List<HomeBean> t) {
        mlist=t;
        myListHomeAdapter.addData(t, isNeedClear);
        myListHomeAdapter.notifyDataSetChanged();
        lv_mytitlehomefragment_pulltorefresh.onRefreshComplete();

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(mainActivity,webviewActivity.class);
        intent.putExtra("url",mlist.get(position).getUrl());
        startActivity(intent);

    }
}

