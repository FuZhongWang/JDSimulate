package com.example.p7xxtm1_g.jdsimulate.view.diyview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by P7XXTM1-G on 2018/4/29.
 */

public class MButton extends RelativeLayout implements View.OnClickListener {

    private Button add;
    private Button subtract;
    private TextView num;

    public MButton(Context context) {
        this(context,null);
    }

    public MButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public MButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context,attrs,defStyleAttr,defStyleRes);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        add = new Button(context);
        LayoutParams addl = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        add.setText("-");
        add.setOnClickListener(this);
        num = new TextView(context);
        LayoutParams numl = new LayoutParams(240, RelativeLayout.LayoutParams.WRAP_CONTENT);
        num.setText("1");
        subtract = new Button(context);
        LayoutParams subtractl = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        subtract.setText("+");
        subtract.setOnClickListener(this);
        addView(add,addl);
        addView(num,numl);
        addView(subtract,subtractl);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        int right= 0;
        int button= 0;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            button=measuredHeight;
            right+=measuredWidth;


        }
        setMeasuredDimension(right,button);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int left= 0;
        int top= 0;
        int right= 0;
        int button= 0;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            right+=measuredWidth;
            button=measuredHeight;
            childAt.layout(left,top,right,button);
            left+=right;

        }

    }
}
