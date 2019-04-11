package www.zyds.com.zyds.contract;

import android.content.Context;

import www.zyds.com.zyds.view.activity.IView;

/**
 * Created by wwp
 * DATE: 2019/4/11:10:39
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public interface BannerInterfaceContract {

    interface BannerView extends IView{
        void showSuccess(String s);
        void showFaild(String s);
    }
    interface BannerPresenter {
        void getData(Context context);
    }
}
