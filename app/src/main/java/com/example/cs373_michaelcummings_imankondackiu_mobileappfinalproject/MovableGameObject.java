package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
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
    private Point gameObjectLocation = new Point();
    private float gameObjectWidth, gameObjectHeight, gameObjectVelocityX, gameObjectVelocityY;
    private String gameObjectName;
    private Color gameObjectColor;
    private boolean gameObjectNoCollide;
    private Paint gameObjectPaint = new Paint();
    private Bitmap gameObjectBitmap;
    private Resources gameObjectResources;

    /**
     * Default constructor for MovableGameObject
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MovableGameObject(int screenWidth)
    {
        this.gameObjectName = "ObjectName";
        this.gameObjectColor = Color.valueOf(Color.RED);
        this.gameObjectPaint.setColor(this.gameObjectColor.toArgb());
        this.gameObjectBitmap = BitmapFactory.decodeResource(this.gameObjectResources, R.color.red);
        this.gameObjectLocation.set(0,0);
        this.gameObjectWidth = screenWidth / 100;
        this.gameObjectHeight = screenWidth / 100;
        this.gameObjectBounds = new RectF();
        this.gameObjectVelocityX = 0;
        this.gameObjectVelocityY = 0;
        this.gameObjectNoCollide = false;

        this.gameObjectBitmap = Bitmap.createScaledBitmap(gameObjectBitmap, (int)gameObjectWidth, (int)gameObjectHeight, false);
    }

    /**
     * Overloaded constructor for objects of class MovableGameObject
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MovableGameObject(Color color, int locationX, int locationY, String name, float width, float height, float vx, float vy, boolean noCollide)
    {
        this.gameObjectName = name;
        this.gameObjectColor = color;
        this.gameObjectPaint.setColor(this.gameObjectColor.toArgb());
        this.gameObjectBitmap = BitmapFactory.decodeResource(gameObjectResources, R.color.red);
        this.gameObjectLocation.set(locationX, locationY);
        this.gameObjectWidth = width;
        this.gameObjectHeight = height;

        this.gameObjectBounds = new RectF(
                this.gameObjectLocation.x,
                this.gameObjectLocation.y,
                (this.gameObjectLocation.x + this.gameObjectWidth),
                (this.gameObjectLocation.y + this.gameObjectHeight)
        );

        this.gameObjectVelocityX = vx;
        this.gameObjectVelocityY = vy;
        this.gameObjectNoCollide = noCollide;

        this.gameObjectBitmap = Bitmap.createScaledBitmap(gameObjectBitmap, (int)gameObjectWidth, (int)gameObjectHeight, false);

    }

    /**
     * Method to manually set a GameObject's Color
     *
     * @param   color
     */
    public void setGameObjectColor(Color color)
    {
        this.gameObjectColor = color;
    }

    /**
     * Method to return a GameObject's Color
     *
     * @return Color
     */
    public Color getGameObjectColor()
    {
        return this.gameObjectColor;
    }

    /**
     * Method to return a GameObject's Paint
     *
     * @return Paint
     */
    public Paint getGameObjectPaint() {return this.gameObjectPaint;}

    /**
     * Method to manually set a GameObject's Point location
     *
     * @param   x,y intended x-coordinate and y-coordinate of the object
     */

    public void setGameObjectLocation(int x, int y) {
        this.gameObjectLocation.set(x, y);
    }

    /**
     * Method to return a GameObject's Point location
     *
     * @return  Point
     */
    public Point getGameObjectLocation() {return this.gameObjectLocation;}

    /**
     * Method to manually set a GameObject's name
     *
     * @param   name
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

    /**
     * Method to manually set a GameObject's width
     *
     * @param   width
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
     * @param   height
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
     * Method to grow a GameObject's width and height by dw, dh
     *
     * @param   dw, dh
     */
    public void growGameObjectSize(float dw, float dh)
    {
        this.gameObjectWidth = this.gameObjectWidth + dw;
        this.gameObjectHeight = this.gameObjectHeight + dh;
    }

    /**
     * Method to shrink a GameObject's width and height by dw, dh
     * Calls growGameObjectSize
     *
     * @param   dw, dh
     */
    public void shrinkGameObjectSize(float dw, float dh)
    {
        this.growGameObjectSize(-dw, -dh);
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

    /**
     * Method to set a boolean indicating whether a GameObject should not collide with other GameObjects
     *
     * @param   noCollide
     */
    public void setGameObjectNoCollide(boolean noCollide)
    {
        this.gameObjectNoCollide = noCollide;
    }

    public boolean getGameObjectNoCollide()
    {
        return this.gameObjectNoCollide;
    }

    public void translateMovableGameObject(int dx, int dy)
    {
        this.gameObjectLocation.offset(dx, dy);
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

    public void gameObjectUpdate(long fps){

    }
}

