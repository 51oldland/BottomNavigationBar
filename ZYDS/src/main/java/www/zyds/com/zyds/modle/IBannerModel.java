package www.zyds.com.zyds.modle;

import android.content.Context;

import www.zyds.com.net.OnDataRequestListener;

/**
 * Created by wwp
 * DATE: 2019/4/11:10:46
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public interface IBannerModel extends IModel{
    void getData(Context context, OnDataRequestListener<String> onDataRequestListener);
}
