package com.example.p7xxtm1_g.jdsimulate.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.p7xxtm1_g.jdsimulate.model.pojo.Recommend;
import com.example.p7xxtm1_g.jdsimulate.utils.ImageLoaderUtils_circle;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P7XXTM1-G on 2018/4/25.
 */

public class RecommendAdapter extends PagerAdapter {
    private final ImageLoader instance;
    private Context context;
    private List<Recommend.DataBean> list=new ArrayList<>();

    public RecommendAdapter(Context context, List<Recommend.DataBean> list) {
        this.context = context;
        this.list = list;
        instance = ImageLoader.getInstance();
    }

    @Override
    public int getCount() {
        if (list.size()>1){
            Log.e("rigou", "1handleMessage: "+">1" );
            return Integer.MAX_VALUE;
        }else{
            Log.e("rigou", "1handleMessage: "+"1" );
            return list.size();
        }

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        instance.displayImage(list.get(position%list.size()).getIcon(),imageView, ImageLoaderUtils_circle.getDisplayImageOption());
        container.addView(imageView);


        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }
}
