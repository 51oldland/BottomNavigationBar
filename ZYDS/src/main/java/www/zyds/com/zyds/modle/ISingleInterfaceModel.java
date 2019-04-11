package www.zyds.com.zyds.modle;

import android.content.Context;

import www.zyds.com.net.OnDataRequestListener;

/**
 * Created by wwp
 * DATE: 2019/4/10:14:58
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public interface ISingleInterfaceModel extends IModel{
    void getData(Context context, int Num, OnDataRequestListener<String> onDataRequestListener);
}
