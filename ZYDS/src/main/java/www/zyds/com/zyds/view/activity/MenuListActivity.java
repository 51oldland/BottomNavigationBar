package www.zyds.com.zyds.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.zyds.com.R;
import www.zyds.com.zyds.base.BaseMVPActivity;
import www.zyds.com.zyds.bean.User;
import www.zyds.com.zyds.presenter.SingleInterfacePresenter;

public class MenuListActivity extends BaseMVPActivity<SingleInterfacePresenter>
        implements View.OnClickListener, SingleInterfaceIView {

    @BindView(R.id.toMain)
    Button mToMain;
    @BindView(R.id.toSwipMeun)
    Button mToSwipMeun;

    @Inject
    User mUser;
    @BindView(R.id.showText)
    Button mShowText;
    @BindView(R.id.showValue)
    TextView mShowValue;
    @BindView(R.id.toBanner)
    Button mToBanner;

    @Override
    protected SingleInterfacePresenter createPresenter() {
        return new SingleInterfacePresenter();
    }

    @Override
    protected void init() {
        setContentView(R.layout.activity_menu_list);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
//        DaggerActivityComponent.builder().build().inject(this);
//        mUser.setName("laotu");
        mToMain.setOnClickListener(this);
        mToSwipMeun.setOnClickListener(this);
        mShowText.setOnClickListener(this);
        mToBanner.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showText:
                mPresenter.getData(this, 0);
                break;
            case R.id.toMain:
                Intent intent = new Intent(MenuListActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.toSwipMeun:
                Intent intent1 = new Intent(MenuListActivity.this, SwipMeunActivity.class);
                startActivity(intent1);
                break;
            case R.id.toBanner:
                Intent intent2 = new Intent(MenuListActivity.this, BannerActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void showArticleSuccess(String bean) {
        Toast.makeText(this, bean, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showArticleFail(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
