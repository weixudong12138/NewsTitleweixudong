package bwei.com.newtitleweixudong.video.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import bwei.com.newtitleweixudong.video.MyTitleVideoFragment;

/**
 * Created by Administrator on 2017/2/19.
 */

public class MyVideoAdapter extends FragmentStatePagerAdapter{
private Context context;
    private String[]titlevideo;
    private List<MyTitleVideoFragment>mlist;

    public MyVideoAdapter(FragmentManager fm, Context context, String[] titlevideo, List<MyTitleVideoFragment> mlist) {
        super(fm);
        this.context = context;
        this.titlevideo = titlevideo;
        this.mlist = mlist;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlevideo[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }
}
