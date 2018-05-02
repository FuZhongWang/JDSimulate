package com.example.p7xxtm1_g.jdsimulate.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.DetailsBean;
import com.example.p7xxtm1_g.jdsimulate.presenter.MainPresenter;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity<MainPresenter>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask,3000);
    }

    @Override
    public MainPresenter getBasePresenter() {
        return new MainPresenter();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String string,int flag) {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onGetDataBean(DetailsBean.DataBean dataBean) {

    }


}
