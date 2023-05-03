package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;

import androidx.annotation.RequiresApi;


/**
 * A parent class for entities within a video game (player and non-player characters, collectable items, barriers, etc.)
 * Rewritten for Android Studio
 *
 * @author Michael Cummings
 * @version 5.1.2023
 */
public class MovableGameObject implements GameObject
{
    private RectF gameObjectBounds;
    private float gameObjectWidth, gameObjectHeight, gameObjectVelocityX, gameObjectVelocityY;
    private String gameObjectName;
    private Paint gameObjectPaint;
    private int gameObjectColor = Color.WHITE; //Default

    /**
     * Default constructor for MovableGameObject
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MovableGameObject(int screenWidth)
    {
        this.gameObjectName = "ObjectName";
        this.gameObjectWidth = screenWidth / 100;
        this.gameObjectHeight = screenWidth / 100;
        this.gameObjectBounds = new RectF();
        this.gameObjectVelocityX = 0;
        this.gameObjectVelocityY = 0;

        this.gameObjectPaint = new Paint();
        this.gameObjectPaint.setColor(gameObjectColor);
    }

    public MovableGameObject(int screenWidth, int screenHeight){

        this.gameObjectName = "ObjectName";
        this.gameObjectWidth = screenWidth / 100;
        this.gameObjectHeight = screenHeight / 100;
        this.gameObjectBounds = new RectF();
        this.gameObjectVelocityX = 0;
        this.gameObjectVelocityY = 0;

        this.gameObjectColor = gameObjectColor;
        this.gameObjectPaint = new Paint();
        this.gameObjectPaint.setColor(gameObjectColor);

    }

    /**
     * Method to manually set a GameObject's name
     *
     * @param   name    String name of the MovableGameObject
     */
    public void setGameObjectName(String name)
    {
        this.gameObjectName = name;
    }

    /**
     * Method to return a GameObject's Name
     *
     * @return  Name
     */
    public String getGameObjectName()
    {
        return this.gameObjectName;
    }

    @Override
    public int getGameObjectColor() {
        return this.gameObjectColor;
    }

    @Override
    public void setGameObjectColor(int color) {
        this.gameObjectColor = color;
    }

    @Override
    public Paint getGameObjectPaint() {
        return this.gameObjectPaint;
    }

    @Override
    public void setGameObjectPaint(int flags) {
        this.gameObjectPaint = new Paint(flags);
    }

    /**
     * Method to manually set a GameObject's width
     *
     * @param   width   float representing the width of the MovableGameObject on the screen space
     */
    public void setGameObjectWidth(float width)
    {
        this.gameObjectWidth = width;
    }

    /**
     * Method to return a GameObject's width
     *
     * @return  width
     */
    public float getGameObjectWidth()
    {
        return this.gameObjectWidth;
    }

    /**
     * Method to manually set a GameObject's height
     *
     * @param   height  float representing the height of the MovableGameObject on the screen space
     */
    public void setGameObjectHeight(float height)
    {
        this.gameObjectHeight = height;
    }

    /**
     * Method to return a GameObject's height
     *
     * @return  height
     */
    public float getGameObjectHeight()
    {
        return this.gameObjectHeight;
    }

    /**
     * Method to return a Rectangle with dimensions equal to the coordinate boundaries of the GameObject
     */
    public void setGameObjectBounds(RectF gameObjectBounds) {
        this.gameObjectBounds = gameObjectBounds;
    }
    public RectF getGameObjectBounds() {
        return gameObjectBounds;
    }

    public float getGameObjectVelocityX() {
        return gameObjectVelocityX;
    }

    public void setGameObjectVelocityX(float gameObjectVelocityX) {
        this.gameObjectVelocityX = gameObjectVelocityX;
    }

    public float getGameObjectVelocityY() {
        return gameObjectVelocityY;
    }

    public void setGameObjectVelocityY(float gameObjectVelocityY) {
        this.gameObjectVelocityY = gameObjectVelocityY;
    }

    /**
     * Method detailing how to update the MovableGameObject's position
     * Takes a long of the application's frames per second as an argument
     *
     * @param fps   screen's refresh rate
     */
    public void update(long fps){
        gameObjectBounds.left += (gameObjectVelocityX / fps);
        gameObjectBounds.top += (gameObjectVelocityY / fps);
        gameObjectBounds.right = gameObjectBounds.left + gameObjectWidth;
        gameObjectBounds.bottom = gameObjectBounds.top + gameObjectHeight;
    }
}

