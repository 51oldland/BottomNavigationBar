package www.zyds.com.zyds.presenter;

import www.zyds.com.zyds.view.activity.IView;

/**
 * Created by wwp
 * DATE: 2019/4/10:10:46
 * Copyright: 中国自主招生网 All rights reserved
 * Description:
 *
 * @param <T> the type parameter
 */
public interface IPresenter<T extends IView> {
    /**
     * 依附生命 view.
     *
     * @param view the view
     */
    void attachView(T view);

    /**
     * 分离 view.
     */
    void detachView();

    /**
     * 判断View是否已经销毁
     *
     * @return the boolean
     */
    boolean isViewAttach();
}
