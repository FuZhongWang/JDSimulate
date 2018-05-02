package com.example.p7xxtm1_g.jdsimulate.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.presenter.BasePresenter;
import com.example.p7xxtm1_g.jdsimulate.view.interfaces.IBaseView;
import com.example.p7xxtm1_g.jdsimulate.view.interfaces.IMainView;

/**
 * Created by P7XXTM1-G on 2018/4/24.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public T basePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        Log.e("siwang", "onCreate: "+getContentView());
         basePresenter = getBasePresenter();
        basePresenter.setView(this);

        initView();
         initData();

    }


    public abstract T getBasePresenter();
    public abstract void initView();
    public abstract void initData();
    public abstract int getContentView();

    
}
