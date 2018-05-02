package com.example.p7xxtm1_g.jdsimulate.presenter;

import com.example.p7xxtm1_g.jdsimulate.model.callback.HttpUtilsCallback;
import com.example.p7xxtm1_g.jdsimulate.model.http.HttpUtils;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.Recommend;

import java.util.ArrayList;

/**
 * Created by P7XXTM1-G on 2018/4/29.
 */

public class ParticularsPresenter extends BasePresenter {
    private ArrayList<Recommend.DataBean> list = new ArrayList<>();
    private final HttpUtils httpUtils;




    public ParticularsPresenter() {
        httpUtils = HttpUtils.getHttpUtils();
    }
    public void requestData(String url, final int flag) {
        httpUtils.doGet(url, new HttpUtilsCallback() {
            @Override
            public void onSuccess(String string) {

                getView().onSuccess(string,flag);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

}
