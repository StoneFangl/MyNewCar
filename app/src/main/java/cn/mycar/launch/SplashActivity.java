package cn.mycar.launch;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.List;

import cn.mycar.R;
import cn.mycar.base.App;
import cn.mycar.base.BaseActivity;
import cn.mycar.base.BasePresenter;
import cn.mycar.base.BaseView;
import cn.mycar.enty.UserEnty;
import cn.mycar.enty.UserEntyDao;

/**
 * @author Stone
 * @time 2017/8/29  10:04
 * @desc 启动页的Activity
 * 1、启动动态的权限的申请。
 * 2、获取广告图进行展示。
 * 3.确定跳转的页面。
 */

public class SplashActivity extends BaseActivity<BaseView, BasePresenter<BaseView>> implements BaseView {
    private int mStatusBarColor;
    private int mAlpha = 0;

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

    @SuppressLint("NewApi")
    @Override
    public void initUI() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
/*          mStatusBarColor = getResources().getColor(R.color.colorWhite);
        StatusBarUtil.setColorForDrawerLayout(this, (DrawerLayout) findViewById(R.id.drawer_layout), mStatusBarColor, mAlpha);
        StatusBarUtil.setStatusBarDarkMode(this);*/
        //drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.colorAccent));
        LinearLayout rootView = (LinearLayout) findViewById(R.id.main_root_view);
        rootView.requestApplyInsets();
        rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                return insets.consumeSystemWindowInsets();
            }
        });
    }

    @Override
    public void initData() {
        UserEntyDao userEntyDao = App.getDaoSession().getUserEntyDao();
        for (int i = 0; i < 10; i++) {
            userEntyDao.insert(new UserEnty(null, "張三" + i, "123456", "aitan"));
        }
        List<UserEnty> userList = userEntyDao.queryBuilder().where(UserEntyDao.Properties.Id.le(10)).build().list();
        for (int i = 0; i < userList.size(); i++) {
            UserEnty userEnty = userList.get(i);
            Log.e("userEnty::", userEnty.toString());
        }

    }


    @Override
    @NonNull
    public BasePresenter<BaseView> createPresenter() {
        return new BasePresenter<>();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    protected void setStatusBar() {
/*        //        super.setStatusBar();
        StatusBarUtil.setStatusBarDarkMode(this);
        StatusBarUtil.setColorForDrawerLayout(this, (DrawerLayout) findViewById(R.id.drawer_layout), mStatusBarColor, mAlpha);*/
    }
}
