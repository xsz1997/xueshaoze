package com.example.machenike.day0314mvp.m;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyInterface {
    @GET
    Observable<FoodBean> getData(@Url String url);
}
