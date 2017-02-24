package bwei.com.newtitleweixudong.home.itemactivity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

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

//ItemTouchHelper.Callback 自行百度学习(http://www.myexception.cn/android/2001074.html)
public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {
    private OnItemPositionChangeListener mOnItemPositionChangeListener;

    //通过构造函数，设置接口实例
    public ItemTouchHelperCallback(OnItemPositionChangeListener onItemPositionChangeListener) {
        mOnItemPositionChangeListener = onItemPositionChangeListener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //the direction of item which be dragged
        //dragFlags 为拖拽标志
        final int dragFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT
                | ItemTouchHelper.UP | ItemTouchHelper.DOWN;


        //can be dragged, can not be swiped
        return makeMovementFlags(dragFlags, 0);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (mOnItemPositionChangeListener != null) {
            //返回一个接口回调方法
            return mOnItemPositionChangeListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        }
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    //自定义接口在第一个RecyclerView适配器里回调onItemMove方法
    public interface OnItemPositionChangeListener {
        boolean onItemMove(int fromPos, int topPos);
    }
}
