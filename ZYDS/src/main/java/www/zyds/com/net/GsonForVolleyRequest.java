package www.zyds.com.net;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by lsh on 2016/6/7.
 */
public class GsonForVolleyRequest<T> extends Request<T> {

    private final Response.Listener<T> mListener;

    private Gson mGson;

    private Class<T> mClass;

    private Context mContext;

    private Map<String,String> mMapBod;
    public GsonForVolleyRequest(Context context, int method, String url, Class<T> clazz,Map<String,String> mapBod, Response.Listener<T> listener,
                                Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mMapBod = mapBod;
        mGson = new Gson();
        mClass = clazz;
        mListener = listener;
        mContext = context;
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

    public GsonForVolleyRequest(Context context, String url, Class<T> clazz, Response.Listener<T> listener,
                                Response.ErrorListener errorListener) {
        this(context,Method.GET, url, clazz,null, listener, errorListener);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(mGson.fromJson(jsonString, mClass),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }

}
