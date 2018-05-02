package com.example.p7xxtm1_g.jdsimulate.view.fragment.switchFragment;

import android.view.View;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.DetailsBean;
import com.example.p7xxtm1_g.jdsimulate.presenter.ShowPresenter;

/**
 * Created by P7XXTM1-G on 2018/4/28.
 */

public class HomeFragment extends BaseFragment<ShowPresenter> {


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

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.homefragment;
    }
}
