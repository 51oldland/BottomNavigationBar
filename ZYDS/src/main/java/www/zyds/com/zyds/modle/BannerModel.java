package www.zyds.com.zyds.modle;

import android.content.Context;

import www.zyds.com.net.NetAdapter;
import www.zyds.com.net.OnDataRequestListener;

/**
 * Created by wwp
 * DATE: 2019/4/11:10:47
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public class BannerModel implements IBannerModel {

    @Override
    public void getData(Context context, OnDataRequestListener<String> onDataRequestListener) {
        NetAdapter.getBanner(context, onDataRequestListener);
    }
}
