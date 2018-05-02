package com.example.p7xxtm1_g.jdsimulate.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.DetailsBean;
import com.example.p7xxtm1_g.jdsimulate.presenter.DetailsPresenter;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

public class DetailsActivity extends BaseActivity<DetailsPresenter> implements View.OnClickListener {

    private MData mData;
    private Message message;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 7) {
                String obj = (String) msg.obj;
                Gson gson = new Gson();
                DetailsBean detailsBean = gson.fromJson(obj, DetailsBean.class);
                DetailsBean.DataBean data = detailsBean.getData();
                String[] split = data.getImages().split("\\|");
                instance.displayImage(split[0],mDetailsImg);
                mDetailsText.setText(data.getTitle());

            }


        }
    };
    private ImageView mDetailsImg;
    /**
     * 程序员压力大？扯淡！看我25岁了，依旧荣光换发!
     */
    private TextView mDetailsText;
    /**
     * 加入购物车
     */
    private Button mAddShopping;
    private ImageLoader instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public DetailsPresenter getBasePresenter() {
        return new DetailsPresenter();
    }

    @Override
    public void initView() {
        instance = ImageLoader.getInstance();
        mDetailsImg = (ImageView) findViewById(R.id.details_img);
        mDetailsText = (TextView) findViewById(R.id.details_text);
        mAddShopping = (Button) findViewById(R.id.add_Shopping);
        mAddShopping.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_details;
    }

    @Override
    public void onSuccess(String string, int flag) {
        switch (flag) {

            case 7:
                message = handler.obtainMessage();
                message.what = 7;
                message.obj = string;
                handler.sendMessage(message);

                break;

        }
    }

    @Override
    public void onError() {

    }

    @Override
    public void onGetDataBean(DetailsBean.DataBean dataBean) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.add_Shopping:

                break;
        }
    }
    public interface MData{
        public void gdata(DetailsBean.DataBean dataBean);

    }
    public void setmData(MData mData){
        this.mData=mData;

    }
}
