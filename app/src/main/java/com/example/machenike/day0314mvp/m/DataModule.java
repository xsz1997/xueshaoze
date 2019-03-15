package com.example.machenike.day0314mvp.m;


import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataModule {

    ModuleInterface mCallback;
    String baseUrl = " http://www.qubaobei.com/ios/cf/";
    String url="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";

    public DataModule(ModuleInterface mCallback) {
        this.mCallback = mCallback;
    }

    public void getData(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.baseUrl(baseUrl);
        Retrofit build = builder.build();
        MyInterface myURL = build.create(MyInterface.class);
        myURL.getData(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FoodBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FoodBean myBean) {
                        Log.e("xsz",myBean.getData().get(0).getTitle());
                        List<FoodBean.DataBean> data = myBean.getData();
                        mCallback.LoadSuccess(data);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
