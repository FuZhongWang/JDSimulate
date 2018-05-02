package com.example.p7xxtm1_g.jdsimulate.model.http;

import android.util.Log;

import com.example.p7xxtm1_g.jdsimulate.model.callback.HttpUtilsCallback;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.Recommend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HttpUtils implements Callback {
    private static volatile HttpUtils httpUtils;
    public HttpUtilsCallback httpUtilsCallback;
    public  static String string = "" ;
    public static ArrayList<Recommend.DataBean> list = new ArrayList<>();
    private HttpUtils() {
    }
    public static HttpUtils getHttpUtils(){
                if (httpUtils == null) {
                    httpUtils=new HttpUtils();
                }
   /*     volatile*/

        return httpUtils;
    }
   /* public static HttpUtils getHttpUtils(){
        if (httpUtils==null){
            synchronized (HttpUtils.class){
                if (httpUtils == null) {
                    httpUtils=new HttpUtils();
                }
            }

        }

        return httpUtils;
    }*/

    public void doGet(String url, final HttpUtilsCallback httpUtilsCallback) {
        this.httpUtilsCallback=httpUtilsCallback;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().get().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("rigou", "onResponse: "+string );
                httpUtilsCallback.onSuccess(string);
            }
        });


    }
    public void doPost(String url, HashMap<String,String>hashMap, HttpUtilsCallback httpUtilsCallback){
        this.httpUtilsCallback=httpUtilsCallback;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        FormBody.Builder builder = new FormBody.Builder();
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = hashMap.get(key);
            builder.add(key,value);
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        okHttpClient.newCall(request).enqueue(this);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        try {
            throw new Exception("请求失败");
        } catch (Exception e1) {
            e1.printStackTrace();
            httpUtilsCallback.onError(e1.getMessage());
            Log.e("onError", "onFailure: "+e1.toString());
        }

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String string = response.body().string();
        httpUtilsCallback.onSuccess(string);


    }
}
