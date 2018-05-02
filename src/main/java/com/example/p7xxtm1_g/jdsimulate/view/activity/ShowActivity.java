package com.example.p7xxtm1_g.jdsimulate.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.DetailsBean;
import com.example.p7xxtm1_g.jdsimulate.presenter.ShowPresenter;
import com.example.p7xxtm1_g.jdsimulate.view.fragment.switchFragment.FindFragment;
import com.example.p7xxtm1_g.jdsimulate.view.fragment.switchFragment.HomeFragment;
import com.example.p7xxtm1_g.jdsimulate.view.fragment.switchFragment.MainFragment;
import com.example.p7xxtm1_g.jdsimulate.view.fragment.switchFragment.ShoppingCartFragment;
import com.example.p7xxtm1_g.jdsimulate.view.fragment.switchFragment.SortFragment;

public class ShowActivity extends BaseActivity<ShowPresenter> implements View.OnClickListener {

    private FrameLayout mFragment;
    /**
     * 首页
     */
    private TextView mShouye;
    /**
     * 分类
     */
    private TextView mFenlei;
    /**
     * 发现
     */
    private TextView mFaxian;
    /**
     * 购物车
     */
    private TextView mGouwuche;
    /**
     * 我的
     */
    private TextView mWode;
    private MainFragment mainFragment;
    private FindFragment findFragment;
    private SortFragment sortFragment;
    private ShoppingCartFragment shoppingCartFragment;
    private HomeFragment homeFragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public ShowPresenter getBasePresenter() {
        return new ShowPresenter();
    }

    @Override
    public void initView() {


        mFragment = (FrameLayout) findViewById(R.id.fragment);
        mShouye = (TextView) findViewById(R.id.shouye);
        mFenlei = (TextView) findViewById(R.id.fenlei);
        mFaxian = (TextView) findViewById(R.id.faxian);
        mGouwuche = (TextView) findViewById(R.id.gouwuche);
        mWode = (TextView) findViewById(R.id.wode);
        mShouye.setOnClickListener(this);
        mFenlei.setOnClickListener(this);
        mFaxian.setOnClickListener(this);
        mGouwuche.setOnClickListener(this);
        mWode.setOnClickListener(this);
    }

    @Override
    public void initData() {
        mainFragment = new MainFragment();
        findFragment = new FindFragment();
        sortFragment = new SortFragment();
        shoppingCartFragment = new ShoppingCartFragment();
        homeFragment = new HomeFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction
                .add(R.id.fragment, mainFragment)
                .add(R.id.fragment, findFragment)
                .add(R.id.fragment, sortFragment)
                .add(R.id.fragment, shoppingCartFragment)
                .add(R.id.fragment, homeFragment)
                .show(mainFragment)
                .hide(findFragment)
                .hide(sortFragment)
                .hide(shoppingCartFragment)
                .hide(homeFragment)
                .commit();


    }

    @Override
    public int getContentView() {
        return R.layout.activity_show;
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shouye:
                getSupportFragmentManager().beginTransaction()
                                    .show(mainFragment)
                                    .hide(findFragment)
                                    .hide(sortFragment)
                                    .hide(shoppingCartFragment)
                                    .hide(homeFragment)
                                    .commit();
                ;break;
            case R.id.fenlei:
                getSupportFragmentManager().beginTransaction()
                        .show(sortFragment)
                        .hide(mainFragment)
                        .hide(findFragment)
                        .hide(shoppingCartFragment)
                        .hide(homeFragment)
                        .commit();
                ;break;
            case R.id.faxian:
                getSupportFragmentManager().beginTransaction()
                        .show(findFragment)
                        .hide(mainFragment)
                        .hide(sortFragment)
                        .hide(shoppingCartFragment)
                        .hide(homeFragment)
                        .commit();
                ;break;
            case R.id.gouwuche:
                getSupportFragmentManager().beginTransaction()
                        .show(shoppingCartFragment)
                        .hide(findFragment)
                        .hide(sortFragment)
                        .hide(mainFragment)
                        .hide(homeFragment)
                        .commit();
                ;break;
            case R.id.wode:
                getSupportFragmentManager().beginTransaction()
                        .show(homeFragment)
                        .hide(findFragment)
                        .hide(sortFragment)
                        .hide(shoppingCartFragment)
                        .hide(mainFragment)
                        .commit();
                ;break;


        }

    }


}
