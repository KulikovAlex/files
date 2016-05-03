package com.example.myapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;


public class DrawThread extends Thread{
    private boolean runFlag = false;
    private SurfaceHolder surfaceHolder;
    private Bitmap picture;
    private Bitmap b;
    private Bitmap line;
    private long prevTime;
    int w=406;
    int h=600;
    Paint paint=new Paint();

    public DrawThread(SurfaceHolder surfaceHolder, Resources resources){
        this.surfaceHolder = surfaceHolder;

        // загружаем картинку, которую будем отрисовывать
        picture = BitmapFactory.decodeResource(resources, R.drawable.car1);
        b = BitmapFactory.decodeResource(resources, R.drawable.bground);
        line=BitmapFactory.decodeResource(resources, R.drawable.line1);

        // сохраняем текущее время
        prevTime = System.currentTimeMillis();
    }

    public void setRunning(boolean run) {
        runFlag = run;
    }

    @Override
    public void run() {
        Canvas canvas;
        while (runFlag) {
            // получаем текущее время и вычисляем разницу с предыдущим
            // сохраненным моментом времени
            long now = System.currentTimeMillis();
            long elapsedTime = now - prevTime;

            if(elapsedTime>105&&elapsedTime<230) {
                paint.setAlpha(255);}

                if (elapsedTime > 230) {
                    // если прошло больше 180 миллисекунд - сохраним текущее время
                    // и повернем картинку на 2 градуса.
                    // точка вращения - центр картинки
                    paint.setAlpha(0);

                    prevTime = now;
                }

            canvas = null;
            try {
                // получаем объект Canvas и выполняем отрисовку
                canvas = surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder) {
                    //canvas.drawColor(Color.WHITE);
                    canvas.drawBitmap(b, 0,0,null);
                    canvas.drawBitmap(line,306,0,paint);
                    canvas.drawBitmap(picture, w,h, null);
                }
            }
            finally {
                if (canvas != null) {
                    // отрисовка выполнена. выводим результат на экран
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }


    public void replace() {

        if(w==406){
            w=190;
        }else{
            w=406;
        }
    }
}
