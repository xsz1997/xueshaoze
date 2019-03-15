package com.example.machenike.day0314mvp.v;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.machenike.day0314mvp.R;
import com.example.machenike.day0314mvp.m.FoodBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    List<FoodBean.DataBean> data;

    public MyAdapter(List<FoodBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
            viewHolder.sim = convertView.findViewById(R.id.sim);
            viewHolder.tv = convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.sim.setImageURI(data.get(position).getPic());
        viewHolder.tv.setText(data.get(position).getTitle());
        return convertView;
    }

    class ViewHolder{
        SimpleDraweeView sim;
        TextView tv;
    }
}
