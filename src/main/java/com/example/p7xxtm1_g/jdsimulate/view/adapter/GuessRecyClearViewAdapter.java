package com.example.p7xxtm1_g.jdsimulate.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.Recommend;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P7XXTM1-G on 2018/4/28.
 */

public class GuessRecyClearViewAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Recommend.TuijianBean.ListBean> list = new ArrayList<>();
    private final ImageLoader instance;
    public GuessRecyClearViewAdapter(Context context, List<Recommend.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
        instance = ImageLoader.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.guess_item, null);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        ((MyViewHolder) holder).guess_text.setText(list.get(position).getTitle());
        instance.displayImage(split[0],((MyViewHolder) holder).guess_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView guess_text;
        private final ImageView guess_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            guess_text = itemView.findViewById(R.id.guess_text);
            guess_img = itemView.findViewById(R.id.guess_img);
        }
    }
}
