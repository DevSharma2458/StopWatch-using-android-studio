package com.example.digitalstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    int seconds = 0;
    boolean isRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.timerText);

        startTimer();
    }

    public void onClickStart(View view) {
        isRunning = true;
    }
    public void onClickStop(View view) {
        isRunning = false;
    }
    public void onClickReset(View view) {
        isRunning = false;
        seconds = 0;
    }

    public void startTimer(){
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int s = seconds%60;
                int m = seconds/60;
                int h = m/60;

                if (isRunning){
                    seconds++;
                }
                seconds++;
                String formatstring = String.format(Locale.getDefault(),"%02d:02d:02d",h,m,s);

                textView.setText(formatstring);
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);
    }
}