package com.example.edive.frame;


import com.example.edive.bean.BannerInfo;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface INetService {
    @POST("shop/shopAdvertise")
    Observable<BannerInfo> getFuData(@Body RequestBody body);
}
