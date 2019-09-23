package com.example.yaoyufei.a1807_qimob.model;

import com.example.yaoyufei.a1807_qimob.ApiService;
import com.example.yaoyufei.a1807_qimob.ArtBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel {
    public void initData(final MainCallback mainCallback){

        Observable<ArtBean> artBeanObservable = new Retrofit.Builder()
                .baseUrl(ApiService.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .testRe();
        artBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArtBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArtBean artBean) {

                        mainCallback.onSuccess(artBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        mainCallback.onField(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public interface MainCallback{
        void onSuccess(ArtBean artBean);
        void onField(String s);
    }
}
