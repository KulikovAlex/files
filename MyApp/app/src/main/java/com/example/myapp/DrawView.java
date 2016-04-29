package com.example.myapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

class DrawView extends View {

    Paint mPaint = new Paint();
    float w, h, cx, cy, radius;

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        w = getWidth();
        h = getHeight();
        cx = w / 2;
        cy = h / 2;

        if (w > h) {
            radius = h / 4;
        } else {
            radius = w / 4;
        }
        canvas.drawColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx, cy, radius, mPaint);
    }

}