package bwei.com.newtitleweixudong.home.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import bwei.com.newtitleweixudong.MyApp;
import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.home.HomeBean;

/**
 * Created by Administrator on 2017/2/13.
 */

public class MyListHomeAdapter extends BaseAdapter {
    private Context context;
    private List<HomeBean> list = new ArrayList<>();
    private DisplayImageOptions options;
    private int i;
    private ViewHolder viewHolder;
    private ViewHolder2 viewHolder2;
    private ViewHolder3 viewHolder3;
    private ViewHolder4 viewHolder4;

    public MyListHomeAdapter(Context context) {
        this.context = context;
        options = new DisplayImageOptions.Builder().showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher).cacheOnDisk(true).cacheInMemory(true).build();
    }



    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getTopic_background()!=null){
            return 1;

        }else if (list.get(position).getImgsrc() != null&&list.get(position).getTopic_background()==null&&list.get(position).getImgextra()==null){

            return 2;
        }else if (list.get(position).getImgextra() != null && list.get(position).getImgextra().size() > 0&&list.get(position).getImgextra()!=null){
            return 3;
        }
        return 0;
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

        SharedPreferences conflag = context.getSharedPreferences("conflag", Context.MODE_PRIVATE);
        i = conflag.getInt("mode",0);
        if (i==1){
            MyApp.stitchMode(1);
        }else {
          MyApp.stitchMode(0);
        }

        viewHolder = null;
        viewHolder2 = null;
        viewHolder3 = null;
        viewHolder4 = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case 0:
                    convertView = LayoutInflater.from(context).inflate(R.layout.fragmenthome_text, null);
                    viewHolder = new ViewHolder();
                    viewHolder.text = (TextView) convertView.findViewById(R.id.tv_MylistHomeAdapter_text);
                    convertView.setTag(viewHolder);
                    break;
                case 1:
                    convertView = LayoutInflater.from(context).inflate(R.layout.fragmenthome_bigimage, null);
                    viewHolder2 = new ViewHolder2();
                    viewHolder2.bigtext = (TextView) convertView.findViewById(R.id.tv_MylistHomeAdapter_bigimage);
                    viewHolder2.bigimage = (ImageView) convertView.findViewById(R.id.iv_MylistHomeAdapter_bigimage);
                    convertView.setTag(viewHolder2);
                    break;
                case 2:
                    convertView = LayoutInflater.from(context).inflate(R.layout.fragmenthome_image, null);
                    viewHolder3 = new ViewHolder3();
                    viewHolder3.imagetext = (TextView) convertView.findViewById(R.id.tv_MylistHomeAdapter_image);
                    viewHolder3.rightimage = (ImageView) convertView.findViewById(R.id.iv_MylistHomeAdapter_image);

                    convertView.setTag(viewHolder3);
                    break;
                case 3:
                    convertView = LayoutInflater.from(context).inflate(R.layout.fragmenthome_threeimage, null);
                    viewHolder4 = new ViewHolder4();
                    viewHolder4.threetext = (TextView) convertView.findViewById(R.id.tv_MylistHomeAdapter_threeimage);
                    viewHolder4.threeimage1 = (ImageView) convertView.findViewById(R.id.iv_MylistHomeAdapter_threeimage1);
                    viewHolder4.threeimage2 = (ImageView) convertView.findViewById(R.id.iv_MylistHomeAdapter_threeimage2);
                    viewHolder4.threeimage3= (ImageView) convertView.findViewById(R.id.iv_MylistHomeAdapter_threeimage3);
                    convertView.setTag(viewHolder4);
                    break;

            }


        } else {
            switch (type) {
                case 0:
                    viewHolder = (ViewHolder) convertView.getTag();
                    break;
                case 1:
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                    break;
                case 2:
                    viewHolder3 = (ViewHolder3) convertView.getTag();
                    break;
                case 3:
                    viewHolder4 = (ViewHolder4) convertView.getTag();
                    break;

            }


        }
        switch (type) {
            case 0:
                viewHolder.text.setText(list.get(position).getTitle());
                break;
            case 1:
                viewHolder2.bigtext.setText(list.get(position).getTitle());
                ImageLoader.getInstance().displayImage(list.get(position).getImgsrc(), viewHolder2.bigimage, options);
                break;
            case 2:
                viewHolder3.imagetext.setText(list.get(position).getTitle());
                ImageLoader.getInstance().displayImage(list.get(position).getImgsrc(), viewHolder3.rightimage, options);
                break;
            case 3:
                viewHolder4.threetext.setText(list.get(position).getTitle());
                ImageLoader.getInstance().displayImage(list.get(position).getImgextra().get(0).getImgsrc(), viewHolder4.threeimage1, options);
                ImageLoader.getInstance().displayImage(list.get(position).getImgextra().get(1).getImgsrc(), viewHolder4.threeimage2, options);
                ImageLoader.getInstance().displayImage(list.get(position).getImgsrc(), viewHolder4.threeimage3, options);
                break;

        }


        return convertView;
    }

    static class ViewHolder {
        TextView text;

    }

    static class ViewHolder2 {
        TextView bigtext;
        ImageView bigimage;

    }

    static class ViewHolder3 {
        TextView imagetext;
        ImageView rightimage;

    }

    static class ViewHolder4 {
        TextView threetext;
        ImageView threeimage1, threeimage2,threeimage3;

    }
    public void switchmode(){



    }


    public void addData(List<HomeBean> data, boolean isneedclear) {
        if (data != null) {
            if (isneedclear) {
                list.clear();
            }
            list.addAll(data);
            Log.e("myMessage", "dataBeens size " + list.size());
        }


    }

}
