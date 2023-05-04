package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

import java.util.Random;

public class Game extends SurfaceView implements Runnable{
    private final boolean DEBUGGING = true;
    private final String GAME_TITLE = "ObstacleGame";
    private SurfaceHolder mGameSurfaceHolder;
    private Canvas mCanvas;
    private Paint mPaint;
    private long mFramesPerSecond;
    private final int MILLIS_IN_SECOND = 1000;
    private int mScreenWidth;
    private int mScreenHeight;
    private int mFontSize;
    private int mFontMargin;
    private Player mGamePlayerCharacter;
    private Obstacle[] mGameObstacles = new Obstacle[10];
    private int mNumGameObstacles;
    private int mGamePlayerContinuesRemaining;
    private long mGamePointsScore;
    private long mGamePointsScoreCounter;
    private long mGamePointsScoreHighScore;
    private int mGameDifficultyLevel;
    private Random mGameRandomGenerator;
    private Thread mGameThread = null;
    private volatile boolean mPlaying;
    private boolean mPaused = true;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Game(Context context, int screenWidth, int screenHeight){

        super(context);

        mScreenWidth = screenWidth;
        mScreenHeight = screenHeight;

        mFontSize = mScreenWidth / 20;
        mFontMargin = mScreenWidth / 75;

        mGameSurfaceHolder = getHolder();
        mPaint = new Paint();

        mGamePlayerCharacter = new Player(screenWidth, screenHeight);


        for(int i = 0; i < mGameObstacles.length; i++){
            mGameObstacles[i] = new Obstacle(screenWidth);
        }

        startNewGame();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startNewGame(){

        mGamePlayerContinuesRemaining = 2;
        mGamePointsScore = 0;
        mGamePointsScoreCounter = 0;
        mGameDifficultyLevel = 0;
        mGameRandomGenerator = new Random();

        for(int i = 0; i < mGameObstacles.length; i++){
            mGameObstacles[i].obstacleSpawn(mGameRandomGenerator.nextInt(mScreenWidth), 0, 1);
        }

    }

    private void draw(){
        if(mGameSurfaceHolder.getSurface().isValid()){
            mCanvas = mGameSurfaceHolder.lockCanvas();
            mCanvas.drawColor(Color.GRAY); //Background

            mCanvas.drawRect(mGamePlayerCharacter.getGameObjectBounds(), mGamePlayerCharacter.playerPaint);


            mPaint.setColor(Color.RED);
            for(int i = 0; i < mGameObstacles.length; i++){
                mCanvas.drawRect(mGameObstacles[i].getGameObjectBounds(), mPaint);
            }

            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(mFontSize);

            mCanvas.drawText(
                    "Score: " + mGamePointsScore,
                    mScreenWidth - (mPaint.measureText("Score: " + mGamePointsScore) + mFontMargin),
                    mFontSize,
                    mPaint);
            mCanvas.drawText(
                    "Lives: " + mGamePlayerContinuesRemaining,
                    mScreenWidth - (mPaint.measureText("Lives: " + mGamePlayerContinuesRemaining) + mFontMargin),
                    mFontSize * 2,
                    mPaint);
            mPaint.setColor(Color.GREEN);
            mCanvas.drawText(
                    "High Score: " + mGamePointsScoreHighScore,
                    mScreenWidth - (mPaint.measureText("High Score: " + mGamePointsScoreHighScore) + mFontMargin),
                    mFontSize * 3,
                    mPaint);

            if(DEBUGGING){
                printDebuggingText();
            }

            mGameSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }

    private void printDebuggingText(){
        int debugSize = mFontSize / 2;
        int debugStart = 150;
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(debugSize);
        mCanvas.drawText(
                "FPS: " + mFramesPerSecond,
                10,
                debugStart + debugSize,
                mPaint);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void run() {

        while(mPlaying){
            long frameStartTime = System.currentTimeMillis();
            if(!mPaused){
                
                update();
                checkCollisions();
                
            }
            draw();
            
            long timeThisFrame =
                    System.currentTimeMillis() - frameStartTime;
            
            if(timeThisFrame > 0){
                
                mFramesPerSecond = MILLIS_IN_SECOND / timeThisFrame;
                
            }
            
        }

    }

    private void checkCollisions() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void update() {

        mGamePlayerCharacter.update(mFramesPerSecond);

        for(int i = 0; i < mGameObstacles.length; i++) {
            mGameObstacles[i].update(mFramesPerSecond);
        }
        
    }

    public void pause(){
        mPlaying = false;
        try {
            mGameThread.join();
        } catch (InterruptedException e) {
            Log.e("Error:", "joining thread");
        }
    }

    public void resume(){
        mPlaying = true;
        mGameThread = new Thread(this);
        mGameThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        switch (motionEvent.getAction() &
                MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                mPaused = false;
                if(motionEvent.getX() > mScreenWidth / 2){
                    //right side of the screen
                    mGamePlayerCharacter.setPlayerMovementState(mGamePlayerCharacter.RIGHT);
                }
                else{
                    //left side of the screen
                    mGamePlayerCharacter.setPlayerMovementState(mGamePlayerCharacter.LEFT);
                }
                break;

            case MotionEvent.ACTION_UP:
                mGamePlayerCharacter.setPlayerMovementState(mGamePlayerCharacter.STOPPED);
                break;
        }
        return true;
    }
}