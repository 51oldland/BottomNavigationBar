package www.zyds.com.zyds.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import www.zyds.com.R;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT = 2500; // 延迟

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //跳转至 MainActivity
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                //结束当前的 Activity
                finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}
