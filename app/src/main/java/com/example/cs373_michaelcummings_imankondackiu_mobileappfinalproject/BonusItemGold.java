package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;


import android.os.Build;

import androidx.annotation.RequiresApi;

/**
 * Class representing a BonusItemGold MovableGameObject
 * Adds a set amount to Game.gamePointsScore
 * Rewritten for Android Studio
 *
 * @author Michael Cummings
 * @version 4.24.23
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class BonusItemGold extends BonusItem
{
    String bonusItemName = "BonusItemGold";
    final int GOLD_POINT_VALUE = 500;
    int bonusItemPointValue;

    /**
     * Constructor for objects of class BonusItemGold
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public BonusItemGold()
    {
        super();
        this.setGameObjectName(bonusItemName);
        this.setBonusItemPointValue(GOLD_POINT_VALUE);
    }

    /**
     * Constructor for objects of class BonusItemGold
     */
    public BonusItemGold(int x, int y)
    {
        super();
        this.setGameObjectName(bonusItemName);
        this.setBonusItemPointValue(GOLD_POINT_VALUE);
        this.setGameObjectLocation(x, y);
    }

    /**
     * Method to set a BonusItem's point value to grant to the player when collided with
     *
     * @param  points
     */
    public void setBonusItemPointValue(int points)
    {
        this.bonusItemPointValue = points;
    }

    /**
     * Method to get a BonusItem's point value
     *
     * @return  points
     */
    public int getBonusItemPointValue()
    {
        return this.bonusItemPointValue;
    }
}

