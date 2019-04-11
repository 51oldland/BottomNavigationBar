package www.zyds.com.zyds.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import www.zyds.com.R;
import www.zyds.com.zyds.base.BaseMVPActivity;
import www.zyds.com.zyds.contract.BannerInterfaceContract;
import www.zyds.com.zyds.presenter.BannerPresenter;

public class BannerActivity extends BaseMVPActivity<BannerPresenter> implements BannerInterfaceContract.BannerView {


    @BindView(R.id.banner)
    Button mBanner;
    @BindView(R.id.showBannerData)
    TextView mShowBannerData;

    @Override
    protected BannerPresenter createPresenter() {
        return new BannerPresenter();
    }

    @Override
    protected void init() {
        setContentView(R.layout.activity_banner);
        ButterKnife.bind(this);
        mBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getData(getApplicationContext());
            }
        });
    }

    @Override
    public void showSuccess(String s) {
        mShowBannerData.setText(s);
    }

    @Override
    public void showFaild(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
