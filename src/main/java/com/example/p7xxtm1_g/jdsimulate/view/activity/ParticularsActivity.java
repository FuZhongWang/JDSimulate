package com.example.p7xxtm1_g.jdsimulate.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.DetailsBean;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.ParticularsBean;
import com.example.p7xxtm1_g.jdsimulate.presenter.ParticularsPresenter;
import com.example.p7xxtm1_g.jdsimulate.view.adapter.ParticularsRecyClerAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class ParticularsActivity extends BaseActivity<ParticularsPresenter> {
    private String url_Particulars="https://www.zhaoapi.cn/product/getProducts?pscid=";
    private RecyclerView mParticularsRecy;
    private String pid = "1";
    private MData mData;
    private Message message;
    private List<ParticularsBean.DataBean> list = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 6) {
                String obj = (String) msg.obj;
                Log.e("666", "handleMessage: "+1111 );
                Gson gson = new Gson();
                ParticularsBean particularsBean = gson.fromJson(obj, ParticularsBean.class);
                List<ParticularsBean.DataBean> data = particularsBean.getData();
                list.addAll(data);
                particularsRecyClerAdapter.notifyDataSetChanged();

            }


        }
    };
    private ParticularsRecyClerAdapter particularsRecyClerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public ParticularsPresenter getBasePresenter() {
        return new ParticularsPresenter();
    }

    @Override
    public void initView() {

        mParticularsRecy = (RecyclerView) findViewById(R.id.particularsRecy);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
         pid = intent.getStringExtra("pid");
        Log.e("siwangzhizi", "initData: "+pid );
        particularsRecyClerAdapter = new ParticularsRecyClerAdapter(list, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mParticularsRecy.setLayoutManager(linearLayoutManager);

        mParticularsRecy.setAdapter(particularsRecyClerAdapter);
        particularsRecyClerAdapter.setOnItemClickLitener(new ParticularsRecyClerAdapter.OnItemClickLitener() {
            @Override
            public void OnItemClickLitener(ParticularsBean.DataBean dataBean) {
                mData.gdata(dataBean);
            }
        });
        basePresenter.requestData(url_Particulars+pid,6);
    }


    @Override

    public int getContentView() {
        return R.layout.activity_particulars;
    }

    @Override
    public void onSuccess(String string, int flag) {
        switch (flag) {

            case 6:
                message = handler.obtainMessage();
                message.what = 6;
                message.obj = string;
                handler.sendMessage(message);

                break;

        }
    }

    @Override
    public void onError() {

    }

    @Override
    public void onGetDataBean(DetailsBean.DataBean dataBean) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
    public interface MData{
        public void gdata(ParticularsBean.DataBean dataBean);

    }
    public void setmData(MData mData){
        this.mData=mData;

    }
}
