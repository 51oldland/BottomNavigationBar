package www.zyds.com.zyds.interfaces;

/**
 * Created by wwp
 * DATE: 2019/4/10:10:13
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public interface Callback<K, V> {
    void onSuccess(K data);

    void onFail(V data);
}
