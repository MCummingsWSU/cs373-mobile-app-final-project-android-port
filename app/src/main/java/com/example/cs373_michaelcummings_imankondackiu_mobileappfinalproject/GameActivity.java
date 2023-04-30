package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;

public class GameActivity extends Activity {

    private Game mObstacleGame;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Display gameDisplay = getWindowManager().getDefaultDisplay();
        Point gameSize = new Point();
        gameDisplay.getSize(gameSize);
        mObstacleGame = new Game(this, gameSize.x, gameSize.y);

        setContentView(mObstacleGame);
    }

    @Override
    protected void onResume(){
        super.onResume();
        mObstacleGame.resume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mObstacleGame.pause();
    }
}

