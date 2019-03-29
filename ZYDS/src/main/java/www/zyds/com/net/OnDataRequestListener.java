package www.zyds.com.net;

/**
 * Description:得到网络请求结果接口
 * User: xjp
 * Date: 2015/6/3
 * Time: 15:42
 */

public interface OnDataRequestListener<T> {
    void onSuccess(T t);

    void onError(String s);
}
