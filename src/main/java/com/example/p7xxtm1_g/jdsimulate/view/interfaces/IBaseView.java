package com.example.p7xxtm1_g.jdsimulate.view.interfaces;

import com.example.p7xxtm1_g.jdsimulate.model.pojo.DetailsBean;

/**
 * Created by P7XXTM1-G on 2018/4/24.
 */

public interface IBaseView {
    public void onSuccess(String string,int flag);
    public void onError();
    public void onGetDataBean(DetailsBean.DataBean dataBean);

}
