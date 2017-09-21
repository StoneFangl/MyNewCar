package cn.mycar.manager;

import android.content.Context;

import cn.mycar.constants.DbConstants;
import cn.mycar.enty.DaoMaster;
import cn.mycar.enty.DaoSession;

/**
 * @author Stone
 * @time 2017/9/20  9:30
 * @desc ${TODD}
 */

public class DaoManager {
    private static DaoManager sDaoManager;
    private DaoSession mDaoSession;

    private DaoManager(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context.getApplicationContext(), DbConstants.DB_NAME);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDaoSession = daoMaster.newSession();
    }

    public static DaoManager getInstance() {
        return sDaoManager;
    }

    public static void init(Context context) {
        if (sDaoManager == null) {
            synchronized (DaoManager.class) {
                if (sDaoManager == null) {
                    sDaoManager = new DaoManager(context);
                }
            }
        }
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
