package com.example.machenike.day0314mvp.p;

import com.example.machenike.day0314mvp.m.DataModule;
import com.example.machenike.day0314mvp.m.FoodBean;
import com.example.machenike.day0314mvp.m.ModuleInterface;
import com.example.machenike.day0314mvp.v.MapView;

import java.util.List;

public class MvpPresenter implements ModuleInterface {
    private MapView mvpView;

    DataModule dataModule = new DataModule(this);
    public MvpPresenter(MapView mvpView) {
        this.mvpView = mvpView;
    }

    public  void handledata(){
        mvpView.showLoading();
        dataModule.getData();
    }

    @Override
    public void LoadSuccess(List<FoodBean.DataBean> data) {
        mvpView.hideLoading();
        mvpView.setListItem(data);
    }

    @Override
    public void LoadFailed() {
        mvpView.failed();

    }

    public void onItemClick(int position){
        mvpView.showMessage("点击了"+position);
    }
}
