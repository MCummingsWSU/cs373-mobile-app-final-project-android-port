package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import static android.graphics.Color.*;

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
        this.setGameObjectLocation(0, 0);
        this.setGameObjectWidth(obstacleWidth);
        this.setGameObjectHeight(obstacleHeight);
        this.setMovableGameObjectSpeed(obstacleSpeed);
        this.setGameObjectNoCollide(false);
    }

    /**
     * Overloaded constructor for objects of class Obstacle
     */
    public Obstacle(int x, int y)
    {
        this.setGameObjectName(obstacleName);
        this.setGameObjectColor(obstacleColor);
        this.obstaclePaint.setColor(obstacleColor.toArgb());
        this.setGameObjectLocation(x, y);
        this.setGameObjectWidth(obstacleWidth);
        this.setGameObjectHeight(obstacleHeight);
        this.setMovableGameObjectSpeed(obstacleSpeed);
        this.setGameObjectNoCollide(false);
    }
}

