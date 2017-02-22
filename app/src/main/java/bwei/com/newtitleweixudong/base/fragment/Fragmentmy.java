package bwei.com.newtitleweixudong.base.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

import bwei.com.newtitleweixudong.MyApp;
import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.base.MainActivity;

/**
 * Created by Administrator on 2017/2/10.
 */

public class Fragmentmy extends BaseFragment{
    private Tencent mtencent;
int a=0;
    private MainActivity mainActivity;
    private ImageView iv_fragmentmy_wechat;
    private ImageView iv_fragmentmy_qq;
    private ImageView iv_fragmentmy_phone;
    private ImageView iv_fragmentmy_more;
    private TextView tv_fragmentmy_daynight;
    private TextView tv_fragmentmy_favoriteicon;
    private TextView tv_fragmentmy_set;
    private LinearLayout ll_fragmentmy_topll;
    private View view;
    private LinearLayout ll_fragmentmy_zhongll;
    private LinearLayout ll_fragmentmy_downll;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
         initwidget();
        initHeader();
        initListener();

    }
    @Override
    public void initwidget() {
    //找到控件
        ll_fragmentmy_topll = (LinearLayout) view.findViewById(R.id.ll_fragmentmy_topll);
        ll_fragmentmy_zhongll = (LinearLayout) view.findViewById(R.id.ll_fragmentmy_zhongll);
        ll_fragmentmy_downll = (LinearLayout) view.findViewById(R.id.ll_fragmentmy_downll);

        iv_fragmentmy_wechat = (ImageView) view.findViewById(R.id.iv_fragmentmy_wechat);
        iv_fragmentmy_qq = (ImageView)     view.findViewById(R.id.iv_fragmentmy_qq);
        iv_fragmentmy_phone = (ImageView)   view.findViewById(R.id.iv_fragmentmy_phone);
        iv_fragmentmy_more = (ImageView)    view.findViewById(R.id.iv_fragmentmy_more);
        tv_fragmentmy_daynight = (TextView) view.findViewById(R.id.tv_fragmentmy_daynight);
        tv_fragmentmy_favoriteicon = (TextView)  view.findViewById(R.id.tv_fragmentmy_favoriteicon);
        tv_fragmentmy_set = (TextView)   view.findViewById(R.id.tv_fragmentmy_set);

        tv1 = (TextView) view.findViewById(R.id.tv1);
        tv2 = (TextView) view.findViewById(R.id.tv2);
        tv3 = (TextView) view.findViewById(R.id.tv3);
        tv4 = (TextView) view.findViewById(R.id.tv4);
        tv5 = (TextView) view.findViewById(R.id.tv5);
        tv6 = (TextView) view.findViewById(R.id.tv6);

    }

    @Override
    public void initHeader() {

    }

    @Override
    public void initListener() {
        iv_fragmentmy_wechat.setOnClickListener(this);
        iv_fragmentmy_qq.setOnClickListener(this);
        iv_fragmentmy_phone.setOnClickListener(this);
        iv_fragmentmy_more.setOnClickListener(this);
        tv_fragmentmy_daynight.setOnClickListener(this);
        tv_fragmentmy_favoriteicon.setOnClickListener(this);
        tv_fragmentmy_set.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_fragmentmy_wechat:

                break;
            case R.id.iv_fragmentmy_qq:
                mtencent.login(getActivity(),"all",loginListener);
                break;
            case R.id.iv_fragmentmy_phone:

                break;
            case R.id.iv_fragmentmy_more:

                break;
            case R.id.tv_fragmentmy_favoriteicon:

                break;
            case R.id.tv_fragmentmy_daynight:

                if(a==0){
                    tv_fragmentmy_daynight.setSelected(true);
                    MyApp.stitchMode(1);

                    tv_fragmentmy_daynight.setText("日间");
                    a=1;
                }else {
                    tv_fragmentmy_daynight.setSelected(false);
                    MyApp.stitchMode(0);

                    tv_fragmentmy_daynight.setText("夜间");
                    a=0;

                }
                switchmode();

                break;
            case R.id.tv_fragmentmy_set:

                break;

        }


    }

    public void  switchmode() {
ll_fragmentmy_topll.setBackgroundColor(getResources().getColor(MyApp.mResourceMap.get("textcolor")));
        ll_fragmentmy_zhongll.setBackgroundColor(getResources().getColor(MyApp.mResourceMap.get("backcolor")));
        ll_fragmentmy_downll.setBackgroundColor(getResources().getColor(MyApp.mResourceMap.get("backcolor")));

        iv_fragmentmy_phone.setImageResource(MyApp.mResourceMap.get("phone"));
       iv_fragmentmy_qq .setImageResource(MyApp.mResourceMap.get("qq"));
        iv_fragmentmy_wechat.setImageResource(MyApp.mResourceMap.get("weixin"));

   tv1.setTextColor(getResources().getColor(MyApp.mResourceMap.get("textcolor")));
        tv2.setTextColor(getResources().getColor(MyApp.mResourceMap.get("textcolor")));
        tv3.setTextColor(getResources().getColor(MyApp.mResourceMap.get("textcolor")));
        tv4.setTextColor(getResources().getColor(MyApp.mResourceMap.get("textcolor")));
        tv5.setTextColor(getResources().getColor(MyApp.mResourceMap.get("textcolor")));
        tv6.setTextColor(getResources().getColor(MyApp.mResourceMap.get("textcolor")));

    }

    IUiListener loginListener = new BaseUiListener() {
        @Override
        protected void doComplete(JSONObject values) {
            Log.d("SDKQQAgentPref", "AuthorSwitch_SDK:" + SystemClock.elapsedRealtime());

        }
    };
    class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {

            doComplete((JSONObject)response);
        }

        protected void doComplete(JSONObject values) {
         //   Log.i("miaojx",values.toString());



        }

        @Override
        public void onError(UiError e) {

       //     Log.i("weixd",e.toString());
        }

        @Override
        public void onCancel() {

          }
        }
    }

