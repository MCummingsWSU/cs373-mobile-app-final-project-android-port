package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;

import androidx.annotation.RequiresApi;


/**
 * A parent class for entities within a video game (player and non-player characters, collectable items, barriers, etc.)
 * Rewritten for Android Studio
 *
 * @author Michael Cummings
 * @version 4.28.2023
 */
public class MovableGameObject implements GameObject
{
    private Point gameObjectLocation = new Point();
    private double gameObjectWidth, gameObjectHeight, gameObjectSpeed;
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
    public MovableGameObject()
    {
        this.gameObjectName = "ObjectName";
        this.gameObjectColor = Color.valueOf(Color.RED);
        this.gameObjectPaint.setColor(this.gameObjectColor.toArgb());
        this.gameObjectBitmap = BitmapFactory.decodeResource(this.gameObjectResources, R.color.red);
        this.gameObjectLocation.set(0,0);
        this.gameObjectWidth = 1;
        this.gameObjectHeight = 1;
        this.gameObjectSpeed = 0;
        this.gameObjectNoCollide = false;

        this.gameObjectBitmap = Bitmap.createScaledBitmap(gameObjectBitmap, (int)gameObjectWidth, (int)gameObjectHeight, false);
    }

    /**
     * Overloaded constructor for objects of class MovableGameObject
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MovableGameObject(Color color, int locationX, int locationY, String name, double width, double height, double speed, boolean noCollide)
    {
        this.gameObjectName = name;
        this.gameObjectColor = color;
        this.gameObjectPaint.setColor(this.gameObjectColor.toArgb());
        this.gameObjectBitmap = BitmapFactory.decodeResource(gameObjectResources, R.color.red);
        this.gameObjectLocation.set(locationX, locationY);
        this.gameObjectWidth = width;
        this.gameObjectHeight = height;
        this.gameObjectSpeed = speed;
        this.gameObjectNoCollide = noCollide;
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
    public void setGameObjectWidth(double width)
    {
        this.gameObjectWidth = width;
    }

    /**
     * Method to return a GameObject's width
     *
     * @return  width
     */
    public double getGameObjectWidth()
    {
        return this.gameObjectWidth;
    }

    /**
     * Method to manually set a GameObject's height
     *
     * @param   height
     */
    public void setGameObjectHeight(double height)
    {
        this.gameObjectHeight = height;
    }

    /**
     * Method to return a GameObject's height
     *
     * @return  height
     */
    public double getGameObjectHeight()
    {
        return this.gameObjectHeight;
    }

    /**
     * Method to grow a GameObject's width and height by dw, dh
     *
     * @param   dw, dh
     */
    public void growGameObjectSize(double dw, double dh)
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
    public void shrinkGameObjectSize(double dw, double dh)
    {
        this.growGameObjectSize(-dw, -dh);
    }

    /**
     * Method to return a Rectangle with dimensions equal to the coordinate boundaries of the GameObject
     */
    public Rect getGameObjectBounds(){
        return new Rect(
                this.gameObjectLocation.x,
                this.gameObjectLocation.y,
                (int)this.gameObjectWidth + this.gameObjectLocation.x,
                (int)this.gameObjectHeight + this.gameObjectLocation.y);
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

    /**
     * Method to return true if a GameObject should not collide with other GameObjects
     *
     * @return  noCollide
     */
    public boolean getGameObjectNoCollide()
    {
        return this.gameObjectNoCollide;
    }

    /**
     * Method to set a MovableGameObject's speed
     *
     * @param speed
     */
    public void setMovableGameObjectSpeed(int speed)
    {
        this.gameObjectSpeed = speed;
    }

    /**
     * Method to return a MovableGameObject's speed
     *
     * @return  speed
     */
    public double getMovableGameObjectSpeed()
    {
        return this.gameObjectSpeed;
    }

    /**
     * Method to translate a MovableGameObject along the x or y axis
     *
     * @param dx, dy
     */
    public void translateMovableGameObject(int dx, int dy)
    {
        this.gameObjectLocation.offset(dx, dy);
    }
}

