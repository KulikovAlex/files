package com.example.myapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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

        //RectF dst=new RectF(getHeight(),getWidth(),getHeight(),getWidth());
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.bground1);
        canvas.drawBitmap(b, 0,0,null);
        Bitmap car = BitmapFactory.decodeResource(getResources(), R.drawable.car1);
        canvas.drawBitmap(car,406,600,null);
        //canvas.drawBitmap(car,190,600,null);

    }

}