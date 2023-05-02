package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.graphics.Color;
import android.graphics.RectF;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class Player extends MovableGameObject{

    String playerName = "Player";
    int playerColor = Color.BLACK;
    float playerWidth = 16;
    float playerHeight = 16;
    RectF playerBounds;
    float playerVelocityX = 4;
    float playerVelocityY = 0;

    /**
     * Default constructor for MovableGameObject
     *
     * @param screenWidth   width of the device screen
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Player(int screenWidth) {
        super(screenWidth);
        this.setGameObjectName(playerName);
        this.setGameObjectWidth(playerWidth);
        this.setGameObjectHeight(playerHeight);
        this.setGameObjectBounds(playerBounds);
        this.setGameObjectVelocityX(playerVelocityX);
        this.setGameObjectVelocityY(playerVelocityY);
    }
}
