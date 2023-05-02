package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.graphics.RectF;


/**
 * An interface containing methods for GameObjects. GameObject will be implemented in a MovableGameObject class, which will in turn be used to create subclasses for the player character and the obstacles in the game
 * Rewritten for Android Studio
 *
 * @author Michael Cummings
 * @version 5.1.23
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
     * Method to set a GameObject's width on a 2D grid
     *
     * @param   width GameObject's height
     */
    void setGameObjectWidth(float width);

    /**
     * Method to return a GameObject's width
     *
     * @return  width
     */
    float getGameObjectWidth();

    /**
     * Method to set a GameObject's height on a 2D grid
     *
     * @param height GameObject's height
     */
    void setGameObjectHeight(float height);

    /**
     * Method to return a GameObject's height
     *
     * @return height
     */
    float getGameObjectHeight();

    /**
     * Method to return a Rectangle whose dimensions are equal to the boundaries of the GameObject
     */
    RectF getGameObjectBounds();

    /**
     * Method to return true if two GameObjects intersect at any point
     *
     * @return  collision
     */
    static boolean collision(GameObject a, GameObject b) {
        return RectF.intersects(a.getGameObjectBounds(), b.getGameObjectBounds());
    }

    void gameObjectUpdate(long fps);
}

