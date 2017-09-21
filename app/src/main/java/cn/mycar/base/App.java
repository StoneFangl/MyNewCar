package cn.mycar.base;

import android.app.Application;

import cn.mycar.enty.DaoSession;
import cn.mycar.manager.DaoManager;

/**
 * @author Stone
 * @time 2017/8/28  18:09
 * @desc ${TODD}
 */

public class App extends Application {
    private static App sApp;

    public void onCreate() {
        super.onCreate();
        sApp = this;
        DaoManager.init(this);
    }

    public static Application getApplication() {
        return sApp;
    }

    public static DaoSession getDaoSession() {
        return DaoManager.getInstance().getDaoSession();
    }
}
