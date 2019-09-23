package com.example.a1807_qimoa;

import com.example.a1807_qimoa.bean.ArtBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String baseUrl="http://static.owspace.com/";
    @GET("?c=api&a=getList&page_id=0")
    Observable<ArtBean> testRe();
}
