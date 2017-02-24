package bwei.com.newtitleweixudong.home.itemactivity.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.home.itemactivity.ItemTouchHelperCallback;
import bwei.com.newtitleweixudong.home.itemactivity.Main2Activity;


//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      佛祖保佑       永无BUG

//上RecyclerView的适配器
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements ItemTouchHelperCallback.OnItemPositionChangeListener {
    private List<String> list;
    private Main2Activity mContext;
    private OnDeleteIconClickListener mOnDeleteIconClickListener;

    //根据用户的手势，交换Adapter数据集中item的位置
    //此方法的实现可以结合ItemTouchHelperCallback类理解
    @Override
    public boolean onItemMove(int fromPos, int topPos) {
        //Collections为所有集合的上层类
        Collections.swap(list, fromPos, topPos);
        //刷新item
        notifyItemMoved(fromPos, topPos);
        //注意必须要返回true
        return true;
    }

    //删除指定条目接口
    public interface OnDeleteIconClickListener {
        void onDeleteIconClick(int pos);
    }

    //点击小图片删除
    public void setOnDeleteIconClickListener(OnDeleteIconClickListener listener) {
        mOnDeleteIconClickListener = listener;
    }

    //自定义接口实现item的点击事件
    public interface OnItemClickListener {
        //点击监听方法
        void onItemClickListener(MyViewHolder viewHolder, int pos);

        //长按监听方法
        void onItemLongClickListener(MyViewHolder viewHolder, int pos);
    }

    private OnItemClickListener mOnItemClickListener;

    //给接口提供公共的构造方法,相当于把MyAdapter当成了接口实现类
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public MyAdapter(List<String> list, Context context) {
        this.list = list;
        mContext = (Main2Activity) context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tabs, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        //这个方法里面做一些数据适配
        holder.mTabs_txt.setText(list.get(position));
        //用到了MainActivity中的isDeleteIconsShow()方法,取出布尔值从而来判断是隐藏还是显示
        if (mContext.isDeleteIconsShow()) {
            holder.mDelete.setVisibility(View.VISIBLE);
        } else {
            holder.mDelete.setVisibility(View.INVISIBLE);
        }
        //点击删除图片就删除对应的item
        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnDeleteIconClickListener != null) {
                    mOnDeleteIconClickListener.onDeleteIconClick(holder.getLayoutPosition());
                }
            }
        });
        //判空
        if (mOnItemClickListener != null) {
            //如果点击或者长按文字就会触发OnItemClickListener接口从而实现接口回调
            holder.mTabs_txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //点击方法
                    mOnItemClickListener.onItemClickListener(holder, position);
                }
            });
            holder.mTabs_txt.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //长按方法
                    mOnItemClickListener.onItemLongClickListener(holder, position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTabs_txt;
        private final ImageView mDelete;

        //获取资源ID
        public MyViewHolder(View itemView) {
            super(itemView);
            mTabs_txt = (TextView) itemView.findViewById(R.id.tabs_txt);
            mDelete = (ImageView) itemView.findViewById(R.id.delelte);
        }
    }

    //添加条目方法
    public void addData(String data, int pos) {
        list.add(pos, data);
        notifyItemInserted(pos);
    }

    //删除条目方法
    //notifyDataSetChanged(); 此方法自行百度
    public void removeData(int pos) {
        list.remove(pos);
        notifyDataSetChanged();
        notifyItemRemoved(pos);
    }
}
