package com.example.pl.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.Toolbar;

@SuppressLint("AppCompatCustomView")
public class MyTextView extends TextView{
    public MyTextView(Context context) {
        super(context);
    }
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @SuppressLint("NewApi")
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    int myViewWidth, mTranslate = 0;;
    LinearGradient linearGradient;
    Matrix matrix;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(myViewWidth == 0){
            myViewWidth = getMeasuredWidth();
            if(myViewWidth > 0){
                Paint paint = getPaint();
                linearGradient = new LinearGradient(0,0,myViewWidth,0,
                        new int[]{Color.BLUE, 0xffffffff, Color.BLUE},
                        null,
                        Shader.TileMode.CLAMP);
                //平铺模式Shader.TileMode.CLAMP：如果着色器超出原始边界范围，会复制边缘颜色
                paint.setShader(linearGradient);
                matrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        if(matrix != null){
            mTranslate += myViewWidth/5;
            if(mTranslate > 2*myViewWidth){
                mTranslate = -myViewWidth;
            }
            matrix.setTranslate(mTranslate,0);
            linearGradient.setLocalMatrix(matrix);
            postInvalidateDelayed(100);//刷新界面
        }
    }
}
