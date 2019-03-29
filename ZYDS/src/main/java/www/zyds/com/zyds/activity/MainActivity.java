package www.zyds.com.zyds.activity;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.jaeger.library.StatusBarUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

import www.zyds.com.R;
import www.zyds.com.zyds.base.BaseActivity;
import www.zyds.com.zyds.fragment.ImageFragment;
import www.zyds.com.zyds.fragment.SimpleFragment;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_RIPPLE;
import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;
import static com.ashokvarma.bottomnavigation.ShapeBadgeItem.SHAPE_STAR_5_VERTICES;

public class MainActivity extends BaseActivity {
    private ViewPager mVpHome;
    private BottomNavigationBar mBottomNavigationBar;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();

    TextBadgeItem mTextBadgeItem;
    ShapeBadgeItem mShapeBadgeItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        StatusBarUtil.setTranslucent(this, 69);
        initView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "chat";
            String channelName = "聊天消息";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId, channelName, importance);
            channelId = "subscribe";
            channelName = "订阅消息";
            importance = NotificationManager.IMPORTANCE_DEFAULT;
            createNotificationChannel(channelId, channelName, importance);
        }
    }

    private void initView() {
        mVpHome = (ViewPager) findViewById(R.id.vp_home);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        /*
        * setMode(int mode):　设置点击的动画效果
　　      MODE_DEFAULT
　　      MODE_FIXED （title不选中也会显示，itemicon效果自己尝试）
　　      MODE_SHIFTING （title只有选中才会显示，不选中隐藏，icon效果自己尝试）
　　      MODE_FIXED_NO_TITLE （不显示title，icon效果与MODE_FIXED一致）
　　      MODE_SHIFTING_NO_TITLE （不显示title，icon效果与MODE_SHIFTING一致）
          setBackgroundStyle(int style): 背景点击样式
　　      BACKGROUND_STYLE_DEFAULT
　　      BACKGROUND_STYLE_STATIC（普通点击效果）
　　      BACKGROUND_STYLE_RIPPLE（点击有水波扩散效果）
          setBarBackgroundColor()：bar背景颜色，在 BACKGROUND_STYLE_RIPPLE 下为图标和文本被激活或选中的颜色；
          setInActiveColor()：item未选中icon、title颜色；
          setActiveColor()：item选中icon、title颜色，在BACKGROUND_STYLE_RIPPLE下，为整个控件的背景颜色；
        *
        */
        mTextBadgeItem = new TextBadgeItem()
                .setBackgroundColor("#ff0000")
                .setGravity(Gravity.RIGHT | Gravity.TOP) // 默认为右上角
                .setTextColor("#ffffff")
                .setText("3")
                .setHideOnSelect(false);//true：当选中状态时消失，非选中状态显示,moren false
        mShapeBadgeItem = new ShapeBadgeItem()
                .setShape(SHAPE_STAR_5_VERTICES) //形状
                .setShapeColor(Color.BLUE) //颜色
                .setShapeColorResource(R.color.colorAccent) //颜色，资源文件获取
                .setEdgeMarginInDp(this, 0) //距离Item的margin，dp
//    .setEdgeMarginInPixels(20) //距离Item的margin，px
                .setSizeInDp(this, 20, 20) //宽高，dp
//    .setSizeInPixels(5,5) //宽高，px
                .setAnimationDuration(200) //隐藏和展示的动画速度，单位毫秒,和    setHideOnSelect一起使用
//    .setGravity(Gravity.LEFT) //位置，默认右上角
                .setHideOnSelect(true);//true：当选中状态时消失，非选中状态显示,moren false
        mBottomNavigationBar.setMode(MODE_FIXED)
                .setBackgroundStyle(BACKGROUND_STYLE_RIPPLE)  // 背景样式
                .setBarBackgroundColor("#2FA8E1") // 背景颜色
                .setInActiveColor("#929292") // 未选中状态颜色
                .setActiveColor("#ffffff") // 选中状态颜色
                .addItem(new BottomNavigationItem(R.drawable.icon_home_tab_home_green, "首页")
                        .setInactiveIconResource(R.drawable.icon_home_tab_home_gray_green).setBadgeItem(mTextBadgeItem)) // 添加Item
                .addItem(new BottomNavigationItem(R.drawable.sy_fl_icon_mx, "分类")
                        .setInactiveIconResource(R.drawable.sy_fl_icon_xx))
                .addItem(new BottomNavigationItem(R.drawable.icon_home_tab_xuebang_green, "学帮")
                        .setInactiveIconResource(R.drawable.icon_home_tab_xuebang_gray_green))
                .addItem(new BottomNavigationItem(R.drawable.icon_home_tab_self_green, "我的")
                        .setInactiveIconResource(R.drawable.icon_home_tab_self_gray_green))
                .setFirstSelectedPosition(0) //设置默认选中位置
                .initialise();
        setIconItemMargin(mBottomNavigationBar,10,25,14);
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                mVpHome.setCurrentItem(position);
                switch (position){
                    case 0:
                        mTextBadgeItem.setText("6");
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
        mFragmentList.add(new ImageFragment());
        mFragmentList.add(new SimpleFragment());
        mFragmentList.add(new SimpleFragment());
        mFragmentList.add(new SimpleFragment());

        mVpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomNavigationBar.selectTab(position);
                switch (position) {
                    case 0:
                        break;
                    default:
                        Random random = new Random();
                        int color = 0xff000000 | random.nextInt(0xffffff);
                        if (mFragmentList.get(position) instanceof SimpleFragment) {
                            ((SimpleFragment) mFragmentList.get(position)).setTvTitleBackgroundColor(color);
                        }
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mVpHome.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
    }

    public void sendChatMsg(View view) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this, "chat")
                .setContentTitle("收到一条聊天消息")
                .setContentText("今天中午吃什么？")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .build();
        manager.notify(1, notification);
    }

    public void sendSubscribeMsg(View view) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this, "subscribe")
                .setContentTitle("收到一条订阅消息")
                .setContentText("地铁沿线30万商铺抢购中！")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .build();
        manager.notify(2, notification);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, 0, null);
    }
    /**
     * 修改间距及图片文字大小
     * @param bottomNavigationBar
     * @param space  文字与图片的间距
     * @param imgLen  单位：dp，图片大小
     * @param textSize 单位：dp，文字大小
     */
    private void setIconItemMargin(BottomNavigationBar bottomNavigationBar, int space, int imgLen, int textSize){
        Class barClass = bottomNavigationBar.getClass();
        Field[] fields = barClass.getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
            Field field = fields[i];
            field.setAccessible(true);
            if(field.getName().equals("mTabContainer")){
                try{
                    //反射得到 mTabContainer
                    LinearLayout mTabContainer = (LinearLayout) field.get(bottomNavigationBar);
                    for(int j = 0; j < mTabContainer.getChildCount(); j++){
                        //获取到容器内的各个Tab
                        View view = mTabContainer.getChildAt(j);
                        //获取到Tab内的各个显示控件
                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(56));
                        FrameLayout container = (FrameLayout) view.findViewById(R.id.fixed_bottom_navigation_container);
                        container.setLayoutParams(params);
                        container.setPadding(dip2px(12), dip2px(0), dip2px(12), dip2px(0));

                        //获取到Tab内的文字控件
                        TextView labelView = (TextView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_title);
                        //计算文字的高度DP值并设置，setTextSize为设置文字正方形的对角线长度，所以：文字高度（总内容高度减去间距和图片高度）*根号2即为对角线长度，此处用DP值，设置该值即可。
                        labelView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize);
                        labelView.setIncludeFontPadding(false);
                        labelView.setPadding(0,0,0,dip2px(20-textSize - space/2));

                        //获取到Tab内的图像控件
                        ImageView iconView = (ImageView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_icon);
                        //设置图片参数，其中，MethodUtils.dip2px()：换算dp值
                        params = new FrameLayout.LayoutParams(dip2px(imgLen), dip2px(imgLen));
                        params.setMargins(0,0,0,space/2);
                        params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                        iconView.setLayoutParams(params);
                    }
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private int dip2px(float dpValue) {
        final float scale = getApplication().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
