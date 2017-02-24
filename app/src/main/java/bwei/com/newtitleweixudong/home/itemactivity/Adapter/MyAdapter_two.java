package bwei.com.newtitleweixudong.home.itemactivity.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bwei.com.newtitleweixudong.R;
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

//此适配器同第一个相差不大,不赘述
public class MyAdapter_two extends RecyclerView.Adapter<MyAdapter_two.ViewHolder> {
    private List<String> mDatas;
    private Main2Activity mContext;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(ViewHolder holder, int pos);
    }

    public void setOnitemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public MyAdapter_two(Context context, List<String> datas) {
        mDatas = datas;
        mContext = (Main2Activity) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tabs, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTabs_txt.setText(mDatas.get(position));
        holder.mTabs_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(holder, holder.getLayoutPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTabs_txt;
        //private final ImageView mDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            mTabs_txt = (TextView) itemView.findViewById(R.id.tabs_txt);
            //mDelete = (ImageView) itemView.findViewById(R.id.delelte);
        }
    }

    public void addData(String data, int pos) {
        mDatas.add(pos, data);
        notifyItemInserted(pos);
    }

    public void removeData(int pos) {
        mDatas.remove(pos);
        notifyDataSetChanged();
        notifyItemRemoved(pos);
    }
}
