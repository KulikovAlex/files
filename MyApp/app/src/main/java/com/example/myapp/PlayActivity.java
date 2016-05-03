package com.example.myapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class PlayActivity extends AppCompatActivity implements View.OnTouchListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MySurfaceView view=new MySurfaceView(this);
        view.setOnTouchListener(this);
        setContentView(view);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        MySurfaceView s=new MySurfaceView(this);

        if(event.getAction()==MotionEvent.ACTION_DOWN){
        s.touch();
        }
        return false;
    }
}

