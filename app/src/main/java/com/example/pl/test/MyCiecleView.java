package com.example.pl.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyCiecleView extends View {


    public MyCiecleView(Context context) {
        super(context);
    }

    public MyCiecleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCiecleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public MyCiecleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int length = getMeasuredWidth();
        canvas.drawCircle(length/2, length/2,
                (float) (length*0.5/2), new Paint());
        RectF rectF = new RectF((float)(length*0.1),
                                (float)(length*0.1),
                                (float)(length*0.9),
                                (float)(length*0.9));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, 270, 90, false, paint);
        paint.setColor(Color.RED);
        String t = "guoxiaohu";
        canvas.drawText(t, 0, t.length(), length/2, length/2, paint);

    }
}
