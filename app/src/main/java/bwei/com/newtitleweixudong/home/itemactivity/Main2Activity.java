package bwei.com.newtitleweixudong.home.itemactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bwei.com.newtitleweixudong.R;
import bwei.com.newtitleweixudong.home.itemactivity.Adapter.MyAdapter;
import bwei.com.newtitleweixudong.home.itemactivity.Adapter.MyAdapter_two;


public class Main2Activity extends AppCompatActivity {
    private List<String> mSelectedDatas;
    private List<String> mUnselectedDatas;
    private RecyclerView mRecycleSelected;
    private RecyclerView mRecycleUnSelected;
    private MyAdapter mMyAdapter;
    private MyAdapter_two mMyAdapter_two;
    //定义一个boolean变量记录删除图片显示隐藏的状态
    public boolean isDeleteIconsShow = false;
    private TextView mFinish;
    private ItemTouchHelper mItemTouchHelper;

    //public的公共方法供其他类调用上面定义的boolean值
    public boolean isDeleteIconsShow() {
        return isDeleteIconsShow;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initData();
        initViews();
        initEvent();
    }
    //获取资源ID
    private void initViews() {
        mFinish = (TextView) findViewById(R.id.finish);
        mRecycleSelected = (RecyclerView) findViewById(R.id.top_recycler);
        mRecycleUnSelected = (RecyclerView) findViewById(R.id.bottom_recycler);
        //第一个RecyclerView的初始化
        mRecycleSelected.setLayoutManager(new GridLayoutManager(this, 4));
        mMyAdapter = new MyAdapter(mSelectedDatas, this);
        mRecycleSelected.setAdapter(mMyAdapter);
        //调用此方法来对子item项进行修饰
        mRecycleSelected.addItemDecoration(new SpaceItemDecoration(8));
        //第二个RecyclerView的初始化
        mRecycleUnSelected.setLayoutManager(new GridLayoutManager(this, 4));
        mMyAdapter_two = new MyAdapter_two(this, mUnselectedDatas);
        mRecycleUnSelected.setAdapter(mMyAdapter_two);
        mRecycleUnSelected.addItemDecoration(new SpaceItemDecoration(8));
    }

    private void initData() {
        mSelectedDatas = new ArrayList<String>();
        mSelectedDatas.add("头条");
        mSelectedDatas.add("娱乐");
        mSelectedDatas.add("精选");
        mSelectedDatas.add("热点");
        mSelectedDatas.add("体育");
        mSelectedDatas.add("网易号");
        mSelectedDatas.add("直播");
        mSelectedDatas.add("财经");
        mSelectedDatas.add("科技");
        mSelectedDatas.add("房产");
        mSelectedDatas.add("汽车");
        mSelectedDatas.add("轻松一刻");
        mSelectedDatas.add("跟帖");
        mSelectedDatas.add("图片");
        mSelectedDatas.add("段子");
        mSelectedDatas.add("家具");
        mSelectedDatas.add("游戏");
        mSelectedDatas.add("健康");
        mSelectedDatas.add("政务");
        mSelectedDatas.add("漫画");
        mSelectedDatas.add("中国足球");
        mSelectedDatas.add("数码");
        mSelectedDatas.add("趣闻");
        mUnselectedDatas = new ArrayList<String>();
        mUnselectedDatas.add("NBA");
        mUnselectedDatas.add("社会");
        mUnselectedDatas.add("军事");
        mUnselectedDatas.add("欧洲杯");
        mUnselectedDatas.add("CBA");
        mUnselectedDatas.add("跑步");
        mUnselectedDatas.add("移动互联");
        mUnselectedDatas.add("云课堂");
        mUnselectedDatas.add("房产");
        mUnselectedDatas.add("旅游");
        mUnselectedDatas.add("读书");
        mUnselectedDatas.add("酒香");
        mUnselectedDatas.add("教育");
        mUnselectedDatas.add("亲子");
        mUnselectedDatas.add("暴雪游戏");
        mUnselectedDatas.add("态度营销");
        mUnselectedDatas.add("时尚");
        mUnselectedDatas.add("情感");
        mUnselectedDatas.add("艺术");
        mUnselectedDatas.add("海外");
        mUnselectedDatas.add("博客");
        mUnselectedDatas.add("论坛");
        mUnselectedDatas.add("型男");
        mUnselectedDatas.add("萌宠");
    }

    private void initEvent() {
        //实例化ItemTouchHelperCallback,与回调接口有关可以结合MainActivity,MyAdapter,ItemTouchHelperCallback一起理解
        ItemTouchHelperCallback callback = new ItemTouchHelperCallback(mMyAdapter);
        //ItemTouchHelper item项触摸帮助类不理解的可以自主学习
        mItemTouchHelper = new ItemTouchHelper(callback);
        //绑定RecyclerView
        mItemTouchHelper.attachToRecyclerView(mRecycleSelected);
        //MyAdapter里的公共构造方法
        mMyAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            //点击监听
            @Override
            public void onItemClickListener(MyAdapter.MyViewHolder viewHolder, int pos) {
                if (!isDeleteIconsShow) {
                    Toast.makeText(Main2Activity.this, mSelectedDatas.get(pos), Toast.LENGTH_SHORT).show();
                }
            }

            //长按item监听
            @Override
            public void onItemLongClickListener(MyAdapter.MyViewHolder viewHolder, int pos) {
                if (!isDeleteIconsShow) {
                    showAllDeleteIcons();
                    mFinish.setVisibility(View.VISIBLE);
                }
            }
        });
        //点击切换栏目就隐藏所有小叉号
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllDeleteIcons();
                mFinish.setVisibility(View.INVISIBLE);
            }
        });
        //点击删除item,跟下面的同理
        mMyAdapter.setOnDeleteIconClickListener(new MyAdapter.OnDeleteIconClickListener() {
            @Override
            public void onDeleteIconClick(int pos) {
                mMyAdapter_two.addData(mSelectedDatas.get(pos), mUnselectedDatas.size());
                mMyAdapter.removeData(pos);
            }
        });
        //点击下面的RecyclerView时点那个item就把那个item添加到上面的RecyclerView中去,并且删除下面的RecyclerView中相应的item项
        mMyAdapter_two.setOnitemClickListener(new MyAdapter_two.OnItemClickListener() {
            @Override
            public void onItemClick(MyAdapter_two.ViewHolder holder, int pos) {
                mMyAdapter.addData(mUnselectedDatas.get(pos), mSelectedDatas.size());
                mMyAdapter_two.removeData(pos);
            }
        });
    }

    private void showAllDeleteIcons() {
        //与hideAllDeleteIcons同理
        int count = mRecycleSelected.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = mRecycleSelected.getChildAt(i);
            ImageView delete = (ImageView) child.findViewById(R.id.delelte);
            delete.setVisibility(View.VISIBLE);
        }
        isDeleteIconsShow = true;
    }

    /**
     * 隐藏所有的删除图标
     */
    private void hideAllDeleteIcons() {
        //获得此RecyclerView的所有子条目
        int count = mRecycleSelected.getChildCount();
        for (int i = 0; i < count; i++) {
            //获得子布局
            View child = mRecycleSelected.getChildAt(i);
            //找到小叉号图片的ID
            ImageView delete = (ImageView) child.findViewById(R.id.delelte);
            //设置不可见
            delete.setVisibility(View.INVISIBLE);
        }
        //将isDeleteIconsShow重新赋值
        isDeleteIconsShow = false;
    }
}
