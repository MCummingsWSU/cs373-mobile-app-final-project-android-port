package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Background extends MovableGameObject{
    int x = 0, y = 0;
    String backgroundName = "Background";
    boolean backgroundNoCollide = true;
    Color backgroundColor = Color.valueOf(Color.GRAY);
    final int backgroundSpeed = 0;
    Paint backgroundPaint;
    Bitmap backgroundBitmap;
    float backgroundWidth = 1080;
    float backgroundHeight = 1920;
    Resources backgroundResources;


    Background(){
        this.setGameObjectName(backgroundName);
        this.setGameObjectLocation(x, y);
        this.setGameObjectColor(backgroundColor);
        this.backgroundPaint.setColor(backgroundColor.toArgb());
        this.setGameObjectWidth(backgroundWidth);
        this.setGameObjectHeight(backgroundHeight);
        this.setMovableGameObjectSpeed(backgroundSpeed);
        this.setGameObjectNoCollide(backgroundNoCollide);
        this.backgroundBitmap = BitmapFactory.decodeResource(backgroundResources, R.color.gray);
        this.backgroundBitmap = Bitmap.createScaledBitmap(backgroundBitmap, x, y, false);
    }

}
