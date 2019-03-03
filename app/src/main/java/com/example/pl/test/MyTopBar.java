package com.example.pl.test;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyTopBar extends RelativeLayout{
    TypedArray array;
    String myTitle, myleftText, myRigthText;
    int color;
    float TitleDimension;
    Button lbutton, rbutton;
    TextView textView;

    topbarClickListener myListener;

    public void com(Context context){
        lbutton = new Button(context);
        rbutton = new Button(context);
        textView = new TextView(context);

        LayoutParams lParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        lParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(lbutton,lParams);

        LayoutParams rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rbutton, rParams);

        LayoutParams tParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        tParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(textView, tParams);



        lbutton.setText(myleftText);
        rbutton.setText(myRigthText);
        textView.setText(myTitle);
        textView.setTextColor(color);
        textView.setTextSize(TitleDimension);

        lbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myListener.leftClick();
            }
        });

        rbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myListener.rigthClick();
            }
        });
    }

    public void setOnTopbarClickListener(topbarClickListener topbarClickListener){
        this.myListener = topbarClickListener;
    }

    public MyTopBar(Context context) {
        super(context);
    }
    public MyTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        array = context.obtainStyledAttributes(attrs, R.styleable.MyTopBar);
        myTitle = array.getString(R.styleable.MyTopBar_title);
        myleftText = array.getString(R.styleable.MyTopBar_leftText);
        myRigthText = array.getString(R.styleable.MyTopBar_RightText);
        color = array.getColor(R.styleable.MyTopBar_titleColor, 0);
        TitleDimension = array.getDimension(R.styleable.MyTopBar_titleSize, 10);
        array.recycle();
        com(context);
    }
    public MyTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @SuppressLint("NewApi")
    public MyTopBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

}

