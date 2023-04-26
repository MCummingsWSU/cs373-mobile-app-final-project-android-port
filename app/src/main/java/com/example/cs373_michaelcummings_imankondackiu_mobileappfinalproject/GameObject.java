package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;


/**
 * An interface containing methods for GameObjects. GameObject will be implemented in a MovableGameObject class, which will in turn be used to create subclasses for the player character and the obstacles in the game
 * Rewritten for Android Studio
 *
 * @author Michael Cummings
 * @version 4.24.23
 */
public interface GameObject
{
    /**
     * Method to set a GameObject's name
     *
     * @param   name GameObject's name
     */
    void setGameObjectName(String name);

    /**
     * Method to return a GameObject's name
     *
     * @return  name
     */
    String getGameObjectName();

    /**
     * Method to set a GameObject's Color
     *
     * @param   color   Android Graphics Color object
     */
    void setGameObjectColor(Color color);

    /**
     * Method to return a GameObject's Color
     *
     * @return  color
     */
    Color getGameObjectColor();

    /**
     * Method to return a GameObject's Paint
     */
    Paint getGameObjectPaint();

    /**
     * Method to set a GameObject's location on a 2D grid using integer x and y-coordinates
     *
     * @param   x, y
     */
    void setGameObjectLocation(int x, int y);

    /**
     * Method to set a GameObject's location on a 2D grid using double x and y-coordinates
     *
     * @return  x, y
     */
    Point getGameObjectLocation();

    /**
     * Method to set a GameObject's width on a 2D grid
     *
     * @param   width GameObject's height
     */
    void setGameObjectWidth(double width);

    /**
     * Method to return a GameObject's width
     *
     * @return  width
     */
    double getGameObjectWidth();

    /**
     * Method to set a GameObject's height on a 2D grid
     *
     * @param height GameObject's height
     */
    void setGameObjectHeight(double height);

    /**
     * Method to return a GameObject's height
     *
     * @return height
     */
    double getGameObjectHeight();

    /**
     * Method to grow a GameObject's width and height by dw, dh
     *
     * @param   dw, dh
     */
    void growGameObjectSize(double dw, double dh);

    /**
     * Method to shrink a GameObject's width and height by dw, dh
     * Calls growGameObjectSize
     *
     * @param   dw, dh
     */
    void shrinkGameObjectSize(double dw, double dh);

    /**
     * Method to return a Rectangle whose dimensions are equal to the boundaries of the GameObject
     */
    Rect getGameObjectBounds();

    /**
     * Method to return true if two GameObjects intersect at any point
     *
     * @return  collision
     */
    static boolean collision(GameObject a, GameObject b)
    {
        if(!a.getGameObjectNoCollide() && !b.getGameObjectNoCollide())
        {
            return Rect.intersects(a.getGameObjectBounds(), b.getGameObjectBounds());
        }
        return false;
    }

    /**
     * Method to set a boolean indicating whether a GameObject should not collide with other GameObjects
     *
     * @param   noCollide flag representing whether a GameObject will be checked for collision with other GameObjects
     *                    if True, this GameObject will not cause a method call to GameObject.collision() when intersecting other objects
     */
    void setGameObjectNoCollide(boolean noCollide);

    /**
     * Method to return true if a GameObject should be not be able to collide with other game objects
     *
     * @return  noCollide
     */
    boolean getGameObjectNoCollide();
}

