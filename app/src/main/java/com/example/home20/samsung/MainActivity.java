package com.example.home20.samsung;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text);
        if(score != 0) text.setText(score);
    }
    public void click(View view){
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
    }
    public void about(View view){
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        this.score = savedInstanceState.getInt("score");
    }
}
