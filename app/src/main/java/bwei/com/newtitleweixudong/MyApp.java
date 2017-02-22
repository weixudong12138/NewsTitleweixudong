package bwei.com.newtitleweixudong;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import org.xutils.x;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/10.
 */

public class MyApp extends Application {
    public static Map<String, Integer> mResourceMap = new HashMap<String, Integer>();
    public static int MMODE = 0;
    public static final int MODE_DAY = 0;
    public static final int MODE_NIGHT = 1;
    private static Context mApplicationcontext;
    private  static SharedPreferences msharedpreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationcontext = this.getApplicationContext();
        msharedpreferences = mApplicationcontext.getSharedPreferences("conflag",MODE_PRIVATE);
        MMODE=msharedpreferences.getInt("mode",0);

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);



        x.Ext.init(this);
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                //     Log.i("魏旭东",deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                //  Log.i("微微",s+s1);
            }
        });


    }
    public static void asveMode(){
        SharedPreferences.Editor edit=  msharedpreferences.edit();
        edit.putInt("mode",0);
        edit.commit();
    }


    public static void stitchMode(int mode) {
        switch (mode) {
            case 0:
                mResourceMap.put("textcolor", R.color.color_night);
                mResourceMap.put("backcolor", R.color.color_day);
                mResourceMap.put("phone", R.drawable.cellphoneicon_login_profile);
                mResourceMap.put("qq", R.drawable.qqicon_login_profile);
                mResourceMap.put("weixin", R.drawable.weixin_allshare_normal);

                break;
            case 1:
                mResourceMap.put("textcolor", R.color.color_day);
                mResourceMap.put("backcolor", R.color.color_night);
                mResourceMap.put("phone", R.drawable.cellphoneicon_login_profile_press);
                mResourceMap.put("qq", R.drawable.qqicon_login_profile_press);
                mResourceMap.put("weixin", R.drawable.weixin_allshare_pressed);
                break;

        }
    }
}