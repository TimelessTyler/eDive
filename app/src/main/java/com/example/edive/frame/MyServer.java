package com.example.edive.frame;

import com.example.edive.bean.FindPasswordBean;
import com.example.edive.bean.LoginBean;
import com.example.edive.bean.VerificationBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyServer {
    String url = "http://47.107.50.253:8080/DmdMall/";

    @POST("sso/login?")
    @FormUrlEncoded
    @Headers({"Content-Type:application/x-www-form-urlencoded","Authorization:Basic ZG1kOjEyMzQ1Ng=="})
    Observable<LoginBean> getPasswordLogin(@Field("grant_type")String type, @Field("username")String username, @Field("password")String password, @Field("loginType")String loginType);

    @GET("sso/getAuthCode?")
    @Headers("deviceId:007")
    Observable<VerificationBean> getVerGetcode(@Query("mobile") String mobile);

    @POST("sso/coach/register?")
    @Headers("deviceId:007")
    Observable<VerificationBean> getRegister(@Body RequestBody body);

    @POST("sso/coach/findPassword?")
    @Headers("deviceId:007")
    Observable<FindPasswordBean> getFindPassword(@Body RequestBody body);
}
