package bwei.com.newtitleweixudong.base.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by Administrator on 2017/2/10.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener{


    public abstract void initwidget();//实例化控件

    public abstract void initHeader();//初始化头部

    public abstract void initListener();//初始化监听

}
