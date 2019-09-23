package com.example.yaoyufei.a1807_qimob;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService  {
    String baseUrl="http://gank.io/api/";

    @GET("data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<ArtBean> testRe();


}
