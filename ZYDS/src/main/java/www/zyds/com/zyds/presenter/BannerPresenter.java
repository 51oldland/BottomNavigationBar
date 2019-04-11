package www.zyds.com.zyds.presenter;

import android.content.Context;

import www.zyds.com.net.OnDataRequestListener;
import www.zyds.com.zyds.base.BasePresenter;
import www.zyds.com.zyds.contract.BannerInterfaceContract;
import www.zyds.com.zyds.modle.BannerModel;
import www.zyds.com.zyds.modle.IBannerModel;

/**
 * Created by wwp
 * DATE: 2019/4/11:10:52
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public class BannerPresenter extends BasePresenter<BannerInterfaceContract.BannerView> implements BannerInterfaceContract.BannerPresenter {
    IBannerModel mIBannerModel;

    public BannerPresenter() {
        this.mIBannerModel = new BannerModel();
    }

    @Override
    public void getData(Context context) {
        mIBannerModel.getData(context, new OnDataRequestListener<String>() {
            @Override
            public void onSuccess(String s) {
                mView.showSuccess(s);
            }

            @Override
            public void onError(String s) {
                mView.showFaild(s);
            }
        });
    }
}
