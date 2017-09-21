package base;

import android.app.Application;

import dagger2.component.AppComponent;
import dagger2.component.DaggerAppComponent;
import dagger2.model.AppModel;

/**
 * @author Stone
 * @time 2017/8/28  16:05
 * @desc ${TODD}
 */

public class BaseApplication extends Application {

    private static AppComponent mAppComponent;

    public void onCreate() {
        super.onCreate();
        String baseUrl = "";
        mAppComponent = DaggerAppComponent.builder().appModel(new AppModel(this, baseUrl)).build();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }


}
