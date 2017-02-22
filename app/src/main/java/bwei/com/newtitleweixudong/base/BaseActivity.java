package bwei.com.newtitleweixudong.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/10.
 */

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener{


    public Map<String,String>map;


    public abstract void initwidget();//实例化控件

    public abstract void initHeader();//初始化头部

    public abstract void initListener();//初始化监听

   public void initheaderwidget(){

       map=new HashMap<String,String>();
   }


    @Override
    public void onClick(View v) {

    }
}
