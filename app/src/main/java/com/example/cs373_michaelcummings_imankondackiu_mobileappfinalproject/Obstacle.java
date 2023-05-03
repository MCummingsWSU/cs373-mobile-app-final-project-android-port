package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class Obstacle extends MovableGameObject{

    String obstacleName = "Obstacle";
    int obstacleColor = Color.RED;
    Paint obstaclePaint;
    float obstacleWidth = 48; //Denominator to place under screenWidth in constructor
    float obstacleHeight = 48; //Denominator to place under screenHeight in constructor
    RectF obstacleBounds;
    float obstacleVelocityX = 0;
    float obstacleVelocityY = 400;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Obstacle(int screenWidth) {
        super(screenWidth);

        this.setGameObjectName(obstacleName);
        this.setGameObjectWidth(screenWidth / obstacleWidth);
        this.setGameObjectHeight(screenWidth / obstacleHeight);

        obstacleBounds = new RectF();
        this.setGameObjectBounds(obstacleBounds);

        this.setGameObjectVelocityX(obstacleVelocityX);
        this.setGameObjectVelocityY(obstacleVelocityY);

        this.setGameObjectColor(obstacleColor);
        this.obstaclePaint = new Paint();
        this.obstaclePaint.setColor(obstacleColor);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void update(long fps){
        obstacleBounds.left = obstacleBounds.left + (obstacleVelocityX / fps);
        obstacleBounds.top = obstacleBounds.top + (obstacleVelocityY / fps);
        obstacleBounds.right = obstacleBounds.left + obstacleWidth;
        obstacleBounds.bottom = obstacleBounds.top + obstacleHeight;
    }

    void obstacleSpawn(int pX, int pY, int vY){
        //X-coordinate, y-coordinate, y-velocity. Obstacles should have an x-velocity of 0
        obstacleBounds.left = pX;
        obstacleBounds.top = pY;
        obstacleBounds.right = pX + obstacleWidth;
        obstacleBounds.bottom = pY + obstacleHeight;

        obstacleVelocityY *= vY;
    }
}
