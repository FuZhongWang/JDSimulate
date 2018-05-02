package com.example.p7xxtm1_g.jdsimulate.view.fragment.MenuFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.MenuBean;
import com.example.p7xxtm1_g.jdsimulate.view.adapter.MenRecyClerViewAdapter;

import java.util.ArrayList;

/**
 * Created by P7XXTM1-G on 2018/4/28.
 */

public class JDMenuOne extends Fragment {

    private ArrayList<MenuBean.DataBean> list = new ArrayList<>();
    private RecyclerView jd_menu_one_item;
    private GetJDMenuOne getJDMenuOne;
    private MenRecyClerViewAdapter menRecyClerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jd_menu_one, container, false);
        jd_menu_one_item = view.findViewById(R.id.jd_menu_one_item);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<MenuBean.DataBean> one = getJDMenuOne.getOne();
        list.addAll(one);
        Log.e("ccc", "onActivityCreated: "+list.get(0).getName() );
        menRecyClerViewAdapter = new MenRecyClerViewAdapter(getActivity());
        menRecyClerViewAdapter.setList(list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.HORIZONTAL, false);
        jd_menu_one_item.setLayoutManager(gridLayoutManager);
        jd_menu_one_item.setAdapter(menRecyClerViewAdapter);
        menRecyClerViewAdapter.notifyDataSetChanged();


    }
    public interface GetJDMenuOne{
        public ArrayList<MenuBean.DataBean> getOne();
}
    public void setGetJDMenuOne(GetJDMenuOne getJDMenuOne){
        this.getJDMenuOne=getJDMenuOne;
    }
}
