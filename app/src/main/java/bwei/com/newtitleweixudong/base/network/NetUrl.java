package bwei.com.newtitleweixudong.base.network;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/13.
 */

public class NetUrl {

    public static String getUrl(String type,int page){

       String CHOOSE = "http://c.m.163.com/nc/article/headline/"+type+"/"+page+"-20.html";
        return  CHOOSE;
    }
public static String getvideourl(String type,int page){
    String url="http://c.3g.163.com/nc/video/list/"+type+"/n/"+page+"-10.html";
    return url;
}

    public static String setUrl(Map<String, String> map) {

        int i = 0;//用来判断参数是第一个

        String url = "";

        Iterator<Map.Entry<String, String>> entryIterator = map.entrySet().iterator();

        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            if (i == 0) {
                url += entry.getKey() + "=" + entry.getValue();
            } else {
                url += "&" + entry.getKey() + "=" + entry.getValue();
            }
            i++;
        }
        return url;
    }

}
