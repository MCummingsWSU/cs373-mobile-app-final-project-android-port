package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import static android.graphics.Color.RED;
import static android.graphics.Color.valueOf;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

/**
 * A class representing an obstacle that can collide with the player that appears at the top of the game screen
 * Rewritten for Android
 *
 * @author Michael Cummings
 * @version 4.24.23
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class ObstacleFast extends Obstacle
{
    String obstacleName = "ObstacleFast";
    Color obstacleColor = valueOf(RED);
    int obstacleWidth = 16;
    int obstacleHeight = 16;
    int obstacleSpeed = 4;

    /**
     * Default constructor for objects of class ObstacleFast
     */
    public ObstacleFast()
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
     * Overloaded constructor for objects of class ObstacleFast
     */
    public ObstacleFast(int x, int y)
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

