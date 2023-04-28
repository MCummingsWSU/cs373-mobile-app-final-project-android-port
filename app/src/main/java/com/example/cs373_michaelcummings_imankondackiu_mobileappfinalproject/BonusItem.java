package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

/**
 * Class representing a MovableGameObject the player is rewarded for colliding with
 * Could be bonus points, shield, speed boost, etc.
 * Rewritten for Android Studio
 *
 * @author Michael Cummings
 * @version 4.24.23
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class BonusItem extends MovableGameObject
{
    String bonusItemName = "BonusItem";
    Color bonusItemColor = Color.valueOf(Color.YELLOW);
    int bonusItemWidth = 4;
    int bonusItemHeight = 4;
    int bonusItemSpeed = 1;

    /**
     * Constructor for objects of class BonusItem
     */
    public BonusItem()
    {
        super();
        this.setGameObjectName(bonusItemName);
        this.setGameObjectColor(bonusItemColor);
        this.setGameObjectWidth(bonusItemWidth);
        this.setGameObjectHeight(bonusItemHeight);
        this.setMovableGameObjectSpeed(bonusItemSpeed);
    }

    /**
     * Overloaded constructor for BonusItem objects
     */
    public BonusItem(int x, int y)
    {
        super();
        this.setGameObjectName(bonusItemName);
        this.setGameObjectColor(bonusItemColor);
        this.setGameObjectWidth(bonusItemWidth);
        this.setGameObjectHeight(bonusItemHeight);
        this.setMovableGameObjectSpeed(bonusItemSpeed);
        this.setGameObjectLocation(x, y);
    }
}

