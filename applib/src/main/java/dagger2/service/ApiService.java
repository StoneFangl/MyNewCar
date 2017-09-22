package dagger2.service;

import java.util.Map;

import dagger2.response.SplashResponse;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * @author Stone
 * @time 2017/9/21  17:57
 * @desc ${TODD}
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("/kkapi/otherapi/listBootPage.do")
    Observable<SplashResponse> getSplashData(@Field("city") String city, @HeaderMap Map<String, String> headMap, @Field("appType") String appType, @Field("version") String version);
}
