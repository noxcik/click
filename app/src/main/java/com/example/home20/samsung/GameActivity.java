package com.example.home20.samsung;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by HOME20 on 30.12.2017.
 */

public class GameActivity extends Activity {
    int y;
    int score;
    long startTime;
    long time;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_game);

        y = 0;
        score = 0;
        time = startTime +  60 * 1000;
        startTime = System.currentTimeMillis();
    }
    public void click(View view){
        TextView text = findViewById(R.id.k);
        if(!(System.currentTimeMillis() - startTime > time)) {
            y++;
            text.setText("" + y);
        }
        else{
            score = y;
            text.setText("Ваш результат:" + y);
        }
    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("score", score);
    }

}
