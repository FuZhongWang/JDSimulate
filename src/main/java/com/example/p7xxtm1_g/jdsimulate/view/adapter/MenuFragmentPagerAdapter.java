package com.example.p7xxtm1_g.jdsimulate.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by P7XXTM1-G on 2018/4/28.
 */

public class MenuFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<>();

    public MenuFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public void setList(List<Fragment> list){

        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
