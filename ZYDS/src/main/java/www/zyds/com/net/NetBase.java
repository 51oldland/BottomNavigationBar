package www.zyds.com.net;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.HashMap;
import java.util.Map;

import www.zyds.com.base.MyApp;

/**
 * Created by wwp
 * DATE: 2018/11/19:16:29
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public class NetBase {


    public static Map<String, String> appendCommParams(Context context) {
        Map<String, String> params = new HashMap<String, String>();
//        params.put(UrlString.VERSION_NAME, VersionCodeAndNameUtils.getAppVersionName(context));
//        params.put(UrlString.SYSTEM_TYPE_NAME, UrlString.SYSTEM_TYPE);
//        params.put(GetUserTokenUtils.TOKEN_NAME, GetUserTokenUtils.getToken(context));
        return params;
    }
    public static void getStringReq(Context context,String url,Map<String,String> params,final OnDataRequestListener listener){
        NewStringRequest request = new NewStringRequest(context, Request.Method.GET, url, params, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.onSuccess(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onError(volleyError.toString());
            }
        });
        MyApp.getmQueue().add(request);
    }
    public static void postStringReq(Context context,String url,Map<String,String> params,final OnDataRequestListener listener){
        NewStringRequest request = new NewStringRequest(context, Request.Method.POST, url, params, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.onSuccess(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onError(volleyError.toString());
            }
        });
        MyApp.getmQueue().add(request);
    }
    public static void get_req(Context context, String url, Object o, Map<String, String> params, final OnDataRequestListener listener) {
        GsonForVolleyRequest request = new GsonForVolleyRequest(context, Request.Method.GET, url, o.getClass(),
                params, new Response.Listener() {
            @Override
            public void onResponse(Object o) {
                listener.onSuccess(o);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onError(volleyError.toString());
            }
        });
        MyApp.getmQueue().add(request);
    }

    public static void post_req(Context context, String url, Object o, Map<String, String> params, final OnDataRequestListener listener) {
        GsonForVolleyRequest request = new GsonForVolleyRequest(context, Request.Method.POST, url, o.getClass(),
                params, new Response.Listener() {
            @Override
            public void onResponse(Object o) {
                listener.onSuccess(o);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onError(volleyError.toString());
            }
        });
        MyApp.getmQueue().add(request);
    }
}
