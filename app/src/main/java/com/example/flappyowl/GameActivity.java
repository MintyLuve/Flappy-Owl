package com.example.flappyowl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    //init variables
    ImageView owl;
    View click;

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

        Toast.makeText(this, height, Toast.LENGTH_SHORT).show();
        //moves the owl down until it hits the ground
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) owl.getLayoutParams();
        int sunk  = ((RelativeLayout.LayoutParams) owl.getLayoutParams()).bottomMargin;
        while (sunk < height-10){
            //changes margin
            params.setMargins(params.leftMargin, sunk, params.rightMargin, params.bottomMargin);
            owl.setLayoutParams(params);
            //sunk gets bigger
            sunk += 15;
            Toast.makeText(this, sunk, Toast.LENGTH_SHORT).show();
            try {
                wait(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}