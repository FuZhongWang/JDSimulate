package com.example.p7xxtm1_g.jdsimulate.presenter;

import com.example.p7xxtm1_g.jdsimulate.view.interfaces.IBaseView;

/**
 * Created by P7XXTM1-G on 2018/4/24.
 */

public class BasePresenter<T extends IBaseView> {
    public T ibaseView;

    public void setView(T ibaseView){
        this.ibaseView=ibaseView;

    }
    public T getView(){

        return ibaseView;
    };


}
