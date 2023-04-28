package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private Game gameView;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point); //Gets the size of a pixel on the user's device screen

        gameView = new Game(this, point.x, point.y);

        setContentView(gameView);
    }

    @Override
    protected void onPause(){
        super.onPause();
        gameView.gamePause();
    }

    @Override
    protected  void onResume(){
        super.onResume();
        gameView.gameResume();
    }
}
