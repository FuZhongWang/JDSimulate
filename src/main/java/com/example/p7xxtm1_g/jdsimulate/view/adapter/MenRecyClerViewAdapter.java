package com.example.p7xxtm1_g.jdsimulate.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.MenuBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by P7XXTM1-G on 2018/4/28.
 */

public class MenRecyClerViewAdapter extends RecyclerView.Adapter {
    private final ImageLoader instance;
    private ArrayList<MenuBean.DataBean> list = new ArrayList<>();
    private Context context;

    public MenRecyClerViewAdapter(Context context) {
        this.context = context;
        instance = ImageLoader.getInstance();
    }
    public void setList(ArrayList<MenuBean.DataBean> list){
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_item, null);


        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).menu_text.setText(list.get(position).getName());
        instance.displayImage(list.get(position).getIcon(),((MyViewHolder) holder).menu_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView menu_text;
        private final ImageView menu_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            menu_text = itemView.findViewById(R.id.menu_text);
            menu_img = itemView.findViewById(R.id.menu_img);
        }
    }
}
