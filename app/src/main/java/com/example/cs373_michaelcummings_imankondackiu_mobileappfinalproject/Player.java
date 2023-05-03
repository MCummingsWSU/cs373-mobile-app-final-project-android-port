package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class Player extends MovableGameObject{

    String playerName = "Player";
    int playerColor = Color.BLACK;
    Paint playerPaint;
    float playerWidth = 16; //Denominator to place under screenWidth in constructor
    float playerHeight = 16; //Denominator to place under screenHeight in constructor
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
        this.setGameObjectWidth(screenWidth / playerWidth);
        this.setGameObjectHeight(screenWidth / playerHeight);
        this.setGameObjectBounds(playerBounds);
        this.setGameObjectVelocityX(playerVelocityX);
        this.setGameObjectVelocityY(playerVelocityY);

        this.setGameObjectColor(playerColor);
        this.playerPaint = new Paint();
        this.playerPaint.setColor(this.getGameObjectColor());

    }
    void reset(int screenWidth, int screenHeight){
        this.setGameObjectBounds(new RectF(
                screenWidth / 2,
                screenHeight - this.getGameObjectHeight() * 2,
                screenWidth / 2 + this.getGameObjectWidth(),
                (screenHeight - this.getGameObjectHeight() * 2) + this.getGameObjectHeight()
            )
        );
    }
}
