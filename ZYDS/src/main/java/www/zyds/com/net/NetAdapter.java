package www.zyds.com.net;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import www.zyds.com.R;
import www.zyds.com.zyds.bean.LogEntity;

/**
 * Created by wwp
 * DATE: 2018/11/19:16:30
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public class NetAdapter extends NetBase {

    public static String getApiPath(Context context, String path) {
        return "http://" + context.getString(R.string.domain) + path;
    }
    /**
     * 登录
     */
    public static void login(Context context, final String phone,
                             final String password, OnDataRequestListener<LogEntity> listener) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", phone);
        params.put("passwd", password);
        get_req(context,getApiPath(context,UrlString.PATH_LOGIN),LogEntity.class,params,listener);
    }
    /**
     * 登录
     */
    public static void login2(Context context, final String phone,
                             final String password, OnDataRequestListener listener) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", phone);
        params.put("passwd", password);
        getStringReq(context,getApiPath(context,UrlString.PATH_LOGIN),params,listener);
    }
}
