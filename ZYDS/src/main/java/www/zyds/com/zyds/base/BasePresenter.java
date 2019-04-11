package www.zyds.com.zyds.base;

import www.zyds.com.zyds.presenter.IPresenter;
import www.zyds.com.zyds.view.activity.IView;

/**
 * Created by wwp
 * DATE: 2019/4/10:15:23
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 */

public abstract class BasePresenter<T extends IView> implements IPresenter<T> {
    protected T mView;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public boolean isViewAttach() {
        return mView != null;
    }
}
