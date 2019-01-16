package com.example.harshal.jitu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);

        CircularFillableLoaders circularFillableLoaders = (CircularFillableLoaders)findViewById(R.id.circularFillableLoaders);
// Set Progress
        circularFillableLoaders.setProgress(70);
// Set Wave and Border Color
//        circularFillableLoaders.setColor(R.color.colorAccent);
// Set Border Width
        circularFillableLoaders.setBorderWidth(4 * getResources().getDisplayMetrics().density);
// Set Wave Amplitude (between 0.00f and 0.10f)
        circularFillableLoaders.setAmplitudeRatio((float) 0.08);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
