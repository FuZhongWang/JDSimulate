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
import com.example.p7xxtm1_g.jdsimulate.model.pojo.ProductCatagoryBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P7XXTM1-G on 2018/4/29.
 */

public class ProductCatagoryRecyClearViewAdapter extends RecyclerView.Adapter {
    private final ImageLoader instance;
    private Context context;
    private List<ProductCatagoryBean.DataBean> list = new ArrayList<>();
    private OnItemClickLitener onItemClickLitener;
    private int index = 0 ;
    public void setList(int index){
        this.index = index;

    }
    public ProductCatagoryRecyClearViewAdapter(Context context, List<ProductCatagoryBean.DataBean> list) {
        this.context = context;
        this.list = list;
        instance = ImageLoader.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.productcatagory_item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHolder){

            ((MyViewHolder) holder).productCatagory_text.setText(list.get(index).getList().get(position).getName());
            instance.displayImage(list.get(index).getList().get(position).getIcon(),((MyViewHolder) holder).productCatagory_img);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickLitener.OnItemClickLitener(list.get(index).getList().get(position).getPscid());
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.get(index).getList().size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView productCatagory_text;
        private final ImageView productCatagory_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            productCatagory_text = itemView.findViewById(R.id.productCatagory_text);
            productCatagory_img = itemView.findViewById(R.id.productCatagory_img);
        }
    }
    public interface OnItemClickLitener{

        public void OnItemClickLitener(int position);
    }
    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        this.onItemClickLitener = onItemClickLitener;
    }
}
