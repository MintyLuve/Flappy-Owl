package com.example.flappyowl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    //init variables
    ImageView owl;
    View click;

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //declaring variables
        owl = findViewById(R.id.owl);
        click = findViewById(R.id.click);

        // gets the width and height of the screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        String h = String.valueOf(height);

        Toast.makeText(this, h, Toast.LENGTH_SHORT).show();
        //moves the owl down until it hits the ground
        //RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) owl.getLayoutParams();
        //int sunk  = ((RelativeLayout.LayoutParams) owl.getLayoutParams()).topMargin;
        int sunk = 200;
        /*for (int j = 1; j <= 6; j++) {
            //changes margin
            //params.setMargins(params.leftMargin, sunk, params.rightMargin, params.bottomMargin);
            //owl.setLayoutParams(params);
            //sunk gets bigger
            //sunk += 15;
            //Toast.makeText(this, String.valueOf(sunk), Toast.LENGTH_SHORT).show();

            final Handler handler = new Handler();
            final int delay = 10000; // 1000 milliseconds == 1 second

            handler.postDelayed(new Runnable() {
                public void run() {
                    Toast.makeText(GameActivity.this, "hi", Toast.LENGTH_SHORT).show(); // Do your work here
                    handler.postDelayed(this, delay);
                }
            }, delay);
        }*/
    }

    @Override
        protected void onResume() {
            handler.postDelayed(runnable = new Runnable() {
                public void run() {
                    handler.postDelayed(runnable, delay);
                    Toast.makeText(GameActivity.this, "This method is run every 10 seconds",
                            Toast.LENGTH_SHORT).show();
                }
            }, delay);
            super.onResume();
        }
        @Override
        protected void onPause() {
            handler.removeCallbacks(runnable); //stop handler when activity not visible super.onPause();
        }


    void sink(){
        for (int i=1; i <= 5; i++) {
            Toast.makeText(this, String.valueOf(i), Toast.LENGTH_SHORT).show();
        }
    }
}