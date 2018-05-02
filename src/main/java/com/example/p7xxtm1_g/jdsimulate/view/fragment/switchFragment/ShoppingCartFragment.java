package com.example.p7xxtm1_g.jdsimulate.view.fragment.switchFragment;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.DataJson;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.DetailsBean;
import com.example.p7xxtm1_g.jdsimulate.presenter.ShowPresenter;
import com.example.p7xxtm1_g.jdsimulate.view.adapter.ShoppingBaseExpandableListAdapter;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by P7XXTM1-G on 2018/4/28.
 */

public class ShoppingCartFragment extends BaseFragment<ShowPresenter> {

    private  static List<DetailsBean> list=new ArrayList<>();
    private ExpandableListView expandalistview;
    private int count;
    private ShoppingBaseExpandableListAdapter shoppingBaseExpandableListAdapter;
    private CheckBox quanbu;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSuccess(String string, int flag) {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onGetDataBean(DetailsBean.DataBean dataBean) {

    }

    @Override
    public ShowPresenter getBasePresenter() {
        return new ShowPresenter();
    }

    @Override
    public void initView(View v) {
        expandalistview = v.findViewById(R.id.expandalistview);
        quanbu = v.findViewById(R.id.quanbu);
    }


    @Override
    public void initData() {
        AssetManager assets = getActivity().getAssets();
        try {
            InputStream open = assets.open("data.json");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len = 0 ;
            byte[] bytes = new byte[1024*8];
            while ((len=open.read(bytes))!=-1){
                baos.write(bytes,0,len);


            }
            String s = baos.toString();
            Gson gson = new Gson();
            DataJson dataJson = gson.fromJson(s, DataJson.class);
            List<DataJson.ContentBean> content = dataJson.getContent();
            shoppingBaseExpandableListAdapter = new ShoppingBaseExpandableListAdapter(getActivity(), content);
            shoppingBaseExpandableListAdapter.setQuanBu(quanbu);
            expandalistview.setGroupIndicator(null);
            expandalistview.setAdapter(shoppingBaseExpandableListAdapter);
            shoppingBaseExpandableListAdapter.notifyDataSetChanged();
            quanbu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    shoppingBaseExpandableListAdapter.allCheck(quanbu.isChecked());
                }
            });
            count = expandalistview.getCount();

            expandalistview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                @Override
                public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                    return false;
                }
            });
            expandalistview.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                @Override
                public void onGroupExpand(int groupPosition) {
                }
            });
/*
            shoppingBaseExpandableListAdapter.notifyDataSetChanged();
*/
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getLayout() {
        return R.layout.shoppingcartfragment;
    }

    public static void setList(DetailsBean bean){
        list.add(bean);
    }
}
