package cn.mycar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.HashMap;

import base.BaseApplication;
import cn.mycar.R;
import dagger2.response.SplashResponse;
import dagger2.service.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiService apiService = BaseApplication.getAppComponent().apiService();
        HashMap<String, String> headMap = new HashMap<>();
        headMap.put("appType", "android");
        headMap.put("version", "4.5.1");
        apiService.getSplashData("广州", headMap, "android", "4.5.0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<SplashResponse>() {
            public void accept(@NonNull SplashResponse splashResponse) throws Exception {
                Toast.makeText(MainActivity.this, splashResponse.data.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
