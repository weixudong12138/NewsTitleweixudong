package bwei.com.newtitleweixudong.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.List;

import bwei.com.newtitleweixudong.base.MainActivity;

/**
 * Created by Administrator on 2017/2/12.
 */

public class MyHomeAdapter extends FragmentPagerAdapter{

    private List<Fragment>list;
    private String[]title;
    private Context context;


    public MyHomeAdapter(FragmentManager fm, List<Fragment> list, String[] title, Context context) {
        super(fm);
        this.list = list;
        this.title = title;
        this.context = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
