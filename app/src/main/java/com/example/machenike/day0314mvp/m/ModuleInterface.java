package com.example.machenike.day0314mvp.m;

import java.util.List;

public interface ModuleInterface {
    void LoadSuccess(List<FoodBean.DataBean> data);
    void LoadFailed();
}
