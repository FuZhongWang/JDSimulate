package com.example.p7xxtm1_g.jdsimulate.view.fragment.switchFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p7xxtm1_g.jdsimulate.presenter.BasePresenter;
import com.example.p7xxtm1_g.jdsimulate.view.interfaces.IBaseView;

/**
 * Created by P7XXTM1-G on 2018/4/28.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements IBaseView{

    public View inflate;
    public T basePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(getLayout(), container, false);
        initView(inflate);

        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        basePresenter = getBasePresenter();
        basePresenter.setView(this);
        initData();
    }
    public abstract T getBasePresenter();
    public abstract void initView(View v);
    public abstract void initData();
    public abstract int  getLayout();
}
