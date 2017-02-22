package bwei.com.newtitleweixudong.base;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.umeng.message.PushAgent;

import java.util.ArrayList;

import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.base.entity.ShowFragment;
import bwei.com.newtitleweixudong.base.fragment.Fragmentattention;
import bwei.com.newtitleweixudong.base.fragment.Fragmenthome;
import bwei.com.newtitleweixudong.base.fragment.Fragmentmy;
import bwei.com.newtitleweixudong.base.fragment.Fragmentvideo;

import static anetwork.channel.http.NetworkSdkSetting.context;

public class MainActivity extends BaseActivity {

    private Button btn_main_home;
    private Button btn_main_video;
    private Button btn_main_attention;
    private Button btn_main_my;

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragmentmy fragmentMy;
    private Fragmenthome fragmentHome;
    private Fragmentvideo fragmentVideo;
    private Fragmentattention fragmentAttention;
    private ArrayList<ShowFragment> fragmentlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("wei", "github首次提交作业");

        PushAgent.getInstance(context).onAppStart();

        initHeader();
        initwidget();
        initListener();

    }


    @Override
    public void initwidget() {
        btn_main_home = (Button) findViewById(R.id.btn_main_home);
        btn_main_home.setSelected(true);
        btn_main_home.setTextColor(Color.RED);
        btn_main_video = (Button) findViewById(R.id.btn_main_video);
        btn_main_attention = (Button) findViewById(R.id.btn_main_attention);
        btn_main_my = (Button) findViewById(R.id.btn_main_my);


        manager = getSupportFragmentManager();
        fragmentMy = new Fragmentmy();
        fragmentHome = new Fragmenthome();
        fragmentVideo = new Fragmentvideo();
        fragmentAttention = new Fragmentattention();
        addList();
        addFragment(0);
    }


    private void addFragment(int pos) {
        transaction = manager.beginTransaction();
        for (int i = 0; i < fragmentlist.size(); i++) {
            if (i != pos) {
                transaction.hide(fragmentlist.get(i).fragment11);

            }


        }
        if (fragmentlist.get(pos).statue == 0) {
            transaction.add(R.id.fl_mainactivity_frame, fragmentlist.get(pos).fragment11, pos + "");
            fragmentlist.get(pos).statue = 1;
            transaction.show(fragmentlist.get(pos).fragment11);
        } else {
            transaction.show(fragmentlist.get(pos).fragment11);

        }
        transaction.commit();

    }


    private void addList() {
        fragmentlist = new ArrayList<ShowFragment>();
        for (int i = 0; i < 4; i++) {
            ShowFragment showfragment = new ShowFragment();
            switch (i) {
                case 0:
                    showfragment.fragment11 = fragmentHome;
                    break;
                case 1:
                    showfragment.fragment11 = fragmentVideo;
                    break;
                case 2:
                    showfragment.fragment11 = fragmentAttention;
                    break;
                case 3:
                    showfragment.fragment11 = fragmentMy;
                    break;
            }
            fragmentlist.add(showfragment);
        }
    }


    @Override
    public void initHeader() {
        initheaderwidget();

    }

    @Override
    public void initListener() {
        btn_main_home.setOnClickListener(this);
        btn_main_video.setOnClickListener(this);
        btn_main_attention.setOnClickListener(this);
        btn_main_my.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_main_home:
                setstatue(R.id.btn_main_home);
                addFragment(0);
                break;
            case R.id.btn_main_video:
                setstatue(R.id.btn_main_video);
                addFragment(1);
                break;
            case R.id.btn_main_attention:
                setstatue(R.id.btn_main_attention);
                addFragment(2);
                break;
            case R.id.btn_main_my:
                setstatue(R.id.btn_main_my);
                addFragment(3);
                break;

        }
    }

    private void setstatue(int id) {
        switch (id) {
            case R.id.btn_main_home:
                btn_main_home.setSelected(true);
                btn_main_home.setTextColor(Color.RED);
                btn_main_video.setTextColor(Color.BLACK);
                btn_main_attention.setTextColor(Color.BLACK);
                btn_main_my.setTextColor(Color.BLACK);
                btn_main_video.setSelected(false);
                btn_main_attention.setSelected(false);
                btn_main_my.setSelected(false);
                break;
            case R.id.btn_main_video:
                btn_main_home.setSelected(false);
                btn_main_home.setTextColor(Color.BLACK);
                btn_main_video.setSelected(true);
                btn_main_video.setTextColor(Color.RED);
                btn_main_attention.setTextColor(Color.BLACK);
                btn_main_attention.setSelected(false);
                btn_main_my.setTextColor(Color.BLACK);
                btn_main_my.setSelected(false);
                break;
            case R.id.btn_main_attention:
                btn_main_home.setSelected(false);
                btn_main_home.setTextColor(Color.BLACK);
                btn_main_video.setSelected(false);
                btn_main_video.setTextColor(Color.BLACK);
                btn_main_attention.setSelected(true);
                btn_main_attention.setTextColor(Color.RED);
                btn_main_my.setSelected(false);
                btn_main_my.setTextColor(Color.BLACK);
                break;
            case R.id.btn_main_my:
                btn_main_home.setSelected(false);
                btn_main_home.setTextColor(Color.BLACK);
                btn_main_video.setSelected(false);
                btn_main_video.setTextColor(Color.BLACK);
                btn_main_attention.setSelected(false);
                btn_main_attention.setTextColor(Color.BLACK);
                btn_main_my.setSelected(true);
                btn_main_my.setTextColor(Color.RED);
                break;
        }


    }
}
