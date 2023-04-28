package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import static android.graphics.Color.RED;
import static android.graphics.Color.valueOf;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;

import androidx.annotation.RequiresApi;

/**
 * A class representing an obstacle that can collide with the player that appears at the top of the game screen
 * Rewritten for Android Studio
 *
 * @author Michael Cummings
 * @version 4.23.23
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class Obstacle extends MovableGameObject
{
    String obstacleName = "Obstacle";
    Color obstacleColor = valueOf(RED);
    Paint obstaclePaint = new Paint();
    Bitmap obstacleBitmap;
    Resources obstacleResources;
    int obstacleWidth = 16;
    int obstacleHeight = 16;
    int obstacleSpeed = 2;

    /**
     * Default constructor for objects of class Obstacle
     */
    public Obstacle()
    {
        this.setGameObjectName(obstacleName);
        this.setGameObjectColor(obstacleColor);
        this.obstaclePaint.setColor(obstacleColor.toArgb());
        this.obstacleBitmap = BitmapFactory.decodeResource(obstacleResources, R.color.red);
        this.setGameObjectLocation(0, 0);
        this.setGameObjectWidth(obstacleWidth);
        this.setGameObjectHeight(obstacleHeight);
        this.setMovableGameObjectSpeed(obstacleSpeed);
        this.setGameObjectNoCollide(false);

        this.obstacleBitmap = Bitmap.createScaledBitmap(obstacleBitmap, (int)getGameObjectWidth(), (int)getGameObjectHeight(), false);
    }

    /**
     * Overloaded constructor for objects of class Obstacle
     */
    public Obstacle(int x, int y)
    {
        this.setGameObjectName(obstacleName);
        this.setGameObjectColor(obstacleColor);
        this.obstaclePaint.setColor(obstacleColor.toArgb());
        this.obstacleBitmap = BitmapFactory.decodeResource(obstacleResources, R.color.red);
        this.setGameObjectLocation(x, y);
        this.setGameObjectWidth(obstacleWidth);
        this.setGameObjectHeight(obstacleHeight);
        this.setMovableGameObjectSpeed(obstacleSpeed);
        this.setGameObjectNoCollide(false);

        this.obstacleBitmap = Bitmap.createScaledBitmap(obstacleBitmap, (int)getGameObjectWidth(), (int)getGameObjectHeight(), false);
    }
}

