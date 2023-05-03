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
    float playerWidth = 48; //Denominator to place under screenWidth in constructor
    float playerHeight = 48; //Denominator to place under screenHeight in constructor
    RectF playerBounds;
    float playerXCoord;
    float playerVelocityX = 400;
    float playerVelocityY = 0;
    private int mScreenWidth;
    final int STOPPED = 0;
    final int LEFT = 1;
    final int RIGHT = 2;
    private int playerMoving = STOPPED;

    /**
     * Default constructor for MovableGameObject
     *
     * @param resolutionX   horizontal resolution of the device screen
     * @param resolutionY   vertical resolution of the device screen
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Player(int resolutionX, int resolutionY) {
        super(resolutionX, resolutionY);
        mScreenWidth = resolutionX;

        this.setGameObjectName(playerName);
        this.setGameObjectWidth(mScreenWidth / playerWidth);
        this.setGameObjectHeight(resolutionY / playerHeight);
        this.playerXCoord = mScreenWidth / 2;
        float playerYCoord = resolutionY - 2 * this.getGameObjectHeight();

        playerBounds = new RectF(
                playerXCoord,
                playerYCoord,
                playerXCoord + playerWidth,
                playerYCoord + playerHeight);
        this.setGameObjectBounds(playerBounds);

        this.setGameObjectVelocityX(playerVelocityX);
        this.setGameObjectVelocityY(playerVelocityY);

        this.setGameObjectColor(playerColor);
        this.playerPaint = new Paint();
        this.playerPaint.setColor(playerColor);

    }
    void update(long fps){
        if(playerMoving == LEFT){
            playerXCoord = playerXCoord - playerVelocityX / fps;
        }
        if(playerMoving == RIGHT){
            playerXCoord = playerXCoord + playerVelocityX / fps;
        }
        if(playerXCoord < 0){
            playerXCoord = 0;
        }
        else if(playerXCoord + playerWidth > mScreenWidth){
            playerXCoord = mScreenWidth - playerWidth;
        }
        playerBounds.left = playerXCoord;
        playerBounds.right = playerXCoord + playerWidth;
    }

    void setPlayerMovementState(int state){

        playerMoving = state;

    }
}
