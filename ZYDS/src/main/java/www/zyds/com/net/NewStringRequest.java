package www.zyds.com.net;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by wwp
 * DATE: 2018/11/20:18:52
 * Copyright: 中国自主招生网 All rights reserved
 * Description: volley封装带有请求头和请求体的StringRequest
 */

public class NewStringRequest extends StringRequest{
    private Response.Listener<String> mListener ;

    private Context mContext;

    private Map<String,String> mMapBod;

    public NewStringRequest(Context context,int method, String url,Map<String,String> mapBod, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        mMapBod = mapBod;
        mListener = listener;
        mContext = context;
    }

    public NewStringRequest(Context context,String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this(context,Method.GET,url,null,listener,errorListener);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return NetBase.appendCommParams(mContext);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        if (mMapBod!=null&&mMapBod.size()>0){
            return mMapBod;
        }else {
            return super.getParams();
        }
    }
}
