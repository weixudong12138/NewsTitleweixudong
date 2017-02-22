package bwei.com.newtitleweixudong.base.network;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bwei.com.newtitleweixudong.home.HomeBean;


/**
 * Created by Administrator on 2017/2/14.
 */

public class XutilNet {

    public static<T> void getdata(final CallbackData callbackData, final Class<T>classs, String url) {
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                List<T>t=new ArrayList<T>();
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    Iterator<String> keys = jsonObject.keys();
                    while (keys.hasNext()){
                        String next = keys.next();
                        JSONArray jsonArray = jsonObject.optJSONArray(next);
                        for (int i = 0; i <jsonArray.length() ; i++) {
                            JSONObject jsonObject1 = jsonArray.optJSONObject(i);
                            T t1 = gson.fromJson(jsonObject1.toString(), classs);
                            t.add(t1);
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

        //        T t = gson.fromJson(result, classs);

                callbackData.success(t);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    public interface CallbackData<T> {
        void success(List<T> t);
    }
}
