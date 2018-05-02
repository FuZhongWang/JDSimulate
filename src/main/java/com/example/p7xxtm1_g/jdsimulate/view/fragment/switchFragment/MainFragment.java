package com.example.p7xxtm1_g.jdsimulate.view.fragment.switchFragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.DetailsBean;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.MenuBean;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.Recommend;
import com.example.p7xxtm1_g.jdsimulate.presenter.ShowPresenter;
import com.example.p7xxtm1_g.jdsimulate.view.adapter.GuessRecyClearViewAdapter;
import com.example.p7xxtm1_g.jdsimulate.view.adapter.MenuFragmentPagerAdapter;
import com.example.p7xxtm1_g.jdsimulate.view.adapter.RecommendAdapter;
import com.example.p7xxtm1_g.jdsimulate.view.adapter.SeckillRecyClerViewApdater;
import com.example.p7xxtm1_g.jdsimulate.view.fragment.MenuFragment.JDMenuOne;
import com.example.p7xxtm1_g.jdsimulate.view.fragment.MenuFragment.JDMenuTwo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P7XXTM1-G on 2018/4/28.
 */

public class MainFragment extends BaseFragment<ShowPresenter> implements View.OnClickListener {
    public String url = "https://www.zhaoapi.cn/ad/getAd";
    public String url_menu = "https://www.zhaoapi.cn/product/getCatagory";
    private ViewPager mRecommend;
    private TextView mScan;
    private EditText mSeek;
    private TextView mMessage;
    private ArrayList<Recommend.DataBean> list = new ArrayList<>();
    private Handler handler = new Handler() {
        private SeckillRecyClerViewApdater seckillRecyClerViewApdater;
        private ArrayList<MenuBean.DataBean> menutwo;
        private ArrayList<MenuBean.DataBean> menuone;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                String obj = (String) msg.obj;
                Gson gson = new Gson();
                recommendAdapter = new RecommendAdapter(getActivity(), list);
                mRecommend.setAdapter(recommendAdapter);
                Recommend recommend = gson.fromJson(obj, Recommend.class);
                List<Recommend.DataBean> data = recommend.getData();
                list.addAll(data);
                List<Recommend.TuijianBean.ListBean> Xlist = recommend.getTuijian().getList();
                GuessRecyClearViewAdapter guessRecyClearViewAdapter = new GuessRecyClearViewAdapter(getActivity(), Xlist);
                List<Recommend.MiaoshaBean.ListBeanX> Slist = recommend.getMiaosha().getList();
                GridLayoutManager gGridLayoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
                mGuess.setLayoutManager(gGridLayoutManager);
                mGuess.setAdapter(guessRecyClearViewAdapter);
                guessRecyClearViewAdapter.notifyDataSetChanged();
                seckillRecyClerViewApdater = new SeckillRecyClerViewApdater(getActivity(), Slist);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                mSeckill.setLayoutManager(linearLayoutManager);
                mSeckill.setAdapter(seckillRecyClerViewApdater);
                seckillRecyClerViewApdater.notifyDataSetChanged();
                recommendAdapter.notifyDataSetChanged();

            }
            if (msg.what == 2) {
                String obj = (String) msg.obj;
                Gson gson = new Gson();
                MenuBean menu = gson.fromJson(obj, MenuBean.class);
                List<MenuBean.DataBean> data = menu.getData();
                menuone = new ArrayList<>();
                menutwo = new ArrayList<>();

                for (int i = 0; i < data.size(); i++) {
                    if (i < 10) {
                        menuone.add(data.get(i));
                    } else {
                        menutwo.add(data.get(i));
                    }
                }

                jdMenuOne = new JDMenuOne();
                jdMenuOne.setGetJDMenuOne(new JDMenuOne.GetJDMenuOne() {
                    @Override
                    public ArrayList<MenuBean.DataBean> getOne() {

                        return menuone;
                    }
                });
                jdMenuTwo = new JDMenuTwo();
                jdMenuTwo.setGetJDMenuOne(new JDMenuTwo.GetJDMenuOne() {
                    @Override
                    public ArrayList<MenuBean.DataBean> getOne() {
                        return menutwo;
                    }
                });
                ArrayList<Fragment> fragments = new ArrayList<>();
                fragments.add(jdMenuOne);
                fragments.add(jdMenuTwo);
                menuFragmentPagerAdapter = new MenuFragmentPagerAdapter(getChildFragmentManager());
                menuFragmentPagerAdapter.setList(fragments);
                mMenu.setAdapter(menuFragmentPagerAdapter);


            }
            if (msg.what == 3) {
                countDown();

            }


        }
    };
    private RecommendAdapter recommendAdapter;
    private ViewPager mMenu;
    private JDMenuOne jdMenuOne;
    private JDMenuTwo jdMenuTwo;
    private MenuFragmentPagerAdapter menuFragmentPagerAdapter;
    private RecyclerView mSeckill;
    private Message message;
    /**
     * 02
     */
    private TextView mHour;
    /**
     * 59
     */
    private TextView mMinute;
    /**
     * 59
     */
    private TextView mSecond;
    private RecyclerView mGuess;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public ShowPresenter getBasePresenter() {
        return new ShowPresenter();
    }

    @Override
    public void initView(View view) {
        mRecommend = view.findViewById(R.id.recommend);
        mRecommend.setOnClickListener(this);
        mScan = view.findViewById(R.id.scan);
        mScan.setOnClickListener(this);
        mSeek = view.findViewById(R.id.seek);
        mSeek.setOnClickListener(this);
        mMessage = view.findViewById(R.id.message);
        mMessage.setOnClickListener(this);
        mMenu = view.findViewById(R.id.menu);

        mSeckill = view.findViewById(R.id.seckill);
        mMenu.setOnClickListener(this);
        mHour = view.findViewById(R.id.hour);
        mMinute =view.findViewById(R.id.minute);
        mSecond =view.findViewById(R.id.second);
        mSeckill.setOnClickListener(this);
        mGuess = view.findViewById(R.id.guess);
    }

    @Override
    public void initData() {
        basePresenter.requestData(url,1);
        basePresenter.requestData(url_menu,2);
        countDown();
    }




    @Override
    public int getLayout() {
        return R.layout.mainfragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.recommend:
                break;
            case R.id.scan:
                break;
            case R.id.seek:
                break;
            case R.id.message:
                break;
            case R.id.menu:
                break;
            case R.id.seckill:
                break;
        }
    }

    @Override
    public void onSuccess(String string, int flag) {
        switch (flag) {

            case 1:
                message = handler.obtainMessage();
                message.what = 1;
                message.obj = string;
                handler.sendMessage(message);
                ;
                break;
            case 2:
                message = handler.obtainMessage();
                message.what = 2;
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

    public void countDown() {
        String se = mSecond.getText().toString();
        String mm = mMinute.getText().toString();
        String mh = mHour.getText().toString();
        Integer second = Integer.valueOf(se);
        Integer minute = Integer.valueOf(mm);
        Integer hour = Integer.valueOf(mh);


        if (--second < 0) {
            if (hour == 0 && minute == 0) {
                return;
            }
            second = 60;
            mSecond.setText("" + second);
            mMinute.setText("" + --minute);
        }
        if (--minute < 0 && hour > 0) {
            minute = 59;
            mMinute.setText("" + minute);
            mHour.setText("" + --hour);

        }

        mSecond.setText("" + second);
        handler.sendEmptyMessageDelayed(3, 1000);

    }
}
