package www.zyds.com.zyds.modle;

import android.content.Context;

import www.zyds.com.net.NetAdapter;
import www.zyds.com.net.OnDataRequestListener;

/**
 * Created by wwp
 * DATE: 2019/4/10:10:10
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public class SingleInterfaceModel implements ISingleInterfaceModel {
    @Override
    public void getData(Context context, int Num, OnDataRequestListener<String> callback) {
        NetAdapter.getData(context, Num, callback);
    }
}
