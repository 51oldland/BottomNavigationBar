package www.zyds.com.zyds.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import www.zyds.com.zyds.presenter.IPresenter;
import www.zyds.com.zyds.view.activity.IView;

public abstract class BaseMVPActivity<T extends IPresenter> extends AppCompatActivity implements IView {
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        init();
    }

    protected void initPresenter() {
        mPresenter = createPresenter();
        //绑定生命周期
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 创建一个Presenter
     *
     * @return
     */
    protected abstract T createPresenter();

    protected abstract void init();
}
