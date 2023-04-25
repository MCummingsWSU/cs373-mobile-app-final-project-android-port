package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

/**
 * A class representing an obstacle that can collide with the player that appears at the top of the game screen
 * Rewritten for Android Studio
 *
 * @author Michael Cummings
 * @version 4.24.23
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class ObstacleLarge extends Obstacle
{
    String obstacleName = "ObstacleLarge";
    Color obstacleColor = Color.valueOf(Color.RED);
    int obstacleWidth = 32;
    int obstacleHeight = 32;
    int obstacleSpeed = 1;

    /**
     * Default constructor for objects of class ObstacleLarge
     */
    public ObstacleLarge()
    {
        this.setGameObjectName(obstacleName);
        this.setGameObjectColor(obstacleColor);
        this.setGameObjectLocation(0, 0);
        this.setGameObjectWidth(obstacleWidth);
        this.setGameObjectHeight(obstacleHeight);
        this.setMovableGameObjectSpeed(obstacleSpeed);
        this.setGameObjectNoCollide(false);
    }

    /**
     * Overloaded constructor for objects of class ObstacleLarge
     */
    public ObstacleLarge(int x, int y)
    {
        this.setGameObjectName(obstacleName);
        this.setGameObjectColor(obstacleColor);
        this.setGameObjectLocation(x, y);
        this.setGameObjectWidth(obstacleWidth);
        this.setGameObjectHeight(obstacleHeight);
        this.setMovableGameObjectSpeed(obstacleSpeed);
        this.setGameObjectNoCollide(false);
    }
}

