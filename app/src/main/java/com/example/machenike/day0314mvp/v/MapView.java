package com.example.machenike.day0314mvp.v;

import com.example.machenike.day0314mvp.m.FoodBean;

import java.util.List;

public interface MapView {
    void showLoading();
    void hideLoading();
    void setListItem(List<FoodBean.DataBean> data);
    void failed();
    void showMessage(String message);
}
