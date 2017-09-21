package dagger2.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import dagger2.model.AppModel;
import dagger2.service.ApiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @author Stone
 * @time 2017/9/21  18:10
 * @desc ${TODD}
 */
@Singleton
@Component(modules = {AppModel.class})
public interface AppComponent {
    Application application();
    String baseUrl();

    OkHttpClient okHttpClient();

    Retrofit retrofit();

    ApiService apiService();
}
