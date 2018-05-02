package com.example.p7xxtm1_g.jdsimulate.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.ParticularsBean;
import com.example.p7xxtm1_g.jdsimulate.view.activity.ParticularsActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P7XXTM1-G on 2018/4/29.
 */

public class ParticularsRecyClerAdapter extends RecyclerView.Adapter {
    private List<ParticularsBean.DataBean> list = new ArrayList<>();
    private Context context;
    private final ImageLoader instance;
    private OnItemClickLitener onItemClickLitener;
    public ParticularsRecyClerAdapter(List<ParticularsBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        instance = ImageLoader.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.particulars_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        ((MyViewHolder) holder).particulars_title.setText(list.get(position).getTitle());
        ((MyViewHolder) holder).particulars_price.setText(list.get(position).getPrice()+"");
        instance.displayImage(split[0],((MyViewHolder) holder).particulars_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickLitener.OnItemClickLitener(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView particulars_title;
        private final TextView particulars_price;
        private final ImageView particulars_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            particulars_title = itemView.findViewById(R.id.particulars_title);
            particulars_price = itemView.findViewById(R.id.particulars_price);
            particulars_img = itemView.findViewById(R.id.particulars_img);
        }
    }
    public interface OnItemClickLitener{

        public void OnItemClickLitener(ParticularsBean.DataBean dataBean);
    }
    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener){

        this.onItemClickLitener=onItemClickLitener;
    }


}
