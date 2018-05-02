package com.example.p7xxtm1_g.jdsimulate.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.MenuBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P7XXTM1-G on 2018/4/28.
 */

public class SortListViewBaseAdapter extends BaseAdapter {

    private Context context;
    private List<MenuBean.DataBean> list= new ArrayList<>();

    public SortListViewBaseAdapter(Context context, List<MenuBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        Log.e("xxx", "getCount: "+list.size() );
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("xxx", "getView: "+position );
        ViewHolder viewHolder;
        if (convertView==null){
            Log.e("xxx", "handleMessage: "+1);
            convertView=View.inflate(context,R.layout.sort_listviewitem,null);
            viewHolder=new ViewHolder();
            viewHolder.textView=convertView.findViewById(R.id.sort_listviewtext);

            convertView.setTag(viewHolder);
        }else{

            viewHolder= (ViewHolder) convertView.getTag();
        }
        Log.e("sss", "getView: "+list.get(position).getName());
        viewHolder.textView.setText(list.get(position).getName());

        return convertView;
    }

    public class ViewHolder{
        private TextView textView;

    }
}
