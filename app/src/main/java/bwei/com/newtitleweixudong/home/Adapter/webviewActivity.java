package bwei.com.newtitleweixudong.home.Adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.umeng.message.PushAgent;

import bwei.com.newtitleweixudong.R;


import static anetwork.channel.http.NetworkSdkSetting.context;

public class webviewActivity extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        PushAgent.getInstance(context).onAppStart();

        webview = (WebView) findViewById(R.id.fragmenthome_webview);
     webview.setWebViewClient(new WebViewClient(){
         @Override
         public void onPageFinished(WebView view, String url) {
             super.onPageFinished(view, url);
             //加载完成的时候调用这个方法

         }
     });
     initview();

    }

    private void initview() {
      Intent intent= getIntent();
      String position= intent.getStringExtra("url")  ;
        webview.loadUrl(position);


     }
//捕捉返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            //首先我们要去判断一下他是否有历史页面(我们是否之前有进入到二、三级等页面)
            if(webview.canGoBack()){
                webview.goBack();
                return true;
            }else{
                //退出应用或者Activity
                System.exit(0);
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
