package com.example.p7xxtm1_g.jdsimulate.presenter;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.p7xxtm1_g.jdsimulate.model.callback.HttpUtilsCallback;
import com.example.p7xxtm1_g.jdsimulate.model.http.HttpUtils;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.Recommend;
import com.example.p7xxtm1_g.jdsimulate.view.interfaces.IShowView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P7XXTM1-G on 2018/4/25.
 */

public class ShowPresenter extends BasePresenter {
    private ArrayList<Recommend.DataBean> list = new ArrayList<>();
    private final HttpUtils httpUtils;




    public ShowPresenter() {
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
