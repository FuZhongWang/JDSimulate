package com.example.p7xxtm1_g.jdsimulate.view.fragment.switchFragment;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.DetailsBean;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.MenuBean;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.ProductCatagoryBean;
import com.example.p7xxtm1_g.jdsimulate.presenter.ShowPresenter;
import com.example.p7xxtm1_g.jdsimulate.view.activity.ParticularsActivity;
import com.example.p7xxtm1_g.jdsimulate.view.adapter.ProductCatagoryRecyClearViewAdapter;
import com.example.p7xxtm1_g.jdsimulate.view.adapter.SortListViewBaseAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by P7XXTM1-G on 2018/4/28.
 */

public class SortFragment extends BaseFragment<ShowPresenter> implements AdapterView.OnItemClickListener {
    private String P_url="https://www.zhaoapi.cn/product/getProductCatagory";
    private List<MenuBean.DataBean> list = new ArrayList<>();

    private List<ProductCatagoryBean.DataBean> Clist=new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 4) {
                String obj = (String) msg.obj;
                Gson gson = new Gson();
                MenuBean menuBean = gson.fromJson(obj, MenuBean.class);
                List<MenuBean.DataBean> data = menuBean.getData();
                list.addAll(data);
                Log.e("xxx", "handleMessage: "+data.get(5).getName());

                sortListViewBaseAdapter.notifyDataSetChanged();
            }if (msg.what==5){
                String obj = (String) msg.obj;
                Gson gson = new Gson();
                ProductCatagoryBean productCatagoryBean = gson.fromJson(obj, ProductCatagoryBean.class);
                List<ProductCatagoryBean.DataBean> data = productCatagoryBean.getData();
                Clist.addAll(data);
                productCatagoryRecyClearViewAdapter.notifyDataSetChanged();

            }


        }
    };

    private String sort_url = "https://www.zhaoapi.cn/product/getCatagory";
    private ListView sortListView;
    private Message message;
    private SortListViewBaseAdapter sortListViewBaseAdapter;
    private RecyclerView recyClerViewProductCatagory;
    private ProductCatagoryRecyClearViewAdapter productCatagoryRecyClearViewAdapter;

    @Override
    public void onSuccess(String string, int flag) {
        switch (flag) {

            case 4:
                message = handler.obtainMessage();
                message.what = 4;
                message.obj = string;
                handler.sendMessage(message);

                break;
            case 5:
                message = handler.obtainMessage();
                message.what = 5;
                message.obj = string;
                handler.sendMessage(message)
                ;break;
        }
        }

        @Override
        public void onError () {

        }

    @Override
    public void onGetDataBean(DetailsBean.DataBean dataBean) {

    }

    @Override
        public ShowPresenter getBasePresenter () {
            return new ShowPresenter();
        }

        @Override
        public void initView (View v){
            sortListView = v.findViewById(R.id.sortListView);
            sortListViewBaseAdapter = new SortListViewBaseAdapter(getActivity(), list);
            sortListView.setAdapter(sortListViewBaseAdapter);
            sortListViewBaseAdapter.notifyDataSetChanged();
            recyClerViewProductCatagory = v.findViewById(R.id.recyClerViewProductCatagory);
            productCatagoryRecyClearViewAdapter = new ProductCatagoryRecyClearViewAdapter(getActivity(), Clist);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false);
            recyClerViewProductCatagory.setLayoutManager(gridLayoutManager);
            productCatagoryRecyClearViewAdapter.setOnItemClickLitener(new ProductCatagoryRecyClearViewAdapter.OnItemClickLitener() {
                @Override
                public void OnItemClickLitener(int position) {
                    Intent intent = new Intent(getActivity(), ParticularsActivity.class);
                    intent.putExtra("pid",position+"");
                    startActivity(intent);
                }
            });
            recyClerViewProductCatagory.setAdapter(productCatagoryRecyClearViewAdapter);
            sortListView.setOnItemClickListener(this);
        }

        @Override
        public void initData () {
            basePresenter.requestData(sort_url,4);
            basePresenter.requestData(P_url,5);
        }

        @Override
        public int getLayout () {
            return R.layout.sortfragment;
        }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        productCatagoryRecyClearViewAdapter.setList(position);
        productCatagoryRecyClearViewAdapter.notifyDataSetChanged();
    }

}

