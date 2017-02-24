package bwei.com.newtitleweixudong.video.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.video.VideoBean;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MyVideolistAdapter extends BaseAdapter {
     Context context;
  List<VideoBean>list=new ArrayList<>();
     final DisplayImageOptions options;
    public MyVideolistAdapter(Context context) {
        this.context = context;

        //.displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                //.displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
                .build();
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
     if (convertView==null){
         viewHolder=new ViewHolder();
         convertView= View.inflate(context, R.layout.videoitem,null);
       viewHolder.jc_mytitlevideofragment_jiecaovideo= (JCVideoPlayer) convertView.findViewById(R.id.jc_mytitlevideofragment_jiecaovideo);
         convertView.setTag(viewHolder);
     }else {

        viewHolder= (ViewHolder) convertView.getTag();
     }
viewHolder.jc_mytitlevideofragment_jiecaovideo.setUp(list.get(position).getMp4_url(),list.get(position).getTitle());
        ImageLoader.getInstance().displayImage(list.get(position).getCover(),viewHolder.jc_mytitlevideofragment_jiecaovideo.ivThumb,options);

        return convertView;
    }
    static class ViewHolder{
        JCVideoPlayer jc_mytitlevideofragment_jiecaovideo;

    }

    public void addData(List<VideoBean> t, boolean isneadclear) {
        if (t!=null){
            if (isneadclear){
                list.clear();
            }
            list.addAll(t);
        }

    }
}
