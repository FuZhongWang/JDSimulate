package com.example.p7xxtm1_g.jdsimulate.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.p7xxtm1_g.jdsimulate.R;
import com.example.p7xxtm1_g.jdsimulate.model.pojo.DataJson;


import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by P7XXTM1-G on 2018/4/29.
 */

public class ShoppingBaseExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<DataJson.ContentBean> list = new ArrayList<>();
    private CheckBox quanbu;

    public ShoppingBaseExpandableListAdapter(Context context, List<DataJson.ContentBean> list) {
        this.context = context;
        this.list = list;
    }
    public void setQuanBu(CheckBox checkBox){
        this.quanbu=checkBox;
    }

    @Override
    public int getGroupCount() {
        Log.e("erji", "getGroupCount: "+ list.size()+list.get(0).getGoodDetail().get(0).getName());

        return list.size();

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        Log.e("erji", "getChildrenCount: "+list.get(groupPosition).getGoodDetail().size() );
        return list.get(groupPosition).getGoodDetail().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getGoodDetail().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {


        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final GroupViewHolder groupViewHolder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.group_item,null);
            groupViewHolder=new GroupViewHolder();
            groupViewHolder.mGroup_ck=convertView.findViewById(R.id.group_cb);
            groupViewHolder.mGroup_text=convertView.findViewById(R.id.group_text);
            convertView.setTag(groupViewHolder);

        }else{
            groupViewHolder= (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.mGroup_text.setText(list.get(groupPosition).getAddress());
        groupViewHolder.mGroup_ck.setChecked(list.get(groupPosition).isIsSelected());

        groupViewHolder.mGroup_ck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = groupViewHolder.mGroup_ck.isChecked();
                list.get(groupPosition).setIsSelected(isChecked);
                for (int i = 0; i < list.get(groupPosition).getGoodDetail().size(); i++) {
                    Log.e(TAG, "onCheckedChanged: "+isChecked);
                    list.get(groupPosition).getGoodDetail().get(i).setIsSelected(isChecked);
                }

                panduan();
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ChildViewHolder childViewHolder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.cexpanbablelistview,null);
            childViewHolder=new ChildViewHolder();
            childViewHolder.mChild_ck = convertView.findViewById(R.id.cchecbox);
            childViewHolder.mChild_img = convertView.findViewById(R.id.c_img);
            childViewHolder.mChild_title = convertView.findViewById(R.id.c_title);
            childViewHolder.mChild_price = convertView.findViewById(R.id.c_price);
            childViewHolder.mChild_subtract = convertView.findViewById(R.id.c_subtract);
            childViewHolder.mChild_num = convertView.findViewById(R.id.c_num);
            childViewHolder.mChild_add = convertView.findViewById(R.id.c_add);
            convertView.setTag(childViewHolder);
        }else{
            childViewHolder= (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.mChild_title.setText(list.get(groupPosition).getGoodDetail().get(childPosition).getName());
        childViewHolder.mChild_price.setText(list.get(groupPosition).getGoodDetail().get(childPosition).getPrice());
        childViewHolder.mChild_ck.setChecked(list.get(groupPosition).getGoodDetail().get(childPosition).isIsSelected());
        childViewHolder.mChild_ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.get(groupPosition).getGoodDetail().get(childPosition).setIsSelected(isChecked);
                    panduan();
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public class  GroupViewHolder{
    private TextView mGroup_text;
    private CheckBox mGroup_ck;

    }
    public class  ChildViewHolder{
    private CheckBox mChild_ck;
    private ImageView mChild_img;
    private TextView mChild_title;
    private TextView mChild_price;
    private Button mChild_subtract;
    private TextView mChild_num;
    private Button mChild_add;


    }
    public void allCheck(boolean isCheck){

        for(int i=0;i<getGroupCount();i++)
        {
            list.get(i).setIsSelected(isCheck);
            for (int j = 0; j < getChildrenCount(i);j++) {
                list.get(i).getGoodDetail().get(j).setIsSelected(isCheck);

        }
        }

        //刷新适配器
        notifyDataSetChanged();
    }
    public void panduan(){
        boolean gFlag = true;
        for (int i = 0; i < list.size(); i++) {
                boolean flag = true;

            for (int j = 0; j < list.get(i).getGoodDetail().size(); j++) {
                boolean isSelected = list.get(i).getGoodDetail().get(j).isIsSelected();


                if (isSelected==false){
                    flag=false;
                    list.get(i).setIsSelected(isSelected);
                }
                if (flag){


                    if (isSelected==true){
                        list.get(i).setIsSelected(isSelected);
                    }
                }
            }
            boolean isSelected = list.get(i).isIsSelected();

            if (isSelected==false){
                gFlag=false;
            quanbu.setChecked(isSelected);
            }
            if (gFlag){
                if (isSelected==true){

                    quanbu.setChecked(isSelected);
                }

            }

        }
        notifyDataSetChanged();
    }
}
