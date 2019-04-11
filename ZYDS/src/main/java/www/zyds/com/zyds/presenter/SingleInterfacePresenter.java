package www.zyds.com.zyds.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;

import www.zyds.com.net.OnDataRequestListener;
import www.zyds.com.zyds.base.BasePresenter;
import www.zyds.com.zyds.modle.ISingleInterfaceModel;
import www.zyds.com.zyds.modle.SingleInterfaceModel;
import www.zyds.com.zyds.view.activity.SingleInterfaceIView;

/**
 * Created by wwp
 * DATE: 2019/4/10:10:10
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public class SingleInterfacePresenter extends BasePresenter<SingleInterfaceIView> implements ISingleInterfacePresenter {
    ISingleInterfaceModel mSingleInterfaceModel;

    public SingleInterfacePresenter() {
        this.mSingleInterfaceModel = new SingleInterfaceModel();
    }

    @Override
    public void getData(Context context, int curPage) {
        mSingleInterfaceModel.getData(context, curPage, new OnDataRequestListener<String>() {

            @Override
            public void onSuccess(String data) {
                //如果Model层请求数据成功，则此处应执行通知view层的代码
                Logger.e(data);
                mView.showArticleSuccess(data);
            }

            @Override
            public void onError(String s) {
                //如果Model层请求数据成功，则此处应执行通知view层的代码
                mView.showArticleSuccess(s);
            }

        });
    }
}
