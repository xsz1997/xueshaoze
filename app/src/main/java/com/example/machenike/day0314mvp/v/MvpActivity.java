package com.example.machenike.day0314mvp.v;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.machenike.day0314mvp.R;
import com.example.machenike.day0314mvp.m.FoodBean;
import com.example.machenike.day0314mvp.p.MvpPresenter;

import java.util.List;

public class MvpActivity extends AppCompatActivity implements MapView,AdapterView.OnItemClickListener {

    private ListView mvpListView;
    private MvpPresenter mvpPresenter;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mvpListView = (ListView)findViewById(R.id.mvp_listview);
        mvpListView.setOnItemClickListener(this);
        pb = (ProgressBar) findViewById(R.id.mvp_loading);
        mvpPresenter = new MvpPresenter((MapView) this);
        //开始执行
        mvpPresenter.handledata();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void setListItem(List<FoodBean.DataBean> data) {
        MyAdapter adapter = new MyAdapter(data);
        mvpListView.setAdapter(adapter);
    }

    @Override
    public void failed() {
        Toast.makeText(MvpActivity.this,"加载失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mvpPresenter.onItemClick(position);
    }
}
