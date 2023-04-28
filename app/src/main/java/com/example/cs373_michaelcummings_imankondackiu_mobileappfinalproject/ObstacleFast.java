package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

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
    int obstacleSpeed = 4;

    /**
     * Default constructor for objects of class ObstacleFast
     */
    public ObstacleFast()
    {
        super();
        this.setGameObjectName(obstacleName);
        this.setMovableGameObjectSpeed(obstacleSpeed);
    }

    /**
     * Overloaded constructor for objects of class ObstacleFast
     */
    public ObstacleFast(int x, int y)
    {
        super();
        this.setGameObjectName(obstacleName);
        this.setMovableGameObjectSpeed(obstacleSpeed);
        this.setGameObjectLocation(x, y);
    }
}

