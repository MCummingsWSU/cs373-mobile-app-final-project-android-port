package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

/**
 * A class representing the character the player controls in the game
 * Rewritten for Android Studio
 *
 * @author Michael Cummings
 * @version 4.24.23
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class Player extends MovableGameObject
{
    String playerName = "Player";
    Color playerColor = Color.valueOf(Color.BLACK);
    int playerWidth = 16;
    int playerHeight = 16;
    int playerSpeed = 4;

    /**
     * Default constructor for objects of class Player
     */
    public Player()
    {
        this.setGameObjectName(playerName);
        this.setGameObjectColor(playerColor);
        this.setGameObjectWidth(playerWidth);
        this.setGameObjectHeight(playerHeight);
        this.setGameObjectLocation(0, 0);
        this.setMovableGameObjectSpeed(playerSpeed);
        this.setGameObjectNoCollide(false);
    }

    /**
     * Overloaded constructor for objects of class Player
     */
    public Player(int x, int y)
    {
        this.setGameObjectName(playerName);
        this.setGameObjectColor(playerColor);
        this.setGameObjectWidth(playerWidth);
        this.setGameObjectHeight(playerHeight);
        this.setGameObjectLocation(x, y);
        this.setMovableGameObjectSpeed(playerSpeed);
        this.setGameObjectNoCollide(false);
    }
}

