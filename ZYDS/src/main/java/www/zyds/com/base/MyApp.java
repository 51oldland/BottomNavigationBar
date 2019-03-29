package www.zyds.com.base;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import www.zyds.com.BuildConfig;

/**
 * Created by wwp
 * DATE: 2018/11/19:15:10
 * Copyright: 中国自主招生网 All rights reserved
 * Description: MyApp
 */

public class MyApp extends Application {
    private static MyApp mApp;
    private static RequestQueue mQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
        mApp = this;

    }
    public static RequestQueue getmQueue(){
        if (mQueue==null){
            mQueue = Volley.newRequestQueue(mApp);
        }
        return mQueue;
    }
    public static MyApp getInstance(){
        if(mApp == null){
            mApp = new MyApp();
        }
        return mApp;
    }

    private void initLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)      //（可选）是否显示线程信息。 默认值为true
                .methodCount(0)               // （可选）要显示的方法行数。 默认2
                .methodOffset(0)               // （可选）设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息，默认是0
                .tag("WWP")                  //（可选）每个日志的全局标记。 默认PRETTY_LOGGER（如上图）
                .build();
//      Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
//      Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
        //把log存到本地
        Logger.addLogAdapter(new DiskLogAdapter());
    }
}
